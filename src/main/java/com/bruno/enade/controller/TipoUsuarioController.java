/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.controller;

import com.bruno.enade.dao.FactoryDAO;
import com.bruno.enade.dao.TipoUsuarioDAO;
import com.bruno.enade.model.TipoUsuario;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author bruno
 */
@Named
@ViewScoped
public class TipoUsuarioController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private Class<TipoUsuarioDAO> daoClass;

    TipoUsuario tipoUsuario = new TipoUsuario();
    List<TipoUsuario> tipoUsuarios = new ArrayList<>();

    public TipoUsuarioController() {
        tipoUsuarios = factoryDAO.getInstance(daoClass).findAll();
        tipoUsuario = new TipoUsuario();
    }

    public void gravar(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).merge(tipoUsuario);
        tipoUsuarios = factoryDAO.getInstance(daoClass).findAll();
        tipoUsuario = new TipoUsuario();
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(tipoUsuario.getIdTipoUsuario());
        tipoUsuarios = factoryDAO.getInstance(daoClass).findAll();
        tipoUsuario = new TipoUsuario();
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

}
