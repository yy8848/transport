package com.pjtc.transport.common;

public class FilterCriterion {
	
	public static final String OPERATOR_EQUAL = "EQ";
	public static final String OPERATOR_LIKE = "LK";
	
	private String fieldName;
	private String operator;
	private String valueLow;
	private String valueHigh;
	
	
	public FilterCriterion() {

	}
	
	public FilterCriterion(String fieldName, String operator, String valueLow) {
		super();
		this.fieldName = fieldName;
		this.operator = operator;
		this.valueLow = valueLow;
	}
	
	public FilterCriterion(String fieldName, String operator, String valueLow,
			String valueHigh) {
		super();
		this.fieldName = fieldName;
		this.operator = operator;
		this.valueLow = valueLow;
		this.valueHigh = valueHigh;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValueLow() {
		return valueLow;
	}

	public void setValueLow(String valueLow) {
		this.valueLow = valueLow;
	}

	public String getValueHigh() {
		return valueHigh;
	}

	public void setValueHigh(String valueHigh) {
		this.valueHigh = valueHigh;
	}
	
}
