package project.ECommerce.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.ECommerce.ecommerce.repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExistsById(long id){
        if(!repository.existsById(id))
            throw new IllegalArgumentException("Category not found with id: " + id);
    }

    public void checkIfCategoryExistsByName(String name){
        if(repository.existsByNameIgnoreCase(name))
            throw new IllegalArgumentException("Category already exists with name: " + name);
    }
}
