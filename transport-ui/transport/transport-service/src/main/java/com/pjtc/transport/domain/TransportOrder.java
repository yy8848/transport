package com.pjtc.transport.domain;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TransportOrder{
	private long id;
	
	private Account shipper;
	private List<TransportOrderItem> items = new ArrayList<TransportOrderItem>();
	private User createdBy;
	private Date createdAt;
	private User lastChangedBy;
	private Date lastChangedAt;
	
	
	public TransportOrder(){
		
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;	
	}
	
	public Account getShipper() {
		return shipper;
	}

	public void setShipper(Account shipper) {
		this.shipper = shipper;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getLastChangedBy() {
		return lastChangedBy;
	}

	public void setLastChangedBy(User lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	public Date getLastChangedAt() {
		return lastChangedAt;
	}

	public void setLastChangedAt(Date lastChangedAt) {
		this.lastChangedAt = lastChangedAt;
	}	
	
	public List<TransportOrderItem> getItems(){
		return items;
	}
	
	public void setItems(List<TransportOrderItem> items){
		this.items = items;
		if (items != null){
			for (TransportOrderItem item: items){
				item.setOrder(this);
			}
		}
	}
	
	public void addItem(TransportOrderItem item){
		if (item != null){
			items.add(item);
			item.setOrder(this);
		}
	}
	
	public void removeItem(TransportOrderItem item){
		item.setOrder(null);
		items.remove(item);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransportOrder other = (TransportOrder) obj;
		if (id != other.id)
			return false;
		return true;
	}


}