package com.project.microservices.product.service;

import com.project.microservices.product.dto.ProductRequest;
import com.project.microservices.product.dto.ProductResponse;
import com.project.microservices.product.model.Product;
import com.project.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name()).description(productRequest.description())
                .price(productRequest.price()).build();
       product = productRepository.save(product);
       log.info("Product {} is saved", product.getId());
       return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProduct(){
      return  productRepository.findAll().stream()
                 .map(X -> new ProductResponse(X.getId(), X.getName(), X.getDescription(), X.getPrice()))
                 .toList();
    }
}
