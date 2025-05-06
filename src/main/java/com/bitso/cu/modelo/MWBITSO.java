package com.bitso.cu.modelo;

import java.util.List ;

public class MWBITSO {
	private Boolean success ;
	private List< TablaTRX > payload ;
	
	public Boolean getSuccess() {
		return success;
	}
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public List<TablaTRX> getPayload() {
		return payload;
	}
	
	public void setPayload(List<TablaTRX> payload) {
		this.payload = payload;
	}	
}