package br.com.fiap.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {};
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {};
}
