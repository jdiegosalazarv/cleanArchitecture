package co.com.cleanarchitecture.api.infraestructure.adapters.jpa.entity;

import co.com.cleanarchitecture.api.domain.model.product.Product;
import co.com.cleanarchitecture.api.domain.model.product.ProductId;
import co.com.cleanarchitecture.api.domain.model.product.ProductName;
import co.com.cleanarchitecture.api.domain.model.product.ProductPrice;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;


    public Product toDomain(ProductDBO productDBO){
        return new Product(
                new ProductId(productDBO.getId()),
                new ProductName(productDBO.getName()),
                new ProductPrice(productDBO.getPrice())
        );
    }

    public ProductDBO fromDomain(Product product){
        return new ProductDBO(
                product.getId().getValue(),
                product.getName().getValue(),
                product.getPrice().getValue()
        );
    }
}
