package batchpackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import mypackage.ConnectionFactory;

public class ContatoBatchDAO {
	   private Connection connection;
		 
	   public ContatoBatchDAO() {
	     this.connection = new ConnectionFactory().getConnection();
	   }
	   
	   
	   
	   public void inserirVariosRegistrosNoBanco() throws SQLException {

			PreparedStatement preparedStatement = null;

		     String sql = "insert into contatos " +
		             "(nome,email,endereco,dataNascimento)" +
		             " values (?,?,?,?)";

			try {
				preparedStatement = connection.prepareStatement(sql);

				connection.setAutoCommit(false);

				preparedStatement.setString(1,"Renan1");
				preparedStatement.setString(2,"Renan1");
				preparedStatement.setString(3,"Renan1");
				preparedStatement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
				preparedStatement.addBatch();

				preparedStatement.setString(1,"Renan2");
				preparedStatement.setString(2,"Renan2");
				preparedStatement.setString(3,"Renan2");
				preparedStatement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
				preparedStatement.addBatch();

				preparedStatement.setString(1,"Renan3");
				preparedStatement.setString(2,"Renan3");
				preparedStatement.setString(3,"Renan3");
				preparedStatement.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
				preparedStatement.addBatch();

				preparedStatement.executeBatch();
				connection.commit();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				connection.rollback();

			} finally {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
		}

}
