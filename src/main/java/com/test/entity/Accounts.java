package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Accounts {

	@Id
	@NotNull
	private String id;

	private String name;

	private float amount;

	public Accounts(String id, String name, float amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public Accounts() {
	}

	public String getId() {
		return id;
	}

	public Accounts setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Accounts setName(String name) {
		this.name = name;
		return this;
	}

	public float getAmount() {
		return amount;
	}

	public Accounts setAmount(float amount) {
		this.amount = amount;
		return this;
	}
}
