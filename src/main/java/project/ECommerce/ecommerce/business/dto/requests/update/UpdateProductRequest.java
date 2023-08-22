package project.ECommerce.ecommerce.business.dto.requests.update;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private long categoryId;
    private String name;
    private double price;
    private String description;
}
