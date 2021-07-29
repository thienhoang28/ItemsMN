package com.javaweb.ItemsMN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.ItemsMN.model.Type_Item;

@Repository
public interface TypeItemRepository extends JpaRepository<Type_Item, Long> {

}
