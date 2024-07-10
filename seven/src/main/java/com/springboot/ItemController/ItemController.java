package com.springboot.ItemController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ItemService.ItemService;
import com.springboot.Entity.Item;
import com.springboot.ItemException.ItemExcepion;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemservice;

	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		return new ResponseEntity<List<Item>>(itemservice.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{ItemNo:[0-9]{1,4}}")
	public ResponseEntity<Item> findById(@PathVariable("ItemNo") Long ItemNo) {
		ResponseEntity<Item> response = null;

		Item emp = itemservice.findByid(ItemNo);

		if (emp == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(emp, HttpStatus.OK);
		}
		return response;
	}

	@PostMapping
	public ResponseEntity<Item> createEmployee(@RequestBody Item item) throws ItemExcepion {
		item = itemservice.add(item);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		ResponseEntity<Void> response = null;

		Item itemdelete = itemservice.findByid(id);

		if (itemdelete == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			itemservice.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}

}
