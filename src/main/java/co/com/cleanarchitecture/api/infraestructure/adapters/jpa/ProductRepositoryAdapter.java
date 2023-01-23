package co.com.cleanarchitecture.api.infraestructure.adapters.jpa;

import co.com.cleanarchitecture.api.domain.model.gateways.ProductRepository;
import co.com.cleanarchitecture.api.domain.model.product.Product;
import co.com.cleanarchitecture.api.domain.model.product.ProductId;
import co.com.cleanarchitecture.api.domain.model.product.ProductName;
import co.com.cleanarchitecture.api.domain.model.product.ProductPrice;
import co.com.cleanarchitecture.api.domain.model.product.dto.ProductDTO;
import co.com.cleanarchitecture.api.infraestructure.adapters.jpa.entity.ProductDBO;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductAdapterRepository productAdapterRepository;

    public ProductRepositoryAdapter(ProductAdapterRepository productAdapterRepository) {
        this.productAdapterRepository = productAdapterRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        //Convertir en DBO
        ProductDBO productDBO = new ProductDBO().fromDomain(product);

        //Convertir de DBO a Product
        return productDBO.toDomain(this.productAdapterRepository.save(productDBO));
    }
}
