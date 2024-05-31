package com.inventories.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventories.entities.InventoryItems;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItems, Long> {

}
