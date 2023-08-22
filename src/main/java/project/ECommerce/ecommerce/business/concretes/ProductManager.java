package project.ECommerce.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.ECommerce.ecommerce.business.abstracts.ProductService;
import project.ECommerce.ecommerce.business.dto.requests.create.CreateProductRequest;
import project.ECommerce.ecommerce.business.dto.requests.update.UpdateProductRequest;
import project.ECommerce.ecommerce.business.dto.responses.create.CreateProductResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetProductResponse;
import project.ECommerce.ecommerce.business.dto.responses.update.UpdateProductResponse;
import project.ECommerce.ecommerce.business.rules.ProductBusinessRules;
import project.ECommerce.ecommerce.entities.Product;
import project.ECommerce.ecommerce.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService{
    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final ProductBusinessRules rules;
    @Override
    public List<GetAllProductsResponse> getAll() {
            List<Product> products = productRepository.findAll();
            List<GetAllProductsResponse> response = products
                    .stream()
                    .map(product -> mapper.map(product, GetAllProductsResponse.class))
                    .toList();
            return response;

        }


    @Override
    public GetProductResponse getById(long id) {
        rules.checkIfProductExistsById(id);
        Product product = productRepository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product, GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        rules.checkIfProductExistsByName(request.getName());
        Product product = mapper.map(request, Product.class);
        product.setId(0);
        productRepository.save(product);
        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);
        return response;
    }
    @Override
    public UpdateProductResponse update(long id, UpdateProductRequest request) {
        rules.checkIfProductExistsById(id);
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        productRepository.save(product);
        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);
        return response;
    }

    @Override
    public void delete(long id) {
        rules.checkIfProductExistsById(id);
        productRepository.deleteById(id);
    }
}
