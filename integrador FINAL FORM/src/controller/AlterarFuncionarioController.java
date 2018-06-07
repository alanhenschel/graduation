package controller;

import java.io.IOException;
import java.sql.SQLException;
import application.Main;
import dao.Funcionario_Banco;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Funcionario;
import javafx.event.*;

public class AlterarFuncionarioController {

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtSalario;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;

    @FXML
    void btnAlterarOnAction(ActionEvent event) throws SQLException {
	    	double id = Double.parseDouble(txtNome.getText());
	    	int funcionarioid = (int)id;
	    	double salario = Double.parseDouble(txtSalario.getText());
	    	double n = Double.parseDouble(txtNumero.getText());
	    	int numero = (int)n;
	    	Funcionario_Banco funcionario_banco = new Funcionario_Banco();
	    	Funcionario funcionario = new Funcionario();
	    	funcionario_banco.update(funcionario, txtRua.getText(), salario, txtCidade.getText(), txtBairro.getText(), numero, funcionarioid);
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtEmail.clear();
    	txtBairro.clear();
    	txtRua.clear();
    	txtNumero.clear();
    	txtCEP.clear();
    	txtCidade.clear();
    	txtSalario.clear();
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

}
