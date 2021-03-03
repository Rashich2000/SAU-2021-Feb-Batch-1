package com.accolite.domain;

public class RestaurantEvent {

	private String orderedItem;
	private Customer customer;
	//private LibraryEventType libraryEventType;
	public String getOrderedItem() {
		return orderedItem;
	}
	public void setOrderedItem(String orderedItem) {
		this.orderedItem = orderedItem;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	/*
	 * public LibraryEventType getLibraryEventType() { return libraryEventType; }
	 * 
	 * public void setLibraryEventType(LibraryEventType libraryEventType) {
	 * this.libraryEventType = libraryEventType; }
	 */

}
