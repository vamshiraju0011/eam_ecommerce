package com.example.productsservice.service;

import com.example.productsservice.entity.Product;
import com.example.productsservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProductStock(Long id, int newStock) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setStock(newStock);
            productRepository.save(product);
            kafkaProducerService.sendStockUpdate(product.getId().toString(), newStock);  // Send stock update to Kafka
        }
        return product;
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            kafkaProducerService.sendProductDeletion(product.getId().toString());  // Send product deletion to Kafka
        }
    }
}