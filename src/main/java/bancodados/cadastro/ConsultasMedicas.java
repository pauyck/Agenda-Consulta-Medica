package bancodados.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsultasMedicas {
	private String id;
	private String nomePaciente;
	private String data;
	private String telefone;
	private String horario;
	private String observacao;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public void incluir() {
		try {
			// Obtém a conexão.
			String url = "jdbc:derby:C:\\agendamedica;create=true";
			Connection conn = DriverManager.getConnection(url);
			// Cria a sentença SQL.
			String sql = "insert into agendamedica (id, nomePaciente, telefone, data, horario, observacao) values (?, ?, ?, ?, ?, ?)";
			// Obtém referência para uma sentença SQL.
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, id);
			prepareStatement.setString(2, nomePaciente);
			prepareStatement.setString(3, telefone);
			prepareStatement.setString(4, data);
			prepareStatement.setString(5, horario);
			prepareStatement.setString(6, observacao);
			// Executa a instrução SQL.
			prepareStatement.executeUpdate();
			// Fecha a sentença.
			prepareStatement.close();
			// Fecha a conexão.
			conn.close();
		} catch (Throwable e) {
			// Para repassar a exceção para o container tratar.
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(String id, String nomePaciente, String data, String horario, String telefone,String observacao){
		try {
			// Obt�m a conex�o.
			String url = "jdbc:derby:C:\\agendamedica";
			
			Connection conn = DriverManager.getConnection(url);

			// Cria a senten�a SQL.	
			String sql = "update agendamedica set nomePaciente=?, data=?, horario=?, telefone=?, observacao=? where id=?";
			
			// Obt�m refer�ncia para uma senten�a SQL.
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, id);
			prepareStatement.setString(2, nomePaciente);
			prepareStatement.setString(3, data);
			prepareStatement.setString(4, horario);
			prepareStatement.setString(5, telefone);
			prepareStatement.setString(6, observacao);

			// Executa a instru��o SQL.
			prepareStatement.executeUpdate();
			
			// Fecha a senten�a.
			prepareStatement.close();
			
			// Fecha a conex�o.
			conn.close();
		} catch (Throwable e) {
			// Para repassar a exce��o para o container tratar.
			throw new RuntimeException(e);
		}
	}

	public void excluir(String id1) {
		try {
			// Obt�m a conex�o.
			String url = "jdbc:derby:C:\\agendamedica";
			Connection conn = DriverManager.getConnection(url);
			// Cria a senten�a SQL.
			String sql = "delete from agendamedica where id=?";
			// Obt�m refer�ncia para uma senten�a SQL.
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, id1);
			// Executa a instru��o SQL.
			prepareStatement.executeUpdate();
			prepareStatement.close();
			conn.close();
		} catch (Throwable e) {
			// Para repassar a exceção para o container tratar.
			throw new RuntimeException(e);
		}
	}
	
	public static List<ConsultasMedicas> listar() {
	    List<ConsultasMedicas> consultaMedica = new ArrayList<ConsultasMedicas>();
	    try {
	      
	      //Obt�m a conex�o.
	      String url = "jdbc:derby:C:\\agendamedica;create=true";
	      Connection conn = DriverManager.getConnection(url);
	      //Cria a senten�a SQL.
	      String sql = "select * from agendamedica order by id";
	      //Obt�m referência para uma senten�a SQL.
	      PreparedStatement prepareStatement = conn.prepareStatement(sql);
	      //Executa a instru��o SQL.
	      ResultSet rs = prepareStatement.executeQuery();
	      while (rs.next()) {
				
	        ConsultasMedicas a = new ConsultasMedicas();
	        a.setId(rs.getString("id"));
	        a.setNomePaciente(rs.getString("nomePaciente"));
	        a.setTelefone(rs.getString("telefone"));
	        a.setData(rs.getString("data"));
	        a.setHorario(rs.getString("horario"));
	        a.setObservacao(rs.getString("observacao"));
	        

	        consultaMedica.add(a);
	      }
	      //Fecha o ResultSet.
	      rs.close();
	      //Fecha a sentença.
	      prepareStatement.close();
	      //Fecha a conexão.
	      conn.close();
	    } catch (Throwable e) {
	      //Para repassar a exceção para o container tratar.
	      throw new RuntimeException(e);
	    }

	    return consultaMedica;
	}

}

