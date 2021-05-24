/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.filtro;

import com.bruno.enade.model.Usuario;
import com.bruno.enade.util.Constants;
import java.io.IOException;
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
@WebFilter(filterName = "appAuth", urlPatterns = {"/index.xhtml", "/tipoUsuario.xhtml", "/usuarios.xhtml", "/tipoQuestao.xhtml", "/questoes.xhtml", "/prova.xhtml"})
public class appAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = (HttpSession) req.getSession();

        Usuario usuario = (Usuario) session.getAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO);
        if (usuario == null) {
            chain.doFilter(request, response);
//            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

}
