package com.example.demo.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "hiberDemo")
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("data analyst")
public class HiberCompany {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "companyName")
    private String name;

    @OneToOne
    @JoinColumn(name = "Status")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private HiberCompanyDetails hiberCompanyDetails;

    public HiberCompany(int id, String name, HiberCompanyDetails hiberCompanyDetails) {
        this.id = id;
        this.name = name;
        this.hiberCompanyDetails = hiberCompanyDetails;
    }

    public HiberCompany() {
    }

    @Override
    public String toString() {
        return "HiberCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hiberCompanyDetails=" + hiberCompanyDetails +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HiberCompanyDetails getHiberCompanyDetails() {
        return hiberCompanyDetails;
    }

    public void setHiberCompanyDetails(HiberCompanyDetails hiberCompanyDetails) {
        this.hiberCompanyDetails = hiberCompanyDetails;
    }
}
