package co.com.cleanarchitecture.api.domain.usecase.product;

import co.com.cleanarchitecture.api.domain.model.gateways.ProductRepository;
import co.com.cleanarchitecture.api.domain.model.product.Product;
import co.com.cleanarchitecture.api.domain.model.product.dto.ProductDTO;

public class ProductUseCase {
    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO saveProduct(ProductDTO producDTO){
        //Convertir en producto
        Product product = producDTO.toDomain(producDTO);

        return producDTO.fromDomain(productRepository.saveProduct(product));
        //Convertir Product a DTO
    }
}
