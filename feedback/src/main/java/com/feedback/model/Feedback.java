package com.feedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	@NotNull
	@Size(min=2, max=30)
	private String name;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int satisfaction;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int userfriendly;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int paymentprocess;
	
	private String suggestion;
	
	public Feedback() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public int getUserfriendly() {
		return userfriendly;
	}

	public void setUserfriendly(int userfriendly) {
		this.userfriendly = userfriendly;
	}

	public int getPaymentprocess() {
		return paymentprocess;
	}

	public void setPaymentprocess(int paymentprocess) {
		this.paymentprocess = paymentprocess;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggest(String suggestion) {
		this.suggestion = suggestion;
	}
}
