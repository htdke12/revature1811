package com.example.service;

import com.example.dao.EmployeeDao;
import com.example.obj.Employee;

public class UserService {
	
	
	EmployeeDao dao=new EmployeeDao();
	
	
	public int validateUser(Employee e) {
		
		Employee temp= dao.getData(e.getEid());
		if(temp==null) {
			return -1;
		}
		String daoUser=temp.getLname()+temp.getFname()+temp.getPositionType();
		String daoInput=e.getLname()+e.getFname()+e.getPositionType();
		System.out.println(daoInput);
		if(daoUser.equals(daoInput)) {
			return e.getEid();
			
			
		}else {
			return -1;
		}
		
		
		
		
		
	}

}
