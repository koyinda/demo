package com.adniyo.CentricGateway.service;

import com.adniyo.CentricGateway.domain.Customer;

public interface CustomerService {

	public long save(Customer c);

	public void delete(Customer c);

	public Customer findById(long userindex);

	public void update(int custID, Customer cust);

}
