package com.jspiders.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	private int id;
	private String name;
	private long mobile;
	@OneToOne
	@JoinColumn(referencedColumnName = "id")
	private DNAReport dnaReport ;
	

}
