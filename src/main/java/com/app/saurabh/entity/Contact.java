package com.app.saurabh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contact_details")

public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="cid")
	private Integer contId;
	
	@Column(name="cname")
	private String contName;
	
	@Column(name="cgen")
	private String contGen;
	
	@Column(name="cemail")
	private String contEmail;
	
	@Column(name="cno")
	private Long contNo;
	
	@Column(name="cadd")
	private String contAdd;
	
	@Column(name="create_date")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="update_date")
	@UpdateTimestamp
	private LocalDate updatedDate;
}
