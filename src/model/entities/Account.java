package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {
		
	}
	
	public void withdraw(double amount) throws DomainException {
		if(getWithdrawLimit() < amount) { //poderia usar uma função privada aquii, para fazer a validação
			throw new DomainException ("The amount exceds withdraw limit!");
		}
		
		else if(amount > getBalance()) {
			throw new DomainException ("Not enough balance!");
		}
		
		balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Number: " + getNumber() + "\n"
				+ "Holder: " + getHolder() + "\n"
				+ "Balance: " + getBalance() + "\n"
				+ "Withdraw limit: " + getWithdrawLimit() + "\n";
	}
}
