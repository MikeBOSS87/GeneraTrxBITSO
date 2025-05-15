package com.bitso.cu.modelo;

import java.io.Serializable;

public class TablaTRX implements Serializable{
	
	private Integer tid ;
	private String maker_side ;
	private String created_at ;
	private String amount ;
	private String book ;
	private String price ;
	private static final long serialVersionUID = -5316415964387925L;
	
	/**
	 * @return the tid
	 */
	public Integer getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	/**
	 * @return the maker_side
	 */
	public String getMaker_side() {
		return maker_side;
	}
	/**
	 * @param maker_side the maker_side to set
	 */
	public void setMaker_side(String maker_side) {
		this.maker_side = maker_side;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the book
	 */
	public String getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(String book) {
		this.book = book;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "TablaTRX [tid=" + tid + ", maker_side=" + maker_side + ", created_at=" + created_at + ", amount="
				+ amount + ", book=" + book + ", price=" + price + "]";
	}
}