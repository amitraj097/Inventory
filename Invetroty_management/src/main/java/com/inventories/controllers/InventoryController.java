package com.inventories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventories.entities.InventoryItems;
import com.inventories.services.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@PostMapping
	public ResponseEntity<InventoryItems> createInventory(@RequestBody InventoryItems items) {
		return ResponseEntity.ok(inventoryService.createInventory(items));
	}

	@PutMapping("/{id}")
	public ResponseEntity<InventoryItems> updateItems(@PathVariable Long id, @RequestBody InventoryItems itemsDetails) {
		return ResponseEntity.ok(inventoryService.updateItem(id, itemsDetails));
	}

	@GetMapping
	public ResponseEntity<List<InventoryItems>> getAllItems() {

		return ResponseEntity.ok(inventoryService.getAllInvetory());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable Long id) {

		inventoryService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/stock")
	public ResponseEntity<Integer> getStock() {
		return ResponseEntity.ok(inventoryService.getStock());
	}
}
