package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import application.Main;
import model.Funcionario;
import dao.Funcionario_Banco;
import javafx.collections.*;


public class CadastroFuncionarioController {

    @FXML
    private TextField txtFuncionarioNome;

    @FXML
    private TextField txtFuncionarioRG;

    @FXML
    private TextField txtFuncionarioBairro;

    @FXML
    private TextField txtFuncionarioEstado;

    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtSenha;

    @FXML
    private ChoiceBox<String> cbFuncionarioSexo;

    @FXML
    private TextField txtFuncionarioCPF;

    @FXML
    private TextField txtFuncionarioRua;

    @FXML
    private TextField txtFuncionarioNumero;

    @FXML
    private TextField txtFuncionarioCEP;

    @FXML
    private TextField txtFuncionarioCidade;

    @FXML
    private TextField txtSalario;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;


    @FXML
    void btnCadastrarOnAction(ActionEvent event) throws SQLException, ParseException {
    	double salario = Double.parseDouble(txtSalario.getText());
    	double n = Double.parseDouble(txtFuncionarioNumero.getText());
    	int numero = (int) n;
    	
    	Funcionario funcionario = new Funcionario(txtFuncionarioNome.getText(), txtFuncionarioRG.getText(), txtFuncionarioCPF.getText(), salario, cbFuncionarioSexo.getValue(), txtFuncionarioRua.getText(), txtFuncionarioCidade.getText(), numero, txtFuncionarioBairro.getText(),txtEmail.getText(), txtUsuario.getText(), txtSenha.getText());
    	
    	Funcionario_Banco banco = new Funcionario_Banco();
    	banco.inserir(funcionario);
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtFuncionarioNome.clear();
    	txtFuncionarioCPF.clear();
    	txtEmail.clear();
    	txtFuncionarioBairro.clear();
    	txtFuncionarioEstado.clear();
    	txtFuncionarioRG.clear();
    	txtFuncionarioRua.clear();
    	txtFuncionarioNumero.clear();
    	txtFuncionarioCEP.clear();
    	txtFuncionarioCidade.clear();
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
    
    public void initialize() {
    	ObservableList<String> sexo = FXCollections.observableArrayList("Masculino", "Feminino", "Outro");
    	cbFuncionarioSexo.setItems(sexo);
    }

}
