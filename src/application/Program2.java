package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactoryDepartment;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactoryDepartment.createDepartmentDao();
		
		System.out.println("=== TEST 1: DEPARTMENT FindByID");
		Department dep = departmentDao.findById(1);
		
		System.out.println(dep);

		
		System.out.println("\n=== TEST 2: SELLER FindAll===");
		List<Department> list;
		list = departmentDao.findAll();
		
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("\n=== TEST 3: DEPARTMENT INSERT===");
		
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("inserido, novo id= " + newDepartment.getId());
		
		
		System.out.println("\n=== TEST 4: DEPARTMENT UPDATE===");
		
		dep = departmentDao.findById(6);
		dep.setName("Food");
		departmentDao.update(dep);
		
		System.out.println("UPdate complete");

		
		System.out.println("\n=== TEST 5: DEPARTMENT DELETE===");
		System.out.print("enter id for delete ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("delete complet");
		sc.close();
	}

}
