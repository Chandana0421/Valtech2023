package com.valtech.training.hibernate.assignment;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


@Entity
@IdClass(ItemsVendorsPK.class)
public class ItemsVendors {
	
	@Id
	@ManyToOne(targetEntity = Items.class,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "item_id",referencedColumnName = "id")
	private Items items;
	
	@Id
	@ManyToOne(targetEntity = Vendors.class,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "vendor_id",referencedColumnName = "id")
	private Vendors vendor;

	public ItemsVendors() {
	}

	public ItemsVendors(Items items, Vendors vendor) {
//		this.id = new ItemsVendorsPK(items.getId(),vendor.getId());
		this.items = items;
		this.vendor = vendor;
	}

//	public ItemsVendorsPK getId() {
//		return id;
//	}
//
//	public void setId(ItemsVendorsPK id) {
//		this.id = id;
//	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Vendors getVendor() {
		return vendor;
	}

	public void setVendor(Vendors vendor) {
		this.vendor = vendor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(items, vendor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsVendors other = (ItemsVendors) obj;
		return Objects.equals(items, other.items) && Objects.equals(vendor, other.vendor);
	}


}
