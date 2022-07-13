package com.loannify.loannify.loanRequest;

import com.loannify.loannify.product.Product;
import com.loannify.loannify.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;




    public Loan saveLoan(Loan loan) {
        return this.loanRepository.save(loan);
    }



}
