package com.company.project.register.product;

import com.company.project.register.product.application.usecases.CreateProductUseCaseImpl;
import com.company.project.register.product.application.usecases.find.FindProductByPartNumberUseCaseImpl;
import com.company.project.register.product.application.usecases.find.FindProductByUpcUseCaseImpl;
import com.company.project.register.product.data.DataProduct;
import com.company.project.register.product.infrastructure.ProductRepository;
import com.company.project.register.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;


@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private FindProductByPartNumberUseCaseImpl findProductByPartNumberUseCase;

    @InjectMocks
    private FindProductByUpcUseCaseImpl findProductByUpcUseCase;

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @BeforeEach
    void setUp() {
    ////        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Finding product by part_number")
    void FindByByPartNumber() {
        // given
        when(repository.findAll()).thenReturn(DataProduct.PRODUCTS);

        // when
        String search = "part_number1";
        Optional<Product>  optionalProduct = findProductByPartNumberUseCase.execute(search);

        // then
        assertTrue(optionalProduct.isPresent());
        assertEquals(search , optionalProduct.orElseThrow().getPartNumber());

        verify(repository).findAll();
    }

    @Test
    void FindEmpty() {
        // Given
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        String search = "part_number1";
        Optional<Product> product = findProductByPartNumberUseCase.execute(search);

        // then
        assertFalse(product.isPresent());
        verify(repository).findAll();
    }

    @Test
    void create() {

        // Given

        // primera version sin genera id
        // when(repository.save(any(Product.class))).thenReturn(DataProduct.PRODUCT);
        // Generando el ID
        when(repository.save(any(Product.class))).then(new Answer<Product>(){
            @Override
            public Product answer(InvocationOnMock invocationOnMock) throws Throwable {
                Product product = invocationOnMock.getArgument(0);
                product.setId(UUID.randomUUID());
                return product;
            }
        });

        // When
        Product product = createProductUseCase.save(DataProduct.PRODUCT);

        // Then
        assertNotNull(product);
        assertEquals(product.getUpc(), "upc from static");
        verify(repository).save(any(Product.class));

    }

    @Test
    void handleException() {
        
        when(repository.findByUpc(anyString())).thenThrow(IllegalArgumentException.class);
        Exception exception =  assertThrows(IllegalArgumentException.class, ()->{
            findProductByUpcUseCase.execute(anyString());
        });

        assertEquals(IllegalArgumentException.class, exception.getClass() );
        verify(repository).findByUpc(anyString());
    }

    @Test
    void handlerExceptionMatcher() {

        when(repository.findAll()).thenReturn(DataProduct.PRODUCTS);
        findProductByPartNumberUseCase.execute("part_number2");
        verify(findProductByPartNumberUseCase).execute("part_number2");

        verify(repository).findAll();

    }

}
