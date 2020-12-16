package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import models.entities.Department;
import models.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("==== Test 1 findById ====");
		System.out.println(sellerDao.findById(3));
		System.out.println("\n==== Test 2 findByDepartment ====");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));
		for (Seller sel : list) {
			System.out.println(sel);
		}
		
		System.out.println("\n==== Test 3 findAll ====");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller sel : list2) {
			System.out.println(sel);
		}
	}

}
