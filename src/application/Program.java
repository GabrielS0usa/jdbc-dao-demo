package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		list.forEach(s -> System.out.println(s));
		
		System.out.println();
		
		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		
		list.forEach(s -> System.out.println(s));
		
		System.out.println();
		
		System.out.println("=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Gabriel", "gabriel@gmail.com", sdf.parse("06/05/2003"), 5000.00, dep);
		
		//sellerDao.insert(newSeller);
		
		System.out.println(newSeller);
		
		System.out.println();
		
		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setEmail("gabrielsousa.correia2@gmail.com");
		//sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Enter id for delete teste: ");
		int id = sc.nextInt();
		//sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("=== TEST 7: department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println();
		
		System.out.println("=== TEST 8: department findAll ===");
		List<Department> list2 = new ArrayList<Department>();
		list2 = departmentDao.findAll();
		
		list2.forEach(s -> System.out.println(s));
		
		System.out.println();
		
		System.out.println("=== TEST 9: department insert ===");
		Department newDepartment = new Department(null, "Cursos");
		
		//departmentDao.insert(newDepartment);
		
		System.out.println(newDepartment);
		
		System.out.println();
		
		System.out.println("=== TEST 10: department update ===");
		department = departmentDao.findById(5);
		department.setName("Entregas");
		//departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println();
		
		System.out.println("=== TEST 11: department delete ===");
		System.out.print("Enter id for delete teste: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
