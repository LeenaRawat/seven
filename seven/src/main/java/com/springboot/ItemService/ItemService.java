package com.springboot.ItemService;

import java.time.LocalDate;
import java.util.List;

import com.springboot.Entity.Category;
import com.springboot.Entity.Item;
import com.springboot.ItemException.ItemExcepion;


public interface ItemService {

	Item add(Item item) throws ItemExcepion;

	Item findByid(Long itemNo);

	List<Item> findAll();

	void deleteById(Long id);

	

}
