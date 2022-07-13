package com.loannify.loannify.loanRequest;

import com.loannify.loannify.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/loan")
    public Loan saveLoan(@RequestBody Loan loan){
        return loanService.saveLoan(loan);
    }

}
