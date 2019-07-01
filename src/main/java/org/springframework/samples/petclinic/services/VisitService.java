package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repositories.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
	
	@Autowired
	private VisitRepository visitRepository;
	
	public List<Visit> findByPetId(int id) {
		return this.visitRepository.findByPetId(id);
	}
	
}
