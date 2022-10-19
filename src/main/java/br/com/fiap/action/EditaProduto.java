package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.model.Produto;

public class EditaProduto extends Action{
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public EditaProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produto produto = this.produtoDAO.getById(Integer.parseInt(request.getParameter("id")));
		
		HttpSession session = request.getSession();
		
		session.setAttribute("produto", produto);
		RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/pages/editaProduto.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idProduto = Integer.parseInt(request.getParameter("idProduto"));
		String nome = request.getParameter("name");
		String descricao = request.getParameter("descricao");
		int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
		
		this.produtoDAO.alterar(nome, descricao, categoriaId, idProduto);
		response.sendRedirect("./produto?mode=ListaProduto");
	}
}
