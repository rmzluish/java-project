package com.company.project.register.product.data;

import com.company.project.register.product.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DataProduct {

    public final static List<Product> PRODUCTS = Arrays.asList(
                new Product("UPC_001","sku1","part_number1","sat code1"),
                new Product("upc2","sku2","part_number2","sat code2"),
                new Product("upc3","sku3","part_number3","sat code3"),
                new Product("UPC_002","sku4","part_number4","sat code4")
        );


    public final static Product PRODUCT = new Product("upc from static","sku from static","part number from static","sat code from static");

    public final static Optional<Product> OPT_PRODUCT = null;

}
