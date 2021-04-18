/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.dao;

import com.bruno.enade.model.Questao;

/**
 *
 * @author bruno
 */
public class QuestaoDAO extends GenericDAO<Questao, Integer> {

    public QuestaoDAO() {
        super(Questao.class);
    }

}
