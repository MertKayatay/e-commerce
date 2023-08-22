package project.ECommerce.ecommerce.business.abstracts;

import project.ECommerce.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import project.ECommerce.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import project.ECommerce.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetAllCategoriesResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetCategoryResponse;
import project.ECommerce.ecommerce.business.dto.responses.update.UpdateCategoryResponse;

import java.util.List;
public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(long id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(long id, UpdateCategoryRequest request);
    void delete(long id);

}
