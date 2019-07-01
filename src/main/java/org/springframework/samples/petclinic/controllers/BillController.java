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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.services.BillService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    
    @RequestMapping(value ="/bills", method=RequestMethod.GET)
    public List<Bill> findAll(){
    	return this.billService.findAll();
    }

    @RequestMapping(value ="/bills/{idBill}", method=RequestMethod.GET)
    public Bill findById(@PathVariable("idBill") Integer id){
    	Bill b = this.billService.findById(id);
    	return b;
    }


}
