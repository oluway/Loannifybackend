package com.loannify.loannify.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loannify.loannify.loanRequest.Loan;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private Long minimumAmount;
    private Long maximumAmount;
    private Float interestRate;
    private String note;
    public Date requestAt = new Date();



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Set <Loan> loanApplication = new HashSet<>();

    public Product() {
    }

    public Product(Long productId, Long minimumAmount, Long maximumAmount, Float interestRate, String note, Date requestAt) {
        this.productId = productId;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.interestRate = interestRate;
        this.note = note;
        this.requestAt = requestAt;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Long minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public Long getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(Long maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(Date requestAt) {
        this.requestAt = requestAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", minimumAmount=" + minimumAmount +
                ", maximumAmount=" + maximumAmount +
                ", interestRate=" + interestRate +
                ", note='" + note + '\'' +
                ", requestAt=" + requestAt +
                '}';
    }


    public void setLoanApplication(Set<Loan> loanApplication) {
        this.loanApplication = loanApplication;
    }

    public Set<Loan> getLoanApplication() {
        return loanApplication;
    }
    public void insertLoanApplication(Loan loanData) {
        loanApplication.add(loanData);
    }
}
