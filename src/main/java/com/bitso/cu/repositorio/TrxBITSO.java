package com.bitso.cu.repositorio;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Struct;
import java.sql.Array;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.AbstractSqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import oracle.jdbc.driver.OracleConnection;

import com.bitso.ConfiguracionNexus;
import com.bitso.cu.modelo.TablaTRX ;

public class TrxBITSO {
	private Connection Conector ;
	
	public void GuardaTrxBITSO( List< TablaTRX > tabla ){
		ConfiguracionNexus Nexus = new ConfiguracionNexus() ;
		Object[] grid = new Object[ tabla.size() ] ;
		try {
			String C = Nexus.ObtenDS().getConnection().getMetaData().getDatabaseProductVersion() ;
			System.err.println( C );
			
			Conector = Nexus.ObtenDS().getConnection() ;
			OracleConnection OC = Conector.unwrap( OracleConnection.class ) ;
			
			SqlTypeValue sa = new AbstractSqlTypeValue(){
				Integer I = 0 ;
				@Override
				protected Object createTypeValue( Connection con, int sqlType, String typeName ) throws SQLException {
					for( Iterator<TablaTRX> iterator = tabla.iterator(); iterator.hasNext(); ) {
						TablaTRX tablaTRX = ( TablaTRX ) iterator.next();
						Struct stc = OC.createStruct( "MDRG.TY_OBJ_TNXBITSO", new Object[]{ tablaTRX.getTid(),
								tablaTRX.getMaker_side()  ,
								tablaTRX.getCreated_at() ,
								tablaTRX.getAmount() ,
								tablaTRX.getBook(),
								tablaTRX.getPrice() });
						grid[ I ] = stc ;
						I++ ;
					}
					Array structArray = OC.createOracleArray( "MDRG.TY_TBL_TNXBITSO", grid );
					return structArray ;
				}
			};
			
			SimpleJdbcCall SP = new SimpleJdbcCall( Nexus.ObtenDS() )
					.withSchemaName( "MDRG" )
					.withCatalogName( "CONTROL_TRXBITSO" )
					.withProcedureName( "SPINSERTATXNBITSO" )
					.declareParameters( new SqlParameter[]{
						new SqlParameter( "Pa_Clasificacion", Types.VARCHAR ),
						new SqlParameter( "Pa_TxnBITSO", Types.ARRAY ),
						new SqlOutParameter( "Pa_Mensaje", Types.VARCHAR )
					} ) ;
					
			MapSqlParameterSource mapeoParametros = new MapSqlParameterSource() ;
			mapeoParametros.addValue( "pa_Clasificacion", "USRBATCHECLIPSE" ) ;
			mapeoParametros.addValue( "Pa_TxnBITSO", sa ) ;
			Map<String, Object> Salidas = SP.execute( mapeoParametros );
			
			String Mensaje = ( String )Salidas.get( "Pa_Mensaje" ) ;
			System.out.println( Mensaje );
			OC.close();
		}
		catch( Exception msj ) {
			System.out.println( msj.toString() );
		}
	}
}