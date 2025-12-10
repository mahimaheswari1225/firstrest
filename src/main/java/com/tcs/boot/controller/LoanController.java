package com.tcs.boot.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.boot.entity.Loan;
import com.tcs.boot.service.LoanService;

@RestController

@RequestMapping("/loan/api/v1.0")
public class LoanController {
	
	@Autowired
	LoanService service;
	
	// http://localhost:9999/loan/api/v1.0/create-  JAXB (DOM/SAX) Jersey- -> Jackson
	// http://localhost:9999/loan/api/v1.0/fetch/1
	
	  @PostMapping(value="/create", consumes=MediaType.APPLICATION_JSON_VALUE,
	  produces= MediaType.APPLICATION_JSON_VALUE)
	  
	  public ResponseEntity<Loan> loanApplication(@RequestBody Loan loan){
		  
		//  return new ResponseEntity<Loan>(HttpStatus.CREATED); // .ok(service.addLoan(loan)); //status message created
	 
		  Loan  newLoan = service.addLoan(loan);
	// return new ResponseEntity<Loan>(newLoan,HttpStatus.OK);
		  
	 HttpHeaders headers = new HttpHeaders();
	 headers.add("xx-created-by", "Mahi");
	 headers.add("content-type", "application/json"); //MIME type
	 
	// return new ResponseEntity<Loan>(newLoan,headers,HttpStatus.OK);
	 return ResponseEntity.ok(newLoan);
	  }
	
	
	//@PostMapping("/create")
    // public Loan loanApplication(@RequestBody Loan loan) {
	//	return service.addLoan(loan);}
	
	@GetMapping("/fetch/{lid}")
	
	public ResponseEntity<Loan>getLoan(@PathVariable Long lid){
	//return new ResponseEntity<Loan>(HttpStatus.BAD_REQUEST); // when id is not present
	//}
	//public Loan getLoan(@PathVariable Long lid) {
	//	return service.getLoan(lid);
	//}
//	return ResponseEntity.badRequest().build();}
//	return ResponseEntity.status(400).body(null);}
	/*
	 * if(false) { return new ResponseEntity<>(service.getLoan(lid),HttpStatus.OK);
	 * }else { throw new IllegalArgumentException("Invalid loan id"+ lid); }
	 */
		Loan loan=service.getLoan(lid);
		if(loan!=null) {
			return new ResponseEntity<>(loan,HttpStatus.OK);
			
		}else {
			throw new IllegalArgumentException("Invalid loan id"+ lid);
		}

	}
	@GetMapping("/all")
	public List<Loan> getLoans(){
		return service.getLoans();
	}

	@PutMapping("/modify") //  for complete/full update 
	public Loan doUpdate(@RequestBody Loan loan) {

    return service.update(loan); //  output as loan status false
}

	@PutMapping("/modify2") //  for complete/full update 
	public Loan doUpdate2(@RequestBody Loan loan) {

    return service.update2(loan); 
	}
	
	@DeleteMapping("/remove/{lid}") //  for complete/full update 
	public ResponseEntity<Void>delete(@PathVariable Long lid) {
     service.remove(lid); 
  //  return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     
     // in RestController
		/*
		 * @ExceptionHandler(value= {IllegalArgumentException.class})
		 * 
		 * @ResponseStatus(HttpStatus.BAD_REQUEST) public
		 * ResponseEntity<Map<String,String>>handleHandler(IllegalArgumentException ex){
		 * Map<String,String>errorMap = new HashMap<>(); errorMap.put("Loanid",
		 * ex.getMessage()); return ResponseEntity.status(400).body(errorMap); }
		 */
     
	}
	
}
