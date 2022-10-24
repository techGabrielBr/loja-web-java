package br.com.fiap.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;

public class ListaProdutoPorCategoria implements Action{
	
	private CategoriaDAO categoriaDAO;

    /**
     * Default constructor. 
     */
    public ListaProdutoPorCategoria() {
        // TODO Auto-generated constructor stub
    	this.categoriaDAO = new CategoriaDAO();
    }

	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> lista = this.categoriaDAO.listarComProduto();
		
		request.setAttribute("categorias", lista);
		return "forward:./WEB-INF/pages/listaPorCategoria.jsp";
	}

}
