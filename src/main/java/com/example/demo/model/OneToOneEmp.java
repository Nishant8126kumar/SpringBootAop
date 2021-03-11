package com.example.demo.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class OneToOneEmp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    private String name;


    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "table_join", joinColumns = @JoinColumn(name = "a_id"))
    @MapsId("empId")
    List<EmpEduEntity> empEduEntity;

    public OneToOneEmp(int id) {
        this.id = id;
    }

    public OneToOneEmp(int id, String name, List<EmpEduEntity> empEduEntity) {
        this.id = id;
        this.name = name;
        this.empEduEntity = empEduEntity;
    }

    public OneToOneEmp() {

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

    public List<EmpEduEntity> getEmpEduEntity() {
        return empEduEntity;
    }

    public void setEmpEduEntity(List<EmpEduEntity> empEduEntity) {
        this.empEduEntity = empEduEntity;
    }

    @Override
    public String toString() {
        return "OneToOneEmp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empEduEntity=" + empEduEntity +
                '}';
    }

}
