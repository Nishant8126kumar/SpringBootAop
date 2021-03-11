package com.example.demo.services;

import com.example.demo.serviceImpl.EmpServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EmpServiceImpl.class)
public class EmpServiceImpleShould {

//	@Autowired
//	EmpRepository empRepository;
//	TestDataSource testDataSource=new TestDataSource();
//
////	@Before
////	public void congigure() {
////
////	}
//
//	@Test
//	public void getEmpShould() {
////		when(empRepository.findAll()).thenReturn(testDataSource.getDataForTest());
////		Mockito.when(empRepository.findAll()).thenReturn(testDataSource.getDataForTest());
//		verify(empRepository.findAll());
//	}
//
//	@Test
//	public void getEmpByIdShould() {
//
////		Iterable<Integer> ids=0;
////		when(empRepository.findAllById(ids)).thenReturn(value)
//
//	}

}
