/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.controller;

import com.bruno.enade.dao.FactoryDAO;
import com.bruno.enade.dao.ProvaDAO;
import com.bruno.enade.model.Prova;
import com.bruno.enade.model.Usuario;
import com.bruno.enade.util.Constants;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno
 */
@Named
@SessionScoped
public class RealizarProvaController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private final Class<ProvaDAO> daoClass;

    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    Prova prova = new Prova();

    public RealizarProvaController() {
        daoClass = ProvaDAO.class;
        prova = factoryDAO.getInstance(daoClass).findUltimaProvaAtiva(getIdUsuarioLogado());
    }

    public void gravar(ActionEvent actionEvent) {
//        factoryDAO.getInstance(daoClass).merge(prova);
        prova = factoryDAO.getInstance(daoClass).findUltimaProvaAtiva(getIdUsuarioLogado());
    }

    private Integer getIdUsuarioLogado() {
        Usuario usuarioLogado = (Usuario) session.getAttribute(Constants.HTTP_SESSION_ATRIBUTE_LOGADO);
        return usuarioLogado.getIdUsuario();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

}
