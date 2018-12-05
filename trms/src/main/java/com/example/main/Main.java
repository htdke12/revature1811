package com.example.main;

import java.util.ArrayList;

import com.example.dao.EmployeeDao;
import com.example.dao.GradeDao;
import com.example.dao.TrFormDao;
import com.example.obj.Employee;
import com.example.obj.Grade;
import com.example.obj.TrForm;

public class Main {

	public static void main(String[] args) {

		

			TrForm f=new TrForm();
		Employee e=new Employee();
		
		f.setCost(1000);
		f.setCourseType("presentation");
		f.setDate("11/01/1999");
		f.setDescription("intro to java");
		f.setEid(1);
		//f.setFid(1);
		f.setGrade("c");
		f.setLocation("ny");
		f.setTime("2:00:am");
		f.setWorkRelate("skill build");
		 
		TrFormDao da=new TrFormDao();
		da.insertData(f);
		
		//e.setEid(1);
		//e.setFname("melo");
		//e.setLname("jelo");
	//	e.setPositionType(2);
		
		//Employee l=EmployeeDao.getData(1);
		//System.out.println(l.getPositionType());
		//TrFormDao.updateData("grade", "a", 1);
		
		//Grade s=GradeDao.getData("seminars");
		//System.out.println(s.getGrades());
		
	}

	
	
}
	


