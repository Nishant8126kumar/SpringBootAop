package com.example.demo.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
public class EmpAccount {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int acId;

    @Column
    private String bankName;
    @Column
    private int accountNo;

    @ManyToMany
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "emp_id")
    private List<Emp> empDetails;

    public EmpAccount() {
    }

    public EmpAccount(String bankName,int accountNo) {
        this.bankName = bankName;
    }

    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public List<Emp> getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(List<Emp> empDetails) {
        this.empDetails = empDetails;
    }

    public EmpAccount(int acId, String bankName, int accountNo, List<Emp> empDetails) {
        this.acId = acId;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.empDetails = empDetails;
    }

    @Override
    public String toString() {
        return "EmpAccount{" +
                "acId=" + acId +
                ", bankName='" + bankName + '\'' +
                ", accountNo=" + accountNo +
                ", empDetails=" + empDetails +
                '}';
    }
}
