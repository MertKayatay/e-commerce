package project.ECommerce.ecommerce.business.dto.requests.create;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    private long categoryId;
    private String name;
    @Min(value = 1)
    private double price;
    private String description;
}
