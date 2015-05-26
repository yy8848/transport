package com.pjtc.transport.common;

public class PaginationOption {
	
	private int offset;
	private int count;	
	
	public PaginationOption(int offset, int count) {
		super();
		this.offset = offset;
		this.count = count;
	}
	
	
	public int getOffset() {
		return offset;
	}
	public int getCount() {
		return count;
	}
	
	

}
