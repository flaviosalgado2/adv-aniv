/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class SQLiteJBDC {

    Connection conn = null;
    
    public static Connection conexaodb(){     
        

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
            
            System.out.println("sucesso!!");
            //JOptionPane.showMessageDialog(null, "sucesso");
            return conn;
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
            //System.out.println(e);
            return null;
        }
    }
}
