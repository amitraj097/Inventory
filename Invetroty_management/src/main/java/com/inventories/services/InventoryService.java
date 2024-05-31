package com.inventories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventories.entities.InventoryItems;
import com.inventories.exceptions.ResourceNotFoundException;
import com.inventories.repositories.InventoryItemRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryItemRepository itemRepository;

	public InventoryItems createInventory(InventoryItems items) {
		return itemRepository.save(items);
	}

	public InventoryItems updateItem(Long id, InventoryItems itemDetails) {

		InventoryItems items = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));
		items.setName(itemDetails.getName());
		items.setCategorty(itemDetails.getCategorty());
		items.setQuantity(itemDetails.getQuantity());
		return itemRepository.save(items);
	}

	public List<InventoryItems> getAllInvetory() {

		return itemRepository.findAll();
	}

	public void deleteItem(Long id) {

		InventoryItems inventoryItems = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
		itemRepository.delete(inventoryItems);
	}

	public int getStock() {

		return itemRepository.findAll().stream().mapToInt(InventoryItems::getQuantity).sum();
	}
}
