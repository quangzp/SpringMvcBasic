package com.springmvc.sorter;

public class Sorter {
	private String sortField;
	private String sortBy;

	public Sorter(String sortField, String sortBy) {
		this.setSortField(sortField);
		this.sortBy = sortBy;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}



	public String getSortField() {
		return sortField;
	}



	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
}
