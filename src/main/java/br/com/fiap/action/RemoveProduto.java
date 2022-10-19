package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.ProdutoDAO;

public class RemoveProduto extends Action{
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public RemoveProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			this.produtoDAO.excluir(Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		response.sendRedirect("./produto?mode=ListaProduto");
	}
}
