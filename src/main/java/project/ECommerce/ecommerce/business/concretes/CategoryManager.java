package project.ECommerce.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.ECommerce.ecommerce.business.abstracts.CategoryService;
import project.ECommerce.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import project.ECommerce.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import project.ECommerce.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetAllCategoriesResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetCategoryResponse;
import project.ECommerce.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import project.ECommerce.ecommerce.business.rules.CategoryBusinessRules;
import project.ECommerce.ecommerce.entities.Category;
import project.ECommerce.ecommerce.repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final CategoryBusinessRules rules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> response = categories
                .stream()
                .map(category -> mapper.map(category, GetAllCategoriesResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCategoryResponse getById(long id) {
        rules.checkIfCategoryExistsById(id);
        Category category = categoryRepository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category, GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        rules.checkIfCategoryExistsByName(request.getName());
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        categoryRepository.save(category);
        CreateCategoryResponse response = mapper.map(category, CreateCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateCategoryResponse update(long id, UpdateCategoryRequest request) {
        rules.checkIfCategoryExistsById(id);
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        UpdateCategoryResponse response = mapper.map(category, UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(long id) {
        rules.checkIfCategoryExistsById(id);
        categoryRepository.deleteById(id);
    }
}
