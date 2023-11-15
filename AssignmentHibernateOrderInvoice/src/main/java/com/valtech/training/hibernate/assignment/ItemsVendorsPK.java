package com.valtech.training.hibernate.assignment;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.cache.ReadWriteCache.Item;

public class ItemsVendorsPK implements Serializable{

    private Items itemId;
    private Vendors vendorId;
	
	
	public ItemsVendorsPK() {
	}


	public ItemsVendorsPK(Items itemId, Vendors vendorId) {
		this.itemId = itemId;
		this.vendorId = vendorId;
	}


	public Items getItemId() {
		return itemId;
	}


	public void setItemId(Items itemId) {
		this.itemId = itemId;
	}


	public Vendors getVendorId() {
		return vendorId;
	}


	public void setVendorId(Vendors vendorId) {
		this.vendorId = vendorId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(itemId, vendorId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsVendorsPK other = (ItemsVendorsPK) obj;
		return Objects.equals(itemId, other.itemId) && Objects.equals(vendorId, other.vendorId);
	}
	

	
}
