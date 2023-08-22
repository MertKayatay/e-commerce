package project.ECommerce.ecommerce.business.abstracts;

import project.ECommerce.ecommerce.business.dto.requests.create.CreateProductRequest;
import project.ECommerce.ecommerce.business.dto.requests.update.UpdateProductRequest;
import project.ECommerce.ecommerce.business.dto.responses.create.CreateProductResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetProductResponse;
import project.ECommerce.ecommerce.business.dto.responses.update.UpdateProductResponse;


import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(long id);
    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(long id, UpdateProductRequest request);
    void delete(long id);
}
