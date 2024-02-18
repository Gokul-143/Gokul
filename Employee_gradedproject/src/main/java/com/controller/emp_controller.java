package com.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Emp;

@Controller
public class emp_controller {
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/Show_page")
	
	public String Show_page(Model data) {
		
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			try {
				Query q1 = session.createQuery("from Employee");
				List<Emp> employee = q1.getResultList();
				data.addAttribute("employee", employee);

			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			
			
		}
		return "Show_page";
		
		
	}
	
	@RequestMapping("/Add_emp")
	public String add_record() {
		return "Add_emp";

	}

	@PostMapping("/addemp_details")
	public String addDetails(@RequestParam String empName, @RequestParam String empAddress,
			@RequestParam String empPhone, @RequestParam float empSalary, Model data) {

		// session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		try {
			Transaction tx = session.beginTransaction();

			Emp e1 = new Emp(empName, empAddress, empPhone, empSalary);

			session.save(e1);

			Query q1 = session.createQuery("from Employee");
			List<Emp> employee = q1.getResultList();
			data.addAttribute("employee", employee);

			tx.commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		
		return "Show_page";
		
	}
	
	@GetMapping("/Update_empdetails")
	public String updateEmployee(@RequestParam int Id, Model data) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		try {
			Emp updateEmp = session.get(Emp.class, Id);
			data.addAttribute("employee", updateEmp);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Update_Form";
	}

	@PostMapping("/Update_Form")
	public String updateSaveEmp(@RequestParam int Id, @RequestParam String empName,
			@RequestParam String empAddress, @RequestParam String empPhone,
			@RequestParam float empSalary, Model data) {

		// session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			Emp e1 = new Emp(Id, empName, empAddress, empPhone, empSalary);
			session.update(e1);

			Query q1 = session.createQuery("from Emp");
			List<Emp> employee = q1.getResultList();
			data.addAttribute("employee", employee);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return "Show_page";
	}

	@GetMapping("/delete_form")
	public String deleteEmp(@RequestParam int Id, Model data) {

		// session factory
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			Emp deleteEmp = new Emp(Id, "", "", "", 0);
			session.delete(deleteEmp);

			Query q1 = session.createQuery("from Emp");
			List<Emp> employee = q1.getResultList();
			data.addAttribute("employee", employee);
			tx.commit();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return "Show_page";
	}
	
}
