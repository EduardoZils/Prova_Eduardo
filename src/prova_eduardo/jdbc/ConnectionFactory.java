/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_eduardo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduar
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            //jdbc do postgres/endereço/ porta/ database
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/viagemdb",
                    "postgres","root");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar uma "
                    + "conexão com o banco de dados "+
                    ex.getMessage());
        }
        return null;
    }   
}
