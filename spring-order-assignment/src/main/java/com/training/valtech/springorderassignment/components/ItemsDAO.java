package com.training.valtech.springorderassignment.components;

import java.util.List;

public interface ItemsDAO {

	void deleteItems(int id);

	void updateItems(Items item);

	void createItems(Items item);

	List<Items> getAllItems();

	Items getItems(int id);

	long count();

}