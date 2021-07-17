package com.accenture.models;

import java.time.LocalDate;

import javax.persistence.*;
import lombok.*;

@Entity
@Table (name = "policies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Policy {

	@Id
	@Column(name = "pol_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int polNumber;
	
	@Column(name = "pol_type")
	private String pol_type;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "premium")
	private double premium;
	
	@Column(name = "start_date")
	private LocalDate pol_start_date;
	
	@Column(name = "end_date")
	private LocalDate pol_end_date;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private Customer customer;
}
