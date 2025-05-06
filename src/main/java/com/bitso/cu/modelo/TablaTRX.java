package com.bitso.cu.modelo;

public class TablaTRX {
		
	private Integer tid ;
	private String maker_side ;
	private String created_at ;
	private String amount ;
	private String book ;
	private String price ;
	
	public Integer getTid() {
		return tid;
	}
	
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
	public String getMaker_side() {
		return maker_side;
	}
	
	public void setMaker_side(String maker_side) {
		this.maker_side = maker_side;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public String getBook() {
		return book;
	}
	
	public void setBook(String book) {
		this.book = book;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
}