package com.example.demo.serviceImpl;

import com.example.demo.ConstantFile;
import com.example.demo.model.*;
import com.example.demo.dto.EmpDto;
import com.example.demo.exception.MappingException;
import com.example.demo.repository.EmpAccountDetailsRepository;
import com.example.demo.repository.EmpRepository;
import com.example.demo.repository.OneToOneRepo;
import com.example.demo.service.EmpService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpRepository empRepository;

    @Autowired
    EmpAccountDetailsRepository empAccountDetailsRepository;

    @Autowired
    OneToOneRepo oneToOneRepo;

    @Autowired
    ObjectMapper mapper;
    @Autowired
    EntityManager entityManager;

    @Autowired
    private org.springframework.core.env.Environment evn;

    @Override
    public Map<String, Object> getAllEmpRecord() {
        System.out.print("Server port=:" + evn.getProperty("server.port"));
        System.out.print("DB name" + evn.getProperty("spring.datasource.name"));
        System.out.print("Host Url=:" + evn.getProperty("spring.datasource.url"));
        ArrayList<EmpEntityDetails> empList = new ArrayList<EmpEntityDetails>();
        empList.addAll(empRepository.findAll());
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("data", empList == null ? "No EmpRecord" : empList);
        return response;
    }

    @Override
    public void createNewEmp(String empRecord) {
        try {
            EmpEntityDetails empDetails = mapper.readValue(empRecord, EmpEntityDetails.class);
            if (empDetails.getEmpName() == null || empDetails.getEmpContactno() == null) {
                throw new Exception("Mandatory field are missing ");
            }
            if (empDetails.getUpdatedBy() == null) {
                empDetails.setUpdatedBy(ConstantFile.NAME_EMPDEFAULT);
            }

            JSONObject json = new JSONObject(empRecord);
            List<EmpEduEntity> eduList = new ArrayList<EmpEduEntity>();
            if (!json.isNull("empEduDetails")) {
                JSONArray jsonArray = json.getJSONArray("empEduDetails");
                jsonArray.forEach(it -> {
                    EmpEduEntity empEduEntity = new EmpEduEntity();
                    try {
                        empEduEntity = mapper.readValue(String.valueOf(it), EmpEduEntity.class);
                    } catch (JsonProcessingException e) {
                        throw new MappingException("error occure while map object data");
                    }
                    eduList.add(empEduEntity);
                });
            }
            empDetails.setEmpListData(eduList);
            empRepository.save(empDetails);
        } catch (Exception e) {
            System.out.println("Some Exception occurred" + e);
        }
    }

    @Override
    public void deleteEmp(int empId) {
        empRepository.deleteById(empId);
    }

    @Override
    public Map<String, Object> updateEmp(EmpEntityDetails empRecord) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", empRecord.getId() == 0 ? "updated SuccessFully" : "created SuccessFully");
        empRepository.save(empRecord);
        return response;
    }

    @Override
    public Map<String, Object> getEmpRecordById(int empId) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("data",
                empRepository.findById(empId).isEmpty() ? "no record found on this id" : empRepository.findById(empId));
        return response;
    }

    @Override
    public Map<String, Object> getEmpField() {
        ArrayList<EmpDto> dtoList = new ArrayList<EmpDto>();
        Map<String, Object> response = new HashMap<String, Object>();
        empRepository.findAll().forEach(it -> {
            EmpDto emp = new EmpDto();
            emp.setId(it.getId());
            emp.setName(it.getEmpName());
            dtoList.add(emp);
        });
        response.put("data", dtoList == null ? "no record" : dtoList);
        return response;
    }

    @Override
    public void manyToOne() {
        Emp e1 = new Emp();
        Emp e2 = new Emp();

        ArrayList<Emp> empList = new ArrayList<Emp>();

        EmpAccount account = new EmpAccount();
        account.setAccountNo(4574688);
        account.setBankName("HDFC");
        ArrayList<EmpAccount> acList = new ArrayList<EmpAccount>();
        acList.add(account);

        e1.setEmpId(233);
        e1.setEmpName("Sumit");
        e1.setEmpAccountDetailsList(acList);

        e2.setEmpId(236);
        e2.setEmpName("Naman");
        e2.setEmpAccountDetailsList(acList);

        empList.add(e1);
        empList.add(e2);

        empAccountDetailsRepository.saveAll(empList);
    }

    @Override
    public void manyToManyMappings() {
        Emp e1 = new Emp();
        Emp e2 = new Emp();

        List<Emp> listEmp = new ArrayList<Emp>();

        List<EmpAccount> acList1 = new ArrayList<EmpAccount>();
        List<EmpAccount> acList2 = new ArrayList<EmpAccount>();
        EmpAccount ac1 = new EmpAccount();
        EmpAccount ac2 = new EmpAccount();

        EmpAccount ac3 = new EmpAccount();
        EmpAccount ac4 = new EmpAccount();

        ac1.setAccountNo(2355646);
        ac1.setBankName("SBI");

        ac2.setAccountNo(347874);
        ac2.setBankName("PNB");
        acList1.add(ac1);
        acList1.add(ac2);

        ac3.setAccountNo(346634);
        ac3.setBankName("KOTAK");

        ac4.setAccountNo(3473847);
        ac4.setBankName("Oriental");
        acList2.add(ac3);
        acList2.add(ac4);

        e1.setEmpId(23);
        e1.setEmpName("Nishant Sharma");
        e1.setEmpAccountDetailsList(acList1);

        e2.setEmpId(24);
        e2.setEmpName("Aman sharma");
        e2.setEmpAccountDetailsList(acList2);

        listEmp.add(e1);
        listEmp.add(e2);

        empAccountDetailsRepository.saveAll(listEmp);
        ArrayList<Emp> listData = new ArrayList<Emp>();
        empAccountDetailsRepository.findAll().forEach(e -> listData.add(e));

    }

    @Override
    public void oneToOne() {
        OneToOneEmp oneToOneEmp = new OneToOneEmp();
        EmpEduEntity empEduEntity = new EmpEduEntity();
        List list = new ArrayList<EmpEduEntity>();
        empEduEntity.setDegree("B.tech ");
        empEduEntity.setClgName("GLA University");
        oneToOneEmp.setName("Aman sharma");
        list.add(empEduEntity);
        EmpEduEntity empEduEntity1 = new EmpEduEntity();
        empEduEntity1.setDegree("M.tech ");
        empEduEntity1.setClgName("ABES University");
        list.add(empEduEntity1);
        oneToOneEmp.setEmpEduEntity(list);

        oneToOneRepo.save(oneToOneEmp);
    }

    @Override
    public Map<String, Object> getListemp(Map<String, Object> param) {
        Map<String, Object> response = new HashMap<String, Object>();
        int page = 1;
        int limit = 10;
        String order = null;
        String sort = null;
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            switch (entry.getKey()) {
                case "limit":
                    limit = Integer.parseInt(entry.getValue().toString());
                    break;
                case "sort":
                    sort = (String) entry.getValue();
                    break;
                case "order":
                    order = (String) entry.getValue();
                    break;
            }
        }
        Page<EmpEntityDetails> pageable = null;
        if (sort == null || sort.isEmpty()) {
            sort = "id";
        }
        if (order == null) {
            order = Sort.Direction.ASC.toString();
        }
        pageable = empRepository.findCustom(createPageRequest(page, limit, order.toString(), sort));
        response.put("totalCont", empRepository.count());
        response.put("data", pageable);

        return response;
    }

    public Pageable createPageRequest(int firstResult, int maxResults, String sortType, String sortField) {
        if (sortType.equalsIgnoreCase("ASC")) {
            return PageRequest.of(firstResult, maxResults, Sort.by(sortField).ascending());
        }
        if (sortType.equalsIgnoreCase("DESC")) {
            return PageRequest.of(firstResult, maxResults, Sort.by(sortField).descending());
        }
        return PageRequest.of(firstResult, maxResults);
    }


    public <T> Object genericCriteria(T t1, String joinTableName) {

        List list = null;
        List searcgList = new ArrayList();
        searcgList.add("empName");
        searcgList.add("bankName");
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery(t1.getClass());
            Root<?> root = criteriaQuery.from(t1.getClass());
            Join<Emp, EmpAccount> item = root.join(joinTableName, JoinType.LEFT);
            criteriaQuery.multiselect(root.get("empName"),item.get("bankName"))
                    .where(criteriaBuilder.equal(root.get("empId"), item.get("acId")));
            criteriaQuery.select(root.get("empName")).where(criteriaBuilder.equal(root.get("empId"), "15"));
            TypedQuery<?> query = entityManager.createQuery(criteriaQuery);
            list = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
