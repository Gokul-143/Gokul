package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Emp {
	
	

	
	
		@javax.persistence.Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		// Id is auto incremented
		
		private int Id;
		private String empName;
		private String empAddress;
		private String empPhone;
		private float empSalary;
		
		
		public Emp(int id, String empName, String empAddress, String empPhone,
				float empSalary) {
			super();
			Id = id;
			this.empName = empName;
			this.empAddress = empAddress;
			this.empPhone = empPhone;
			this.empSalary = empSalary;
		}
		
		public Emp() {
			
		}
		


		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmpAddress() {
			return empAddress;
		}

		public void setEmpAddress(String empAddress) {
			this.empAddress = empAddress;
		}

		public String getEmpPhone() {
			return empPhone;
		}

		public void setEmpPhone(String empPhone) {
			this.empPhone = empPhone;
		}

		public float getEmpSalary() {
			return empSalary;
		}

		public void setEmpSalary(float empSalary) {
			this.empSalary = empSalary;
		}

		public Emp(String empName, String empAddress, String empPhone, float empSalary) {
			super();
			this.empName = empName;
			this.empAddress = empAddress;
			this.empPhone = empPhone;
			this.empSalary = empSalary;
		}

		
	}

