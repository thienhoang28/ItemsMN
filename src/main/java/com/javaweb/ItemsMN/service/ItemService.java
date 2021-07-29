package com.javaweb.ItemsMN.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaweb.ItemsMN.model.Items;
import com.javaweb.ItemsMN.repository.ItemsRepository;

@Service
public class ItemService {

	@Autowired
	private ItemsRepository itemRepo;
	
	public List<Items> findAll(){
		return itemRepo.findAll();
	}
	
	public Items save(Items item) {
		return itemRepo.save(item);
	}
	
	public Optional<Items> findById(Long id) {
		return itemRepo.findById(id);
	}
	
	public Page<Items> findPaginated(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return itemRepo.findAll(pageable);
	}
}
