package procedurepackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mypackage.ConnectionFactory;

public class ContatoINProcedureDAO {
	   private Connection connection;
		 
	   public ContatoINProcedureDAO() {
	     this.connection = new ConnectionFactory().getConnection();
	   }
	   
	   
	   public void chamarProcedureIN() {
		     String sql = "{call RENAN(?)}";
		 
		     CallableStatement callableStatement = null;
		     try {
		    	 callableStatement = connection
		                 .prepareCall(sql);
		    	 callableStatement.setInt(1, 3);
		    	 
		    	  ResultSet rs = callableStatement.executeQuery();
		    	  while (rs.next()) {
		    		  System.out.print(rs.getString("NOME"));
		    	  }
		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }
		 }
	   
}
