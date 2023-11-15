package com.valtech.training.firstspringboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valtech.training.firstspringboot.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

	@Query(value = "SELECT o FROM Order o where o.itemCount = ?1")
	List<Order> findAllByItemCount(int ItemCount);

	List<Order> findAllByItemCountGreaterThan(int ItemCount);

	List<Order> findAllByItemAndItemCount(String item, int ItemCount);

	int countByItem(String Item);
}
