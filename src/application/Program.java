package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
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
		seller = sellerDao.findById(9);
		seller.setEmail("gabrielsousa.correia2@gmail.com");
		//sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Enter id for delete teste: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
