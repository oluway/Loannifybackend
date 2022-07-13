package com.loannify.loannify.loanRequest;
 import com.fasterxml.jackson.annotation.JsonIgnore;
 import com.loannify.loannify.product.Product;

 import javax.persistence.*;
 import javax.validation.constraints.NotEmpty;
 import javax.validation.constraints.NotNull;
 import javax.validation.constraints.Size;
 import java.util.Date;
 import java.util.HashSet;
 import java.util.Set;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long loanId;
    @Column(name = "loan_amount", nullable = false)
    @NotEmpty
    @Size(min = 4, message = "amount should have at least 2 characters")
    public int loanAmount;
    @NotEmpty
    public String loanDuration;
    public Date requestAt = new Date();
    public Boolean isApproved = false;

    public Date approvedAt = new Date();



    @ManyToMany
    @JoinTable(name="available_product", joinColumns = @JoinColumn(name = "loan_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> enrolledproduct = new HashSet<>();
    public Loan() {
    }

    public Loan( int loanAmount, String loanDuration, Date requestAt, Boolean isApproved, Date approvedAt) {
        this.loanAmount = loanAmount;
        this.loanDuration = loanDuration;
        this.requestAt = requestAt;
        this.isApproved = isApproved;
        this.approvedAt = approvedAt;
    }


    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(String loanDuration) {
        this.loanDuration = loanDuration;
    }

    public Date getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(Date requestAt) {
        this.requestAt = requestAt;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Date getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Date approvedAt) {
        this.approvedAt = approvedAt;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", loanDuration='" + loanDuration + '\'' +
                ", requestAt='" + requestAt + '\'' +
                ", isApproved='" + isApproved + '\'' +
                ", approvedAt='" + approvedAt + '\'' +
                '}';
    }
    public void enrollForProduct(Product product) {
        enrolledproduct.add(product);
    }
}
