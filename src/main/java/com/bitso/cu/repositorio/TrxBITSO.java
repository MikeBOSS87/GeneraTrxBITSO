package com.bitso.cu.repositorio;

import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.Types;
import java.sql.Struct;
import java.sql.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import oracle.jdbc.driver.OracleConnection;

import com.bitso.ConfiguracionNexus;
import com.bitso.cu.modelo.TablaTRX ;

public class TrxBITSO {
	
	@Autowired
	private ConfiguracionNexus Nexus ;
	private Connection Conector ;
	
	public void GuardaTrxBITSO( List< TablaTRX > tabla ){
		try {
			String C = Nexus.ObtenDS().getConnection().getCatalog() ;
			System.err.print( C );
			Conector = Nexus.ObtenDS().getConnection() ;
			OracleConnection OC = Conector.unwrap( OracleConnection.class ) ;
			
			Struct[] stc = new Struct[1] ;
			stc[ 0 ] = OC.createStruct( "USRCREADOR.TY_OBJ_TNXBITSO", tabla.toArray() ) ;
			Array Arreglo = OC.createOracleArray( "USRCREADOR.TY_TBL_TNXBITSO", stc ) ; 
			
			SimpleJdbcCall SP = new SimpleJdbcCall( Nexus.ObtenDS() )
					.withSchemaName( "USRCREADOR" )
					.withCatalogName( "PACSHBITSO" )
					.withProcedureName( "SPINSERTATXNBITSO" )
					.declareParameters( new SqlParameter[]{
						new SqlParameter( "pa_Clasificacion", Types.VARCHAR ),
						new SqlParameter( "Pa_TxnBITSO", Types.ARRAY ),
						new SqlOutParameter( "Pa_Codigo", Types.SMALLINT ),
						new SqlOutParameter( "Pa_Mensaje", Types.VARCHAR )
					} ) ;
					
			MapSqlParameterSource mapeoParametros = new MapSqlParameterSource() ;
			mapeoParametros.addValue( "pa_Clasificacion", "XD" ) ;
			mapeoParametros.addValue( "Pa_TxnBITSO", Arreglo ) ;
			Map<String, Object> Salidas = SP.execute( mapeoParametros );
			
			String Mensaje = ( String )Salidas.get( "Pa_Mensaje" ) ;
			System.out.println( Mensaje );
		}
		catch( Exception msj ) {
			System.out.println( msj.toString() );
		}
	}
}