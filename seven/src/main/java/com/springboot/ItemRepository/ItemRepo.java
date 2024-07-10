package com.springboot.ItemRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Category;
import com.springboot.Entity.Item;


@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

	boolean existsByItemName(String itemName);
	 
}
