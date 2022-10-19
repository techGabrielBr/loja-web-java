package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;

public class EditaCategoria extends Action{
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public EditaCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria categoria = new Categoria();
		
		categoria.setIdCategoria(Integer.parseInt(request.getParameter("id")));
		categoria.setNome(request.getParameter("nome"));
		
		this.categoriaDAO.atualizar(categoria);
		response.sendRedirect("./categoria?mode=ListaCategoria");
	}
}
