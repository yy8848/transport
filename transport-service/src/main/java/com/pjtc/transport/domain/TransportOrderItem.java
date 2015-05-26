package com.pjtc.transport.domain;

public class TransportOrderItem{
	private TransportOrder order;
	private long id;
	
	private String product;
	private String productType;
	private double weight;
	private String weightUoM;
	private int quantity;
	private String quantityUoM;
	private double length;
	private String lengthUoM;
	
	public TransportOrderItem(){
	
	}
	
	public void setOrder(TransportOrder order){
		this.order = order;
	}
	
	public TransportOrder getOrder(){
		return order;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	} 
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWeightUoM() {
		return weightUoM;
	}

	public void setWeightUoM(String weightUoM) {
		this.weightUoM = weightUoM;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getQuantityUoM() {
		return quantityUoM;
	}

	public void setQuantityUoM(String quantityUoM) {
		this.quantityUoM = quantityUoM;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getLengthUoM() {
		return lengthUoM;
	}

	public void setLengthUoM(String lengthUoM) {
		this.lengthUoM = lengthUoM;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		TransportOrderItem other = (TransportOrderItem) obj;
		if (id != other.id)
			return false;
		return true;
	}


}