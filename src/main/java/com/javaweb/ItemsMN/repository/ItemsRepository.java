package com.javaweb.ItemsMN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.ItemsMN.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
	
}
