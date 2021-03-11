package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "emp_data")
public class EmpEntityDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String empName;

    @Column
    String empAddress;

    @Column
    String empContactno;

    @Column
    String empDesignation;

    @Column
    private String updatedBy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_list_id")
    private List<EmpEduEntity> empListData = new ArrayList<EmpEduEntity>();

    public EmpEntityDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EmpEntityDetails(int id) {
        this.id = id;
    }

    public EmpEntityDetails(String empName, String updatedBy) {
        this.empName = empName;
        this.updatedBy = updatedBy;
    }

    public EmpEntityDetails(int id, String empName, String empAddress, String empContactno, String empDesignation, String updatedBy, List<EmpEduEntity> empListData) {
        this.id = id;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empContactno = empContactno;
        this.empDesignation = empDesignation;
        this.updatedBy = updatedBy;
        this.empListData = empListData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpContactno() {
        return empContactno;
    }

    public void setEmpContactno(String empContactno) {
        this.empContactno = empContactno;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public List<EmpEduEntity> getEmpListData() {
        return empListData;
    }

    public void setEmpListData(List<EmpEduEntity> empListData) {
        this.empListData = empListData;
    }

    @Override
    public String toString() {
        return "EmpEntityDetails{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empContactno='" + empContactno + '\'' +
                ", empDesignation='" + empDesignation + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", empListData=" + empListData +
                '}';
    }
}
