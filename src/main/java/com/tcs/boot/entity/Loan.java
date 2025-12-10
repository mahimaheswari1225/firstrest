package com.tcs.boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long loanid;
	String borrowerName;
	String dateBorrowed;
	int tenure;
	int balanceEMI;
	boolean loanStatus;
	
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getBalanceEMI() {
		return balanceEMI;
	}
	public void setBalanceEMI(int balanceEMI) {
		this.balanceEMI = balanceEMI;
	}
	public boolean isLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(boolean loanStatus) {
		this.loanStatus = loanStatus;
	}
	double amount;
	public long getLoanid() {
		return loanid;
	}
	public void setLoanid(long loanid) {
		this.loanid = loanid;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	//@Override
	public String toString() {
		return "Loan [loanid=" + loanid + ", borrowerName=" + borrowerName + ", dateBorrowed=" + dateBorrowed
				+ ", tenure=" + tenure + ", balanceEMI=" + balanceEMI + ", loanStatus=" + loanStatus + ", amount="
				+ amount + "]";
	}
	

}
