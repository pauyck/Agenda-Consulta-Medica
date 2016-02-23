package bancodados.cadastro;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/agendar")
public class CadastroConsulta extends HttpServlet {

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
		

		ConsultasMedicas ordemDeServico = new ConsultasMedicas();
		ordemDeServico.setId(id);
		ordemDeServico.setNomePaciente(nomePaciente);
		ordemDeServico.setData(data);
		ordemDeServico.setHorario(horario);
		ordemDeServico.setTelefone(telefone);
		ordemDeServico.setObservacao(observacao);

		if (acao.equals("Incluir")) {
			if (!id.equals("")) {
				ordemDeServico.incluir();
			}
		} else if (acao.equals("Alterar")) {
			if (!id.equals("")) {
				ordemDeServico.alterar(id, nomePaciente, data, horario, telefone, observacao);
			}
		} else if (acao.equals("Excluir")) {
			if (!id.equals("")) {
				ordemDeServico.excluir(id);
			}
		}

		req.setAttribute("ordemDeServico", ordemDeServico); // Passando um objeto para o JSP.

		List<ConsultasMedicas> ordemDeServicos = ConsultasMedicas.listar();
		req.setAttribute("ordemDeServicos", ordemDeServicos); // Passando uma coleção para o
											// JSP.

		// Chamar o JSP apenas para mostrar o resultado.
		req.getRequestDispatcher("agendar.jsp").forward(req, resp);
	}

}
