package project.ECommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ECommerce.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByNameIgnoreCase(String name);

}
