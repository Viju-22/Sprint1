package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


	@Entity
	@Table(name = "laddb")
	public class Lad{

		@Id
		private long ladid;

		@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
		private String name;
		
		@Email(message = "Email should be valid")
		private String email;
		
		@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
		private String password;

		public Lad(long ladid,
				@Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters") String name,
				@Email(message = "Email should be valid") String email,
				@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters") String password) {
			super();
			this.ladid = ladid;
			this.name = name;
			this.email = email;
			this.password = password;
		}

		public Lad() {
			
		}

		public long getLadid() {
			return ladid;
		}

		public void setLadid(long ladid) {
			this.ladid = ladid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "Lad [ladid=" + ladid + ", name=" + name + ", email=" + email + ", password=" + password + "]";
		}
		
		

		
}
