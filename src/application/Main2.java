package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import models.entities.Department;

public class Main2 {

	public static void main(String[] args) {
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n==== Test 1 findById ====");
		System.out.println(depDao.findById(3));
		
		System.out.println("\n==== Test 2 findAll ====");
		System.out.println(depDao.findAll());
		
		System.out.println("\n==== Test 3 insert ====");			
		Department newDep = new Department(null, "Music");
		depDao.insert(newDep );
		System.out.println("Inserted a New Department" + "\nInfo: " + newDep);
		
		System.out.println("\n==== Test 4 update ====");
		newDep.setName("Games");
		depDao.update(newDep);
		System.out.println("Updated id = " + newDep.getId() + "\n" + newDep);
		
		System.out.println("\n==== Test 5 delete ====");	
		depDao.deleteById(newDep.getId());
		System.out.println("Trying to find " + newDep.getId() + "\nResult: " + depDao.findById(newDep.getId()));
		
	}

}
