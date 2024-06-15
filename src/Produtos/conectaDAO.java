/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jvna0
 */
public class conectaDAO {
    
    public Connection connectDB(){
        
        try {
        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11Produtos", "root", "jvna160507");
            return conn;
            
        } catch (Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        return null;
        }
        
    }
    
}
