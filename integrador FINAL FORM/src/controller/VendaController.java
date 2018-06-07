package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.sql.SQLException;
import application.Main;
import javafx.event.*;
import model.ItemVenda;
import model.Venda;
import dao.Produto_Banco;
import dao.Venda_Banco;

public class VendaController {


    @FXML
    private TextField txtVenda;

    @FXML
    private TextField txtProdutoId;

    @FXML
    private TextField txtVendaCliente;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtVendedor;

    @FXML
    private Label lblValor;

    @FXML
    private Button btnVenda;

    @FXML
    private Button btnInserirProduto;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;
    
    @FXML
    void btnFecharOnAction(ActionEvent event) {
    	txtVendedor.setEditable(true);
    	txtVendaCliente.setEditable(true);
    	txtVenda.setEditable(true);
    	lblValor.setText(""+valorFinal);
    }
    
    private double valorFinal=0;

    @FXML
    void btnInserirProdutoOnAction(ActionEvent event) throws SQLException{
    	txtVenda.setEditable(false);
    	double qt = Double.parseDouble(txtQuantidade.getText());
    	int quantidade = (int) qt;
    	double idv = Double.parseDouble(txtVenda.getText());
    	int idvenda = (int) idv;
    	double p = Double.parseDouble(txtProdutoId.getText());
    	int idproduto = (int) p;
    	Venda_Banco venda_banco = new Venda_Banco();
    	ItemVenda itemvenda = new ItemVenda(idvenda, idproduto, quantidade);
    	venda_banco.inserirItemVenda(itemvenda);
    	Produto_Banco produto_banco = new Produto_Banco();
    	valorFinal=valorFinal + produto_banco.somaValor(idproduto) * quantidade;
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtProdutoId.clear();
    	txtVendaCliente.clear();
    	txtQuantidade.clear();
    	txtVendedor.clear();
    }

    @FXML
    void btnSairOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void btnVendaOnAction(ActionEvent event) throws SQLException {
    	double idv = Double.parseDouble(txtVenda.getText());
    	int idvenda = (int) idv;
    	double f = Double.parseDouble(txtVendedor.getText());
    	int idfuncionario = (int) f;
    	double c = Double.parseDouble(txtVendaCliente.getText());
    	int idcliente = (int) c;
    	Venda_Banco venda_banco = new Venda_Banco();
    	Venda venda = new Venda(idvenda,idfuncionario,idcliente);
    	venda_banco.inserirVenda(venda);
    	txtVendedor.setEditable(false);
    	txtVendaCliente.setEditable(false);
    	txtVenda.setEditable(false);
    }

}
