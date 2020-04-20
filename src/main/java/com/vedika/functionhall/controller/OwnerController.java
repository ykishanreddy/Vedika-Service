package com.vedika.functionhall.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.repository.OwnerRepository;
import com.vedika.functionhall.service.OwnerService;

//Required imports
@RestController
@RequestMapping("/functionHalls")
public class OwnerController {

  @Autowired
  private OwnerService ownerService;

  @Autowired
  private OwnerRepository ownerRepository;
  
  @GetMapping(value = "")
  public List<Owner> getAllStudents() {
      return ownerService.findAll();
  }


  @GetMapping(value = "/orderById")
  public List<Owner> findAllByOrderById() {
      return ownerService.findAllByOrderById();
  }
  
  @PostMapping(value="")
  public Owner createOwner(@Valid @RequestBody Owner owner )
  {
	  return  ownerRepository.save(owner);
	 
  }}
/*
  @PostMapping(value = "/")
  public ResponseEntity<?> saveOrUpdateOwner(@RequestBody Owner owner) {
      ownerService.saveOrUpdateOwner(owner);
      return new ResponseEntity<>( "success",HttpStatus.CREATED);
   
  }

  @DeleteMapping(value = "/{id}")
  public void deleteOwner(@PathVariable String id) {
      ownerService.deleteOwner(ownerService.findById(id).getId());
  }

}*/