package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CategoriaDAO;

public class CriaCategoria implements Action{
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public CriaCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		
		this.categoriaDAO.salvar(nome);
		return "redirect:./categoria?mode=ListaCategoria";
	}
}
