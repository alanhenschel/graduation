package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import model.Cliente;
import javafx.scene.layout.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import application.Main;
import dao.Cliente_Banco;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroClienteController {

    @FXML
    private TextField txtNome;

    @FXML
    private DatePicker txtCadastro;

    @FXML
    private TextField txtRG;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;

    @FXML
    void btnCadastrarOnAction(ActionEvent event) throws SQLException, ParseException {
    	Cliente cliente = new Cliente(txtRG.getText(),txtNome.getText(),txtEmail.getText());
    	cliente.setData(txtCadastro.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));	
    	Cliente_Banco banco = new Cliente_Banco();
    	banco.inserir(cliente);

    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtNome.clear();
    	txtCadastro.getEditor().clear();
    	txtEmail.clear();
    	txtRG.clear();
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
