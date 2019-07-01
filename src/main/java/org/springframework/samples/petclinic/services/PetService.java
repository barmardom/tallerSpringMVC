package org.springframework.samples.petclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public Pet findById(int id) {
		return this.petRepository.findById(id);
	}
	
	public void save (Pet pet) {
		this.petRepository.save(pet);
	}
	
	public List<PetType> findPetTypes(){
		return this.findPetTypes();
	}
}
