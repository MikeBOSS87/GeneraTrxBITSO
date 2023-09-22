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
	public void ConsumidorTRX(){
		String url = "https://api.bitso.com/v3/trades/?book=eth_mxn";
		
	    RestTemplate template = new RestTemplate();
	    
	    ResponseEntity< MWBITSO > WS = template.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
	        new ParameterizedTypeReference< MWBITSO >()
	        {
	          @Override
	          public Type getType()
	          {
	            return super.getType();
	          }
	        });
	    
	    MWBITSO obj = WS.getBody();
	    List<TablaTRX> Grid = obj.getPayload() ;
	    
	    System.err.println("Tamaño:" + Grid.size());
	    
	    TrxBITSO B = new TrxBITSO() ;
	    B.GuardaTrxBITSO( Grid );
	    
	    /*if(Grid.size()>0) {
	      for(TablaTRX st:Grid) {
	        System.out.println( "Tid:" + st.getTid() + " Maker_side:" + st.getMaker_side() 
	        		+ " Created_at:" + st.getCreated_at() + " Amount:" + st.getAmount() + " Book:" + st.getBook() + " Price:" + st.getPrice() );
	      }
	    }*/
	  }
}