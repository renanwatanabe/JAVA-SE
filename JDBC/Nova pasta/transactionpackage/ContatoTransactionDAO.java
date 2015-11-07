package transactionpackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import mypackage.ConnectionFactory;

public class ContatoTransactionDAO {
	private Connection connection;
	 
	   public ContatoTransactionDAO() {
	     this.connection = new ConnectionFactory().getConnection();
	   }
	   
	   public void inserirVariosRegistrosNoBanco() throws SQLException {

			PreparedStatement preparedStatementInsert1 = null;
			PreparedStatement preparedStatementInsert2 = null;
			
		     String sql = "insert into contatos " +
		             "(nome,email,endereco,dataNascimento)" +
		             " values (?,?,?,?)";

			try {
				preparedStatementInsert1 = connection.prepareStatement(sql);
				preparedStatementInsert2 = connection.prepareStatement(sql);

				connection.setAutoCommit(false);

				preparedStatementInsert1.setString(1,"Renan1");
				preparedStatementInsert1.setString(2,"Renan1");
				preparedStatementInsert1.setString(3,"Renan1");
				preparedStatementInsert1.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
				preparedStatementInsert1.executeUpdate();

				preparedStatementInsert2.setInt(4,1); //erro aqui
				preparedStatementInsert2.setString(2,"Renan2");
				preparedStatementInsert2.setString(3,"Renan2");
				preparedStatementInsert2.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));//erro aqui
				preparedStatementInsert2.executeUpdate();
				
				connection.commit();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				connection.rollback();

			} finally {
				if (preparedStatementInsert1 != null) {
					preparedStatementInsert1.close();
				}
				
				if (preparedStatementInsert2 != null) {
					preparedStatementInsert2.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
		}

}
