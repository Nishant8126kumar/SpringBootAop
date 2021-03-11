package com.example.demo.repository;

import com.example.demo.model.Emp;
import com.example.demo.model.EmpEntityDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntityDetails, Integer> {

    //    @Query(nativeQuery = true,value="SELECT * FROM emp_entity_details emp where emp.emp_address=:name ")
    @Query(nativeQuery = true, value = "SELECT * FROM emp_data where emp_data.emp_name=:name && emp_data.emp_address=:address")
    public List<EmpEntityDetails> findByEmpAddress(@Param("name") String name, @Param("address") String address);

    @Query(nativeQuery = true, value = "SELECT * FROM emp_data where emp_data.id between :first and :second")
    List<EmpEntityDetails> findDataUsingBetween(@Param("first") int first, @Param("second") int second);

    @Query(nativeQuery = true, value = "SELECT id,emp_name,emp_address from emp_data")
    Page<EmpEntityDetails> findCustom(Pageable createPageRequest);

    @Query("select u from EmpEntityDetails u  ")
    List<EmpEntityDetails> getEmp();

    @Query(nativeQuery = true, value = "select emp_data.emp_contactno,emp_data.emp_address," +
            "emp.emp_name,emp.updated_by from emp_data right join emp on emp_data.id=emp.emp_id")
    List<Object> applyJoin();

    //    @Query("select u from Emp u where u.empName=:name")emp_name
    @Query(nativeQuery = true, value = "select emp_data.emp_address,emp_data.emp_designation,emp_account.bank_name from emp_data right join emp_account on emp_data.id=emp_account.ac_id")
    List<Object> getEmpRecord();

    @Query(nativeQuery = true, value = "select emp.emp_name,emp_account.account_no from emp right join emp_account " +
            " on emp.emp_id=emp_account.ac_id ")
    List<Object> getEmpData();

    @Query(nativeQuery = true, value = "select emp.emp_name,emp.updated_by ,emp_data.emp_address,emp_data.emp_contactno from" +
            " emp left join emp_data on emp.emp_id=emp_data.id")
    List<Object> getByJoin();

    @Query(nativeQuery = true, value = "select emp_data.emp_name,emp_data.emp_address,emp.updated_by ,emp_account.account_no,emp_account.bank_name from emp_data " +
            " left join emp on emp_data.id=emp.emp_id left join emp_account on emp_data.id=emp_account.ac_id")
    List<Object> getMultipleTableJoin();

}
