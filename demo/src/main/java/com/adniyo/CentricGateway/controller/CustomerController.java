package com.adniyo.CentricGateway.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adniyo.CentricGateway.domain.Customer;
import com.adniyo.CentricGateway.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;

	// Customer cust;
	@RequestMapping(value = "/users/a", method = RequestMethod.GET)
	public String helloWorld() {
		return "We are accessible";

	}

	@RequestMapping(value = "/createcustomer", method = RequestMethod.POST)
	public ResponseEntity<String> createCustomer(@RequestBody Map<String, String> body) {
		Customer cust = new Customer();
		Date dateobj = new Date();
		cust.setFullName(body.get("name"));
		cust.setAddress(body.get("address"));
		cust.setEmail(body.get("email"));
		cust.setCreatedBy(body.get("createby"));
		cust.setCreatedate(dateobj);
		cust.setPhone(body.get("phone"));
		System.out.println(cust.toString());
		try {
			cs.save(cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("something went wrong", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully Added", new HttpHeaders(), HttpStatus.OK);

	}

	@RequestMapping(value = "/readcustomer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> readCustomer(@PathVariable String id) {

		int custID = Integer.parseInt(id);
		Customer cust = new Customer();
		try {

			cust = cs.findById(custID);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Customer>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		System.out.println(cust.toString());
		// return cust;
		return new ResponseEntity<Customer>(cust, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {

		int custID = Integer.parseInt(id);
		Customer cust = new Customer();
		try {

			cs.delete(cs.findById(custID));

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Customer>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		System.out.println(cust.toString());
		return new ResponseEntity<Customer>(cust, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(value = "/updatecustomer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCustomer(@PathVariable String id, @RequestBody Map<String, String> body) {
		int custID = Integer.parseInt(id);
		Customer cust = new Customer();
		cust.setFullName(body.get("fullName"));
		cust.setAddress(body.get("address"));
		cust.setEmail(body.get("email"));
		cust.setPhone(body.get("phone"));
		try {
			cs.update(custID, cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("something went wrong", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successfully Updated", new HttpHeaders(), HttpStatus.OK);
	}
}
