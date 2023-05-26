package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: SELLER FindByID");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: SELLER FindByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: SELLER FindAll===");
		
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: SELLER INSERT===");
		
		Seller newSeller = new Seller(null, "greg", "greg@gmai.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("inserido, novo id= " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: SELLER update===");
		
		seller = sellerDao.findById(1);
		seller.setName("MARTA");
		sellerDao.update(seller);
		
		System.out.println("UPdate complete");
		
		System.out.println("\n=== TEST 6: SELLER delete===");
		
		System.out.print("enter id for delete ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("delete complet");
		sc.close();
	}
}
