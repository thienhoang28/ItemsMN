package com.javaweb.ItemsMN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.ItemsMN.model.Type_Item;
import com.javaweb.ItemsMN.repository.TypeItemRepository;

@Service
public class TypeItemService {
	
	@Autowired
	private TypeItemRepository typeitemRepo;
	
	public List<Type_Item> findAll(){
		return typeitemRepo.findAll();
	}
}
