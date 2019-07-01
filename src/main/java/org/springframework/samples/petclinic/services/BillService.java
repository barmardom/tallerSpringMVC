package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.repositories.BillRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	
	@Autowired
	private BillRepository billRepository;
	
	public Bill findById(int id) {
		return this.billRepository.findOne(id);
	}
	
	public List<Bill> findAll(){
		return this.billRepository.findAll();

	}
	
}
