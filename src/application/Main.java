package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== Test 1 findById ====");
		System.out.println(sellerDao.findById(3));
		
		System.out.println("\n==== Test 2 findByDepartment ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println("\n==== Test 3 findAll ====");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller sel : list2) {
			System.out.println(sel);
		}
		
		System.out.println("\n==== Test 4 insert ====");
		
		Seller newSeller = new Seller(null, "Bruce Wayne", "email@email.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted a New Id, id = " + newSeller.getId());
		
		System.out.println("\n==== Test 5 update ====");
		newSeller.setName("Martha Wayne");
		sellerDao.update(newSeller);
		System.out.println("Updated id = " + newSeller.getId() + "\n" + newSeller);
		
		System.out.println("\n==== Test 6 delete ====");	
		sellerDao.deleteById(newSeller.getId());
		System.out.println("Trying to find " + newSeller.getId() + "\nResult: " + sellerDao.findById(newSeller.getId()));
		
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
