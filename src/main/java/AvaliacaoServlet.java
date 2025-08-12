import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet(urlPatterns = { "/cadastrar", "/editar", "/excluir"})
 
public class AvaliacaoServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	private AvaliacaoDAO dao;

	@Override
	public void init() {
		dao = new AvaliacaoDAOImpl();
	}

	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		String action = request.getServletPath();
 
		try {
			switch (action) {
			case "/cadastrar":
				cadastrarAvaliacao(request, response);
				break;
 
			case "/editar":
				editarAvaliacao(request, response);
				break;
 
			case "/excluir":
				excluirAvaliacao(request, response);
				break;
 
			}
 
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
 
	}
 
	private void cadastrarAvaliacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String nota = request.getParameter("nota");
		String descricao = request.getParameter("descricao");
		String usuario = request.getParameter("usuario");
		String[] destaques = request.getParameter("destaques");
		String estabelecimento = request.getParameter("estabelecimento");
		dao.inserirAvaliacao(new Avaliacao(nota, descricao, usuario, destaques, estabelecimento));

		response.sendRedirect("/");
	}
 
	private void editarAvaliacao(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException, SQLException {
		long id = Long.parseLong(request.getParameter("id"));

		String nota = request.getParameter("nota");

		String descricao = request.getParameter("descricao");

		String[] destaques = request.getParameterValues("destaques");

		dao.atualizarAvaliacao(new Avaliacao(id, nota, descricao, destaques))

	}

/*

	private void desconectarUsuario(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
 
		HttpSession session = request.getSession(false);

		if(session != null) {

			session.invalidate();

		}

		response.sendRedirect("/login");

	}
 
}

}
 
