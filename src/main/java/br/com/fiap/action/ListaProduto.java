package br.com.fiap.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.model.Produto;

public class ListaProduto extends Action{
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public ListaProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Produto> list = null;
		
		try {
			list = this.produtoDAO.listarTodos();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		request.setAttribute("produtos", list);
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/pages/listaProdutos.jsp");
		rd.forward(request, response);
	}
}
