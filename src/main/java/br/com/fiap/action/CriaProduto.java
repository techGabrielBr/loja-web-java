package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.model.Produto;

public class CriaProduto implements Action{
	private ProdutoDAO produtoDAO;

    /**
     * Default constructor. 
     */
    public CriaProduto() {
        // TODO Auto-generated constructor stub
    	this.produtoDAO = new ProdutoDAO();
    }
    
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		return "forward:./WEB-INF/pages/criaProduto.jsp";
    }

	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produto produto = new Produto();
		
		produto.setNome(request.getParameter("name"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setCategoriaId(Integer.parseInt(request.getParameter("idCategoria")));
		
		this.produtoDAO.salvarComCategoria(produto);
		return "redirect:./produto?mode=ListaProduto";
	}
}
