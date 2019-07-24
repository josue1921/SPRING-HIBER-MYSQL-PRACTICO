package com.app.ibatis.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min = 2, max =50)
    @Pattern(regexp = "[A-Za-zÑñÁáÉéÍíÓóÚúÜü\\s]*", message = "First name requires valid character")
    private String first_name;

    @Size(min = 2, max =50)
    @Pattern(regexp = "[A-Za-zÑñÁáÉéÍíÓóÚúÜü\\s]*", message = "First name requires valid character")
    private String last_name;


    //@Column(unique = true)
    @NotNull(message =  "Email requires valid value")
    @NotEmpty(message = "Email requires non empty value")
    @Email(message =    "Email requires valid format")
    private String email;

    @Size(min = 2, max =50)
    @Pattern(regexp = "[A-Za-z.0-9 ]*", message = "First name requires valid character")
    private String password;

//    @Pattern(regexp = "[0-9.\\-+ ]*", message = "Phone requires valid alphanumaric characters")
//    private String phone;
//    
    /*setter getter method here*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
    
}
