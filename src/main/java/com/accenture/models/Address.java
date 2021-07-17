package com.accenture.models;

import java.io.Serializable;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "add_id")
	private int id;
	
	@Column(name = "line1")
	private String line1;
	
	@Column(name = "line2")
	private String line2;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "country")
	private String country;
}
