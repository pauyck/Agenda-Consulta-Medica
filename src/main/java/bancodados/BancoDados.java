package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
	public static void main(String[] args) throws SQLException {
		// Derby em mem�ria.
		// jdbc:derby:memory:banco-de-dados;create=true

		// MySQL
		// jdbc:mysql://localhost/banco-de-dados

		// Obter uma conex�o com o banco de dados.
		// URL de conex�o com o banco de dados Derby local.
		String url = "jdbc:derby:C:\\agendamedica;create=true";
		Connection conn = DriverManager.getConnection(url);

		// conn.setAutoCommit(false);
		// try {
		// Opera��o de d�bito.
		// Opera��o de cr�dito.
		// conn.commit();
		// } catch (Throwable e) {
		// conn.rollback();
		// }

		// listarAlunos(conn);
		// apagarAluno(conn);
		// alterarAluno(conn);
		// incluirAluno(conn);
		// criarTabelaAluno(conn);

		conn.close();
	}

	private static void listarAlunos(Connection conn) throws SQLException {
		String sql = "select * from aluno order by id";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instru��o SQL.
		ResultSet rs = prepareStatement.executeQuery();
		while (rs.next()) {
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");

			System.out.println("Matr�cula: " + matricula);
			System.out.println("Nome: " + nome);
			System.out.println();
		}
		rs.close();
		prepareStatement.close();
	}

	private static void apagarAluno(Connection conn) throws SQLException {
		String sql = "delete from aluno where matricula=?";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 1);
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void alterarAluno(Connection conn) throws SQLException {
		String sql = "update aluno set nome=? where matricula=?";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, "Marcant�nio");
		prepareStatement.setInt(2, 1);
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void incluirAluno(Connection conn) throws SQLException {
		String sql = "insert into aluno (matricula, nome) values (?, ?)";
		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, 2);
		prepareStatement.setString(2, "Maria");
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}

	private static void criarTabelaAluno(Connection conn) throws SQLException {
		String sql = "create table aluno (";
		sql += "matricula int, ";
		sql += "nome varchar(255) ";
		sql += ")";

		// Obt�m refer�ncia para uma senten�a SQL.
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		// Executa a instru��o SQL.
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
}