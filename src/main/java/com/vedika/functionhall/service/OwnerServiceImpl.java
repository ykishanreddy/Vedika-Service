package com.vedika.functionhall.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedika.functionhall.model.Owner;
import com.vedika.functionhall.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
    @Override
	public Owner saveOrUpdateOwner(Owner owner) {
      return ownerRepository.save(owner)	;	
	}
	
	@Override
	public List<Owner> findFunctionHallByCity(String city) {
		
		return ownerRepository.findFunctionHallByCity(city);
	}


	@Override
	public List<Owner> findFunctionHallByName(String name) {
		// TODO Auto-generated method stub
		return ownerRepository.findFunctionHallByName(name);
	}




	

	






	

}








	

