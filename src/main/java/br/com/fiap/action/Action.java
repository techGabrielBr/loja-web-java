package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public default String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	};
	public default String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	};
}
