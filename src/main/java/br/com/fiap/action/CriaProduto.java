package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.model.Produto;

public class CriaProduto extends Action{
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public CriaProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/pages/criaProduto.jsp");
		rd.forward(request, response);
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produto produto = new Produto();
		
		produto.setNome(request.getParameter("name"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setCategoriaId(Integer.parseInt(request.getParameter("idCategoria")));
		
		this.produtoDAO.salvarComCategoria(produto);
		response.sendRedirect("./produto?mode=ListaProduto");
	}
}
