package com.ecommerce.ecart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.ecart.entity.Product;
import com.ecommerce.ecart.repository.ProductRepository;
import com.ecommerce.ecart.repository.ProductReviewRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductReviewRepository productReviewRepository;

    @InjectMocks
    private ProductService productService;
    
    @Test
    void shouldReturnProductWhenProductExists() {

        // Arrange
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        // Act
        Product result = productService.getProductById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Laptop", result.getName());

        verify(productRepository, times(1)).findById(1L);
    }
    
    @Test
    void shouldThrowExceptionWhenProductNotFound() {

        // Arrange
        when(productRepository.findById(1L))
                .thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> productService.getProductById(1L));

        assertEquals("Product not found with id 1", exception.getMessage());

        verify(productRepository, times(1)).findById(1L);
    }
}