package com.accenture.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table (name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer implements Serializable{
	@Id
	@Column(name = "cust_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	
	@ManyToOne()
	@JoinColumn(name = "add_id")
	private Address address;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "dob")
	private LocalDate dob;
	
}
