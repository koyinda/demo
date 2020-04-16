package com.adniyo.CentricGateway.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.adniyo.CentricGateway.domain.Customer;

@Repository
@Transactional
@Service
public class CustomerServiceImp implements CustomerService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long save(Customer c) {
		// TODO Auto-generated method stub

		entityManager.persist(c);
		return c.getUserindex();
	}

	@Override
	public void delete(Customer c) {
		// TODO Auto-generated method stub
		entityManager.remove(c);
	}

	@Override
	public Customer findById(long userindex) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, userindex);
	}

	@Override
	@Transactional
	public void update(int custID, Customer cust) {
		// TODO Auto-generated method stub
		Customer updateC = entityManager.find(Customer.class, Long.valueOf(custID));
		// entityManager.getTransaction().begin();
		updateC.setAddress(cust.getAddress());
		updateC.setPhone(cust.getPhone());
		updateC.setFullName(cust.getFullName());
		updateC.setAddress(cust.getAddress());
		updateC.setEmail(cust.getFullName());

		// entityManager.getTransaction().commit();
	}

}
