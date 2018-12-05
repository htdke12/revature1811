package com.example.service;

import com.example.dao.TrFormDao;
import com.example.obj.TrForm;

public class FormService {
	
	private TrFormDao dao=new TrFormDao();
	
	public boolean addForm(TrForm form) {
		form.setGrade("pending");
		System.out.println(form);
		boolean temp=dao.insertData(form);
		if(temp) {
			return true;
		}
		
		
		return false;
	}

}
