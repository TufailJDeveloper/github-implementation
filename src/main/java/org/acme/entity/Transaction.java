package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;
	private double amount;

	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "transfer_id")
	private Transfer transfer;

	public Transaction() {
	}

	public Transaction(String description, double amount, Transfer transfer) {
		this.description = description;
		this.amount = amount;
		this.transfer = transfer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Transfer getTransfer() {
		return transfer;
	}
	

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	
	

}
