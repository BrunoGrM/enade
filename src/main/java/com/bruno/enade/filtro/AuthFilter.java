/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.filtro;

import com.bruno.enade.model.Usuario;
import com.bruno.enade.util.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {

    private final String telaLogin = "/login.xhtml";
    private final List<String> telasAluno = Arrays.asList("/index.xhtml", "/realizarProva.xhtml");
    private final List<String> telasProfessor = Arrays.asList(
            "/index.xhtml",
            "/tipoUsuario.xhtml",
            "/usuarios.xhtml",
            "/tipoQuestao.xhtml",
            "/questoes.xhtml",
            "/prova.xhtml",
            "/consultaUsuario.xhtml",
            "/consultaProva.xhtml",
            "/relatorio.xhtml"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession ses = req.getSession();

        String reqURI = req.getRequestURI();
        Usuario usuarioLogado = ses != null ? (Usuario) ses.getAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO) : null;
        if (reqURI.contains(telaLogin) && usuarioLogado != null) {
            // Usuário logado tentando acessar a tela de login
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        } else if (reqURI.contains(telaLogin) || usuarioLogado != null || reqURI.contains("javax.faces.resource")) {
            if (usuarioLogado == null) {
                // Tratar se a variável usuário não está vazia
                chain.doFilter(request, response);
            } else if (reqURI.contains("javax.faces.resource")) {
                // Requisição de outros arquivos sem ser os xhtml
                chain.doFilter(request, response);
            } else if (usuarioLogado.getTipoUsuarioidTipoUsuario().getNomeTipoUsuario().equals("Professor") && telasProfessor.contains(reqURI.replace("/Enade", ""))) {
                // Acessar as telas permitidas de professor
                chain.doFilter(request, response);
            } else if (usuarioLogado.getTipoUsuarioidTipoUsuario().getNomeTipoUsuario().equals("Aluno") && telasAluno.contains(reqURI.replace("/Enade", ""))) {
                // Acessar as telas permitidas de aluno
                chain.doFilter(request, response);
            } else if (!telasProfessor.contains(reqURI.replace("/Enade", "")) && !telasAluno.contains(reqURI.replace("/Enade", ""))) {
                // Tratar ao acessar uma página não encontrada
                chain.doFilter(request, response);
            } else {
                // Se o usuário não puder acessar a página de acordo com o seu perfil é redirecionado ao login
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            }
        } else {
            // Usuário deslogado tentando acessar qualquer página que precise de autenticação
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }

}
