package com.websystique.springboot.model;
 
import org.hibernate.validator.constraints.NotEmpty;
 
import javax.persistence.*;
import java.io.Serializable;
 
@Entity
@Table(name="APP_GENDER")
public class Gender implements Serializable{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
    @NotEmpty
    @Column(name="SEXO", nullable=false)
    private String sexo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}