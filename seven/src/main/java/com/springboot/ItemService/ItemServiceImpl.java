package com.springboot.ItemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Entity.Category;
import com.springboot.Entity.Item;
import com.springboot.ItemException.ItemExcepion;
import com.springboot.ItemRepository.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepo itemrepo;

	@Override
	public Item add(Item item) throws ItemExcepion {
		// TODO Auto-generated method stub

		if (item != null) {
			if (itemrepo.existsById(item.getId())) {
				throw new ItemExcepion("there exists an employee with the givrn id");
			} else if (itemrepo.existsByItemName(item.getItemName())) {
				throw new ItemExcepion("there exists an employee with the givrn mobile no ");
			} else {
				item = itemrepo.save(item);
			}
		}
		return item;
	}

	public Item findByid(Long itemNo) {
		// TODO Auto-generated method stub
		return itemrepo.findById(itemNo).orElse(null);
	}

	public List<Item> findAll() {
		return itemrepo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 itemrepo.deleteById(id);
	}

}