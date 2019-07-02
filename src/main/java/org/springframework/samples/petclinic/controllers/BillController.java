/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@RestController
public class BillController {

	@Autowired
    private BillService billService;
    
    // localhost:8080/bills/
    @RequestMapping(value ="/bills", method=RequestMethod.GET)
    public List<Bill> findAll(){
    	return this.billService.findAll();
    }

    // localhost:8080/bills/79
    @RequestMapping(value ="/bills/{idBill}", method=RequestMethod.GET)
    public ResponseEntity<Bill> findById(@PathVariable("idBill") Integer id){
    	Bill b = new Bill();
    	b =  this.billService.findById(id);
    	if(b != null) {
    		return ResponseEntity.status(HttpStatus.OK).body(b);
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
    }
    
    /*
    {
    	   "idNumber" : "9234567890",
    	   "paymentDate" : "2018-02-14",
    	   "money" : "17",
    	   "visit" : "1"
    	 }
    */
    // localhost:8080/bills
    @RequestMapping(value ="/bills", method=RequestMethod.POST)
    public ResponseEntity<Bill> create(@RequestBody @Valid Bill b){
    	b =  this.billService.save(b);
    	if(b != null) {
    		return ResponseEntity.status(HttpStatus.OK).body(b);
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
 
    }
    
    /*
    {
    	   "idNumber" : "9234567890",
    	   "paymentDate" : "2018-02-14",
    	   "money" : "17",
    	   "visit" : "1"
    	 }
    */
    // localhost:8080/bills/80
    @RequestMapping(value ="/bills/{idBill}", method=RequestMethod.PUT)
    public Bill update(@PathVariable("idBill") Integer id, @RequestBody @Valid Bill b){
    	b =  this.billService.update(id, b);
    	return b;
    }
    
    // localhost:8080/bills/94
    @RequestMapping(value ="/bills/{idBill}", method=RequestMethod.DELETE)
    public ResponseEntity<Bill> delete(@PathVariable("idBill") Integer id){
    	Bill b =  this.billService.findById(id);
    	if(b != null) {
        	billService.delete(id);
    		return ResponseEntity.status(HttpStatus.OK).body(b);
    	}else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}

    }
    
    // localhost:8080/bills/
    @RequestMapping(value ="/bills", method=RequestMethod.DELETE)
    public void deleteAll(){
    	billService.deleteAll();
    }
    
    @RequestMapping(value ="/bills?filter=", method=RequestMethod.GET)
    public List<Bill> conseguirPagadas(@RequestParam("pagadas") String s){
    	//List<Bill> b = new ArrayList<Bill>();

    	return billService.pagadadasNoPagadas(s);
    }


}
