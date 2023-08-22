package project.ECommerce.ecommerce.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.ECommerce.ecommerce.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExistsById(long id){
        if(!repository.existsById(id))
            throw new IllegalArgumentException("Product not found with id: " + id);
    }

    public void checkIfProductExistsByName(String name){
        if(repository.existsByNameIgnoreCase(name))
            throw new IllegalArgumentException("Product already exists with name: " + name);
    }
}
