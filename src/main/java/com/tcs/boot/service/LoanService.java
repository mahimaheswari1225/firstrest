package com.tcs.boot.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tcs.boot.controller.List;
import com.tcs.boot.entity.Loan;
import com.tcs.boot.repository.LoanRepository;
import java.util.List;
@Service
public class LoanService {
	@Autowired
	LoanRepository repository;
	
public Loan addLoan(Loan loan) {
	return repository.save(loan);
	
}
public Loan getLoan(Long loanId) {
	
Optional<Loan>optionalLoan = repository.findById(loanId);
	return optionalLoan.get();
}
public List<Loan> getLoans() {
	// TODO Auto-generated method stub
	return repository.findAll();
}
public Loan update(Loan loan) {
	return repository.save(loan);
}
public Loan update2(Loan loan) {
	Optional<Loan> optional = repository.findById(loan.getLoanid());
	Loan tempLoan = optional.get();
	
	if(loan.getBorrowerName()!= null)
		tempLoan.setBorrowerName(loan.getBorrowerName());
	if(loan.getDateBorrowed()!= null)
		tempLoan.setDateBorrowed(loan.getDateBorrowed());
	if(tempLoan.getTenure()!= loan.getTenure())
		tempLoan.setTenure(loan.getTenure());
	if(tempLoan.getAmount()< loan.getAmount())
		tempLoan.setAmount(loan.getAmount());
	if(tempLoan.isLoanStatus()!= loan.isLoanStatus())
		tempLoan.setLoanStatus(loan.isLoanStatus());
	 return repository.save(tempLoan);
	
	// return repository.save(loan);
}
   public void remove(Long lid) {
	   System.out.println("from deelete");
	Optional<Loan>loan = repository.findById(lid);
	if(loan.isPresent()) {
		repository.delete(loan.get());
		 System.out.println("from deelete2 ");	
	}
	else {
		throw new IllegalArgumentException(lid + "not found!");
	
	}
}
  
	
}
