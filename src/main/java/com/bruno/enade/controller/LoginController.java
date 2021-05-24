/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.controller;

import com.bruno.enade.dao.FactoryDAO;
import com.bruno.enade.dao.UsuarioDAO;
import com.bruno.enade.model.Usuario;
import com.bruno.enade.util.Constants;
import com.bruno.enade.util.EncryptUtil;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<UsuarioDAO> daoClass;

    private Usuario usuario = new Usuario();

    public LoginController() {
        daoClass = UsuarioDAO.class;
        usuario = new Usuario();
    }

    public String login() {
        usuario.setSenha(EncryptUtil.encrypt(usuario.getSenha()));
        Usuario usuarioFind = factoryDAO.getInstance(daoClass).logIn(usuario);
        if (usuarioFind == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail ou senha inválidos", null));
            return null;
        } else {
            setUsuario(usuarioFind);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO, usuario);
            return Constants.URL_INDEX;
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return Constants.URL_LOGIN;
    }

    public String goHome() {
        return Constants.URL_INDEX;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
