package project.ECommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ECommerce.ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByNameIgnoreCase(String name);

}
