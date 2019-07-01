package org.springframework.samples.petclinic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repositories.BillRepository;
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
	
	public Bill save(Bill b){
		b = billRepository.save(b);
		return b;
	}
	
	public Bill update(int id, Bill b){
		Bill billDB = findById(id);
		
		if(billDB != null) {
			b.setId(billDB.getId());
			return billRepository.save(b);
		}
		
		return null;
	}

	
	public void delete(Integer id) {
		Bill billDB = findById(id);
		
		if(billDB != null) {
			billRepository.delete(billDB);
		}
	}

	public void deleteAll() {
		billRepository.deleteAll();
	}

	public List<Bill> pagadadasNoPagadas(String s) {
		List<Bill> billsDB = new ArrayList<Bill>();
		
		for(Bill b: billRepository.findAll()) {
			if(b.getVisit() != null) {
				billsDB.add(b);
			}
		}
		
		return billsDB;
		
	}
}
