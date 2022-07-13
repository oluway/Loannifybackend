package com.loannify.loannify.product;

import com.loannify.loannify.loanRequest.Loan;
import com.loannify.loannify.loanRequest.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LoanRepository loanRepository;


    public ProductService(ProductRepository productRepository, LoanRepository loanRepository) {
        this.productRepository = productRepository;
        this.loanRepository = loanRepository;
    }

    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product applyForLoanUnderProduct(Long productId, Loan loan) {
        Loan loanData = loanRepository.save(loan);
        Loan savedData = loanRepository.findById(loanData.loanId).get();
        Product product = productRepository.findById(productId).get();
        product.insertLoanApplication(savedData);
        System.out.println("What is here... " + savedData);
        return productRepository.save(product);
    }
}
