package mypackage;

import java.sql.SQLException;
import java.util.Calendar;

import procedurepackage.ContatoINProcedureDAO;
import transactionpackage.ContatoTransactionDAO;

public class Main {
	public static void main(String[] args) throws SQLException {

//	      Contato contato = new Contato();
//	      contato.setNome("Renan");
//	      contato.setEmail("renan@gmail.com");
//	      contato.setEndereco("Rua minha rua");
//	      contato.setDataNascimento(Calendar.getInstance());
//
//	      // grave nessa conexão!!!
//	      ContatoDAO bd = new ContatoDAO();
//
//	      // método elegante
//	      bd.adiciona(contato);
//
//	      System.out.println("Gravado!");
		
//	      new ContatoTransactionDAO().inserirVariosRegistrosNoBanco();
	      new ContatoINProcedureDAO().chamarProcedureIN();
	  }
}
