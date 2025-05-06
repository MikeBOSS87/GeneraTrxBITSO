package com.bitso.cu.consumidor;

import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bitso.cu.modelo.MWBITSO;
import com.bitso.cu.modelo.TablaTRX;
import com.bitso.cu.repositorio.TrxBITSO;

@Service
public class ConsumidorTrxBITSO {
	
	@PostConstruct
	public void ConsumidorTRX( ){
		Consume( "BTC-MXN" );
		Consume( "ETH-MXN" );
		Consume( "MAN-MXN" );
		Consume( "SOL-MXN" );
		Consume( "TRX-MXN" );
		Consume( "ADA-USD" );
	}
	
	private void Consume( String Mercado ) {
		RestTemplate template = new RestTemplate();
		String url = "" ;
		
		if( Mercado == "ETH-MXN" ) {
			url = "https://api.bitso.com/v3/trades/?book=eth_mxn";
		}
		else if( Mercado == "BTC-MXN" ) {
			url = "https://api.bitso.com/v3/trades/?book=btc_mxn";
		}
		else if( Mercado == "MAN-MXN" ) {
			url = "https://api.bitso.com/v3/trades/?book=mana_mxn";
		}
		else if( Mercado == "SOL-MXN" ) {
			url = "https://api.bitso.com/v3/trades/?book=sol_mxn";
		}
		else if( Mercado == "TRX-MXN" ) {
			url = "https://api.bitso.com/v3/trades/?book=trx_mxn";
		}
		else if( Mercado == "ADA-USD" ) {
			url = "https://api.bitso.com/v3/trades/?book=ada_usd";
		}
		
	    ResponseEntity< MWBITSO > WS = template.exchange( url, HttpMethod.GET, HttpEntity.EMPTY,
	        new ParameterizedTypeReference< MWBITSO >()
	        {
	          @Override
	          public Type getType()
	          {
	            return super.getType();
	          }
	        } );
	    
	    MWBITSO obj = WS.getBody();
	    List<TablaTRX> Grid = obj.getPayload() ;
	    
	    TrxBITSO B = new TrxBITSO() ;
	    B.GuardaTrxBITSO( Grid );
	}
}