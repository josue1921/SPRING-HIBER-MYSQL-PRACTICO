package com.websystique.springboot.model;
 
import org.hibernate.validator.constraints.NotEmpty;
 
import javax.persistence.*;
import java.io.Serializable;
 
@Entity
@Table(name="APP_USER")
public class User implements Serializable{
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
 
    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String name;
 
    @Column(name="AGE", nullable=false)
    private Integer age;
 
    @Column(name="PHONE", nullable=false)
    private String phone;
    
    @Column(name="EMAIL", nullable=false)
    private String email;
    
    @Column(name="APAT", nullable=false)
    private String apat;
    
    @Column(name="AMAT", nullable=false)
    private String amat;

    @Column(name="IES", nullable=false)
    private String ies;
    
    @Column(name="RFC", nullable=false)
    private String rfc;
    
    @Column(name="ESTATUS", nullable=false)
    private String estatus;
    
    @Column(name="ID_SEXO", nullable=false)
    private String id_sexo;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApat() {
		return apat;
	}

	public void setApat(String apat) {
		this.apat = apat;
	}

	public String getAmat() {
		return amat;
	}

	public void setAmat(String amat) {
		this.amat = amat;
	}

	public String getIs() {
		return ies;
	}

	public void setIes(String ies) {
		this.ies = ies;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getId_sexo() {
		return id_sexo;
	}

	public void setId_sexo(String id_sexo) {
		this.id_sexo = id_sexo;
	}
}