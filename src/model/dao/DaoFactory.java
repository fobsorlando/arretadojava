package model.dao;

import model.dao.impl.DepartamentoDaoJDBC;

public class DaoFactory {
	
	public static DepartamentoDao createDepartamentoDao() {
		
		return new DepartamentoDaoJDBC();
	}
	
	

}
