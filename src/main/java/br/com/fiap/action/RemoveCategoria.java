package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CategoriaDAO;

public class RemoveCategoria extends Action{
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public RemoveCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.categoriaDAO.excluir(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		response.sendRedirect("./categoria?mode=ListaCategoria");
	}
}
