package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

	
	@Entity
	@Table(name = "admindb")
	public class Admin {

		@Id
		private long adminid;

		@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
		private String name;
		
		@Email(message = "Email should be valid")
		private String emailid;
		
		@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
		private String password;

		public Admin(long adminid,
				@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String name,
				@Email(message = "Email should be valid") String emailid,
				@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters") String password) {
			super();
			this.adminid = adminid;
			this.name = name;
			this.emailid = emailid;
			this.password = password;
		}

		public Admin() {
			
		}

		public long getAdminid() {
			return adminid;
		}

		public void setAdminid(long adminid) {
			this.adminid = adminid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		
}
