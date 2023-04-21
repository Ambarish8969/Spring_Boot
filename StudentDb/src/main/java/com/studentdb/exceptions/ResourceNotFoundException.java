package com.studentdb.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String fieldSource;
	private String fieldName;
	private Object fieldValue;

	public ResourceNotFoundException(String fieldSource, String fieldName, Object fieldValue) {
		super(fieldSource+" "+fieldName+" not found for "+fieldValue);
		this.fieldSource = fieldSource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getFieldSource() {
		return fieldSource;
	}

	public void setFieldSource(String fieldSource) {
		this.fieldSource = fieldSource;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException [fieldSource=" + fieldSource + ", fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + "]";
	}

}
