package br.com.fiap.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.action.Action;

/**
 * Servlet implementation class Produto
 */
@WebServlet(urlPatterns={"/produto", ""})
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProdutoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String mode = request.getParameter("mode");
		final String defaultPath = "br.com.fiap.action.";
		final String method = request.getMethod();

		Action classe = null;
		try {
			if(mode != null) {
				classe = (Action) Class.forName(defaultPath + mode).getDeclaredConstructor().newInstance();
				
				if(method.equals("POST")) {
					classe.doPost(request, response);
				} else if(method.equals("GET")) {
					classe.doGet(request, response);
				}
			}else {
				classe = (Action) Class.forName(defaultPath + "CriaProduto").getDeclaredConstructor().newInstance();
				classe.doGet(request, response);
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/error/error.jsp");
			rd.forward(request, response);
		}
	}

}
