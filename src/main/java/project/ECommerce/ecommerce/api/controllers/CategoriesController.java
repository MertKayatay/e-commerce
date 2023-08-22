package project.ECommerce.ecommerce.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.ECommerce.ecommerce.business.abstracts.CategoryService;
import project.ECommerce.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import project.ECommerce.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import project.ECommerce.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetAllCategoriesResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetCategoryResponse;
import project.ECommerce.ecommerce.business.dto.responses.update.UpdateCategoryResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private final CategoryService service;
    @GetMapping
    public List<GetAllCategoriesResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(CreateCategoryRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable  long id, @Valid @RequestBody UpdateCategoryRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        service.delete(id);
    }
}
