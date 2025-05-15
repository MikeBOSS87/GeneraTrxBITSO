package com.bitso;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class ConfiguracionNexus {

	private HikariDataSource DSB = null ;
	
    public DataSource ObtenDS(){
		DSB = new HikariDataSource() ;
		DSB.setDriverClassName( "oracle.jdbc.OracleDriver" );
		DSB.setJdbcUrl( "jdbc:oracle:thin:@localhost:1521:ATLBD" );
		DSB.setUsername( "USRPUENTE" );
		DSB.setPassword( "Puente" );
		DSB.setPoolName( "Conector DB" );
		return( DataSource )DSB ;
	}
}