package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.sql.SQLException;

import application.Main;
import javafx.event.*;
import dao.Produto_Banco;
import model.Produto;

public class AlterarProdutoController {

    @FXML
    private TextField txtProdutoId;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtEstoque;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;

    @FXML
    void btnAlterarOnAction(ActionEvent event) throws SQLException {
    	double id = Double.parseDouble(txtProdutoId.getText());
    	int produtoid = (int)id;
    	double valor = Double.parseDouble(txtValor.getText());
    	double e = Double.parseDouble(txtEstoque.getText());
    	int estoque = (int)e;
    	Produto_Banco produto_banco = new Produto_Banco();
    	Produto produto = new Produto(valor, estoque);
    	
    	
    	produto_banco.update(produto,produtoid);
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtProdutoId.clear();
    	txtValor.clear();
    	txtEstoque.clear();
    }

    @FXML
    void btnSairOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
			BorderPane border = Main.getRoot();
			border.setTop(bpane);
			System.out.println(border.getCenter().getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
