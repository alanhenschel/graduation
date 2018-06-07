package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.FXCollections;
import javafx.event.*;
import model.Funcionario;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import application.Main;
import dao.Funcionario_Banco;

public class TabelaFuncionarioController {

    @FXML
    private TableView<Funcionario> tableFuncionario;

    @FXML
    private TableColumn<Funcionario, Integer> codigo;

    @FXML
    private TableColumn<Funcionario, String> nome;

    @FXML
    private TableColumn<Funcionario, Double> salario;

    @FXML
    private TableColumn<Funcionario, String> sexo;

    @FXML
    private TableColumn<Funcionario, String> rg;

    @FXML
    private TableColumn<Funcionario, String> cpf;

    @FXML
    private TableColumn<Funcionario, String> email;

    @FXML
    private TableColumn<Funcionario, String> rua;

    @FXML
    private TableColumn<Funcionario, String> numero;

    @FXML
    private TableColumn<Funcionario, String> bairro;

    @FXML
    private TableColumn<Funcionario, String> cidade;
    
    @FXML
    private TableColumn<Funcionario, String> usuario;

    @FXML
    private TableColumn<Funcionario, String> senha;

    @FXML
    private TextField txtPesquisarFuncionarioRG;

    @FXML
    private TextField txtPesquisarFuncionarioCPF;

    @FXML
    private TextField txtPesquisarFuncionarioNome;

    @FXML
    private Button btnPesquisarRg;

    @FXML
    private Button btnPesquisarCpf;

    @FXML
    private Button btnPesquisarNome;

    @FXML
    private Button btnExibir;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;

    @FXML
    void btnExcluirOnAction(ActionEvent event) throws SQLException{
    	Funcionario funcionario = new Funcionario();
    	Funcionario_Banco funcionario_banco = new Funcionario_Banco();
    	funcionario_banco.removeRG(funcionario, txtPesquisarFuncionarioRG.getText());
    }
    
    @FXML
    void btnExibirOnAction(ActionEvent event) throws SQLException {
    	Funcionario_Banco funcionario_banco = new Funcionario_Banco();
    	codigo.setCellValueFactory(new PropertyValueFactory<>("funcionarioId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    	sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("RG"));
    	cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
    	senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
    	List<Funcionario> resultado = funcionario_banco.consulta();
    	tableFuncionario.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtPesquisarFuncionarioRG.clear();
    	txtPesquisarFuncionarioCPF.clear();
    	txtPesquisarFuncionarioNome.clear();
    }

    @FXML
    void btnPesquisarCpfOnAction(ActionEvent event) throws SQLException {
    	Funcionario_Banco funcionario_banco = new Funcionario_Banco();
    	codigo.setCellValueFactory(new PropertyValueFactory<>("funcionarioId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    	sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("RG"));
    	cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
    	senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
    	List<Funcionario> resultado = funcionario_banco.consultaCpf(txtPesquisarFuncionarioCPF.getText());
    	tableFuncionario.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnPesquisarNomeOnAction(ActionEvent event) throws SQLException {
    	Funcionario_Banco funcionario_banco = new Funcionario_Banco();
    	codigo.setCellValueFactory(new PropertyValueFactory<>("funcionarioId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    	sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("RG"));
    	cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
    	senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
    	List<Funcionario> resultado = funcionario_banco.consultaNome(txtPesquisarFuncionarioNome.getText());
    	tableFuncionario.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnPesquisarRgOnAction(ActionEvent event) throws SQLException {
    	Funcionario_Banco funcionario_banco = new Funcionario_Banco();
    	codigo.setCellValueFactory(new PropertyValueFactory<>("funcionarioId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
    	sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("RG"));
    	cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
    	senha.setCellValueFactory(new PropertyValueFactory<>("senha"));
    	List<Funcionario> resultado = funcionario_banco.consultaRg(txtPesquisarFuncionarioRG.getText());
    	tableFuncionario.setItems(FXCollections.observableList(resultado));
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
