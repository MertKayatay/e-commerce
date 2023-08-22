package project.ECommerce.ecommerce.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.ECommerce.ecommerce.business.abstracts.ProductService;
import project.ECommerce.ecommerce.business.dto.requests.create.CreateProductRequest;
import project.ECommerce.ecommerce.business.dto.requests.update.UpdateProductRequest;
import project.ECommerce.ecommerce.business.dto.responses.create.CreateProductResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetAllProductsResponse;
import project.ECommerce.ecommerce.business.dto.responses.get.GetProductResponse;
import project.ECommerce.ecommerce.business.dto.responses.update.UpdateProductResponse;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable long id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){

        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable long id, @Valid @RequestBody UpdateProductRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        service.delete(id);
    }

}
