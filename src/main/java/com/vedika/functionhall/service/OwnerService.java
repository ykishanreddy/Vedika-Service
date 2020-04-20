package com.vedika.functionhall.service;

import java.util.List;

import com.vedika.functionhall.model.Owner;

public interface OwnerService {

    List<Owner> findAll();

  
    List<Owner> findAllByOrderById();
    
    void saveOrUpdateOwner(Owner owner);

    void deleteOwner(String id);

}