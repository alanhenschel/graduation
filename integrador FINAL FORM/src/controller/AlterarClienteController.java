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
import dao.Cliente_Banco;
import model.Cliente;

public class AlterarClienteController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;

    @FXML
    void btnAlterarOnAction(ActionEvent event) throws SQLException {
    	double id = Double.parseDouble(txtCodigo.getText());
    	int clienteid = (int)id;
    	Cliente_Banco cliente_banco = new Cliente_Banco();
    	Cliente cliente = new Cliente(txtEmail.getText());
    	
    	cliente_banco.update(cliente,clienteid);
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtCodigo.clear();
    	txtEmail.clear();
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