package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CategoriaDAO;

public class RemoveCategoria implements Action{
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public RemoveCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.categoriaDAO.excluir(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return "redirect:./categoria?mode=ListaCategoria";
	}
}
