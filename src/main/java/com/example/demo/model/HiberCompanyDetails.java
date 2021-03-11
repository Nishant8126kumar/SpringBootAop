package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "hiberCompanyDetails")
public class HiberCompanyDetails {
    @Id
    @Column(name = "companyDetailsId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;


    public HiberCompanyDetails() {
    }


    public HiberCompanyDetails(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
