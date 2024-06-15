/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Produtos;

/**
 *
 * @author jvna0
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    private conectaDAO conexao;
    private Connection conn;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public ProdutosDAO(){
        this.conexao = new conectaDAO();
        this.conn = conexao.connectDB();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = ("INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)");
        try{
            PreparedStatement prep = this.conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.execute();
        }catch(Exception e){
            System.out.println("Erro ao inserir produto:\n" + e.getMessage());
        }
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        String sql = ("SELECT * FROM produtos");
        try{
            PreparedStatement prep = this.conn.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                ProdutosDTO produtos = new ProdutosDTO();
                produtos.setId(rs.getInt("id"));
                produtos.setNome(rs.getString("nome"));
                produtos.setValor(rs.getInt("valor"));
                produtos.setStatus(rs.getString("status"));
                listagem.add(produtos);
            }
        return listagem;
        
        }catch(Exception e){
            return null;
        }
    }
    
    
    
        
}


