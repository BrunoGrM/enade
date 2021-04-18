/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.controller;

import com.bruno.enade.dao.FactoryDAO;
import com.bruno.enade.dao.ProvaDAO;
import com.bruno.enade.model.Prova;
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
public class ProvaController implements Serializable {

    private final FactoryDAO factoryDAO = new FactoryDAO();
    private Class<ProvaDAO> daoClass;

    Prova prova = new Prova();
    List<Prova> provas = new ArrayList<>();

    public ProvaController() {
        provas = factoryDAO.getInstance(daoClass).findAll();
        prova = new Prova();
    }

    public void gravar(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).merge(prova);
        provas = factoryDAO.getInstance(daoClass).findAll();
        prova = new Prova();
    }

    public void remover(ActionEvent actionEvent) {
        factoryDAO.getInstance(daoClass).remove(prova.getIdProva());
        provas = factoryDAO.getInstance(daoClass).findAll();
        prova = new Prova();
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }

}
