package com.bitso.cu.modelo;

import java.io.Serializable;
import java.util.List ;


public class MWBITSO implements Serializable {
	
	private Boolean success ;
	private List< TablaTRX > payload ;
	private static final long serialVersionUID = 1764237701236793662L;
	
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the payload
	 */
	public List<TablaTRX> getPayload() {
		return payload;
	}
	/**
	 * @param payload the payload to set
	 */
	public void setPayload(List<TablaTRX> payload) {
		this.payload = payload;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "MWBITSO [success=" + success + ", payload=" + payload + "]";
	}
}