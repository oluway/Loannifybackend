package com.loannify.loannify.product;

import com.loannify.loannify.loanRequest.Loan;
import com.loannify.loannify.product.Product;
import com.loannify.loannify.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PutMapping("/application/product/{productId}")
    public Product applyForLoanUnderProduct(@PathVariable Long productId, @RequestBody Loan loan){
        return productService.applyForLoanUnderProduct(productId, loan);
    }
}
