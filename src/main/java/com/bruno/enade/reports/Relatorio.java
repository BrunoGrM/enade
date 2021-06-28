/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruno.enade.reports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author bruno
 */
public class Relatorio {

    private final String BASE_URL = "E:/Faculdade/9º período/Laboratório de Programação de Web Sites Dinâmicos/Enade/src/main/java/com/bruno/enade/reports/";
    private Connection con;

    public Relatorio() {
    }

    public void getRelatorio(String relatorio) {
//        Map<String, Object> params = new HashMap<>();
//        try {
//            String jrxmlFileName = BASE_URL + relatorio + ".jrxml";
//            String jasperFileName = BASE_URL + relatorio + ".jasper";
//            String pdfFileName = BASE_URL + relatorio + "/report.pdf";
//
//            JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
//            JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, params, getConexao());
//            JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
//
//            fecharConexao();
//        } catch (JRException e) {
//            Logger.getLogger(e.getMessage());
//        }

        JasperReport jasperReport = null;
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint;

        try {
            jasperReport = JasperCompileManager.compileReport(BASE_URL + relatorio + ".jrxml");

            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, getConexao());

            JasperExportManager.exportReportToPdfFile(jasperPrint, BASE_URL + relatorio + ".pdf");
        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enade?autoReconnect=true&useSSL=false", "root", "root");
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getLogger(e.getMessage());
        }
        return con;
    }

    public void fecharConexao() {
        try {
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(e.getMessage());
        }
    }

}
