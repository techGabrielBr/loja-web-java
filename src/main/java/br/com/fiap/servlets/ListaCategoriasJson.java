package br.com.fiap.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;


/**
 * Servlet implementation class listaCategoria
 */
@WebServlet("/json/listaCategoriasJson")
public class ListaCategoriasJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public ListaCategoriasJson() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Categoria> lista = null;
		try {
			lista = this.categoriaDAO.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson json = new Gson();
		
		String categoriaList = json.toJson(lista);
		response.setContentType("text/html");
		response.getWriter().write(categoriaList);
	}

}
