package com.app.ibatis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Constact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_contac;
	
	@Size(min = 2, max =50)
    @Pattern(regexp = "[A-Za-zÑñÁáÉéÍíÓóÚúÜü\\s]*", message = "El campo nombre requiere solo letras")
    private String name;

    @NotNull(message =  "Email no valido")
    @NotEmpty(message = "Email requires non empty value")
    @Email(message =    "Email no tiene formato correcto")
    private String mail;
    
    private String mailuser;

    @Pattern(regexp = "[0-9.\\-+ ]*", message = "Telefono solo acepta numeros.")
    private String phone;
    
    private String photo;
    
    /*setter getter method here*/
	public int getId() {
		return id_contac;
	}

	public void setId(int id_contac) {
		this.id_contac = id_contac;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMailuser() {
		return mailuser;
	}
	public void setMailuser(String mailuser) {
		this.mailuser = mailuser;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
  
}
