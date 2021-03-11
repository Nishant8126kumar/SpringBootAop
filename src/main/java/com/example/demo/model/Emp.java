package com.example.demo.model;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empId")
    private int empId;
    @Column
    private String empName;

    private String updatedBy;

    @ManyToMany
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "account_id")
    private List<EmpAccount> empAccountDetailsList;

    public Emp() {
    }

    public Emp(String updatedBy,int empId) {
        this.empId=empId;
        this.empName=updatedBy;
    }


    public Emp(String empName, String updatedBy) {
        this.empName = empName;
        this.updatedBy = updatedBy;
    }

    public Emp(int empId, String empName, String updatedBy, List<EmpAccount> empAccountDetailsList) {
        this.empId = empId;
        this.empName = empName;
        this.updatedBy = updatedBy;
        this.empAccountDetailsList = empAccountDetailsList;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<EmpAccount> getEmpAccountDetailsList() {
        return empAccountDetailsList;
    }

    public void setEmpAccountDetailsList(List<EmpAccount> empAccountDetailsList) {
        this.empAccountDetailsList = empAccountDetailsList;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", empAccountDetailsList=" + empAccountDetailsList +
                '}';
    }


}
