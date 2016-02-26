package bancodados.cadastro;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/agendarconsulta")
public class AgendaConsulta extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramId = req.getParameter("id");
		String id = paramId == null ? "" : paramId;
		
		String paramNomePaciente = req.getParameter("nomePaciente");
		String nomePaciente = paramNomePaciente == null ? "" : paramNomePaciente;
		
		String paramData = req.getParameter("data");
		String data = paramData == null ? "" : paramData;
		
		String paramHorario = req.getParameter("horario");
		String horario = paramHorario == null ? "" : paramHorario;
		
		String paramTelefone = req.getParameter("telefone");
		String telefone = paramTelefone == null ? "" : paramTelefone;
		
		String paramObservacao = req.getParameter("observacao");
		String observacao = paramObservacao == null ? "" : paramObservacao;
		
		String paramAcao = req.getParameter("acao");
		String acao = paramAcao == null ? "" : paramAcao;
		

		ConsultasMedicas consulta = new ConsultasMedicas();
		consulta.setId(id);
		consulta.setNomePaciente(nomePaciente);
		consulta.setData(data);
		consulta.setHorario(horario);
		consulta.setTelefone(telefone);
		consulta.setObservacao(observacao);

		
		if (acao.equals("Incluir")) {
			if (!id.equals("")) {
				consulta.incluir();
			}
		} else if (acao.equals("Alterar")) {
			if (!id.equals("")) {
				consulta.alterar(id, nomePaciente, data, horario, telefone, observacao);
			}
		} else if (acao.equals("Excluir")) {
			if (!id.equals("")) {
				consulta.excluir(id);
			}
		}

		
		req.setAttribute("consultaMedica", consulta); // Passando um objeto para o JSP.

		List<ConsultasMedicas> consultaMedica = ConsultasMedicas.listar();
		
		req.setAttribute("consultaMedica", consultaMedica); // Passando uma coleção para o JSP.

		// Chamar o JSP apenas para mostrar o resultado.
		req.getRequestDispatcher("/agendar.jsp").forward(req, resp);
	}

}
