package org.springframework.samples.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}