package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import application.Main;
import java.io.IOException;
import javafx.event.*;
import javafx.scene.layout.*;
import java.sql.SQLException;
import dao.Cliente_Banco;
import model.Cliente;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.cell.*;

public class TabelaClienteController {

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, Integer> id;

    @FXML
    private TableColumn<Cliente, String> nome;

    @FXML
    private TableColumn<Cliente, String> rg;

    @FXML
    private TableColumn<Cliente, String> email;

    @FXML
    private TableColumn<Cliente, String> data;

    @FXML
    private TextField txtPesquisarClienteRG;

    @FXML
    private TextField txtPesquisarClienteNome;

    @FXML
    private Button btnPesquisar;
    
    @FXML
    private Button btnPesquisar1;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnExibir;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;
    
    private Cliente cliente = new Cliente();
    
    @FXML
    void btnExcluirOnAction(ActionEvent event) throws SQLException {
    	cliente_banco = new Cliente_Banco();
    	cliente_banco.remove(cliente, txtPesquisarClienteRG.getText());
    }
    
    @FXML
    void btnExibirOnAction(ActionEvent event) throws SQLException{
    	cliente_banco = new Cliente_Banco();
    	id.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("rg"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	data.setCellValueFactory(new PropertyValueFactory<>("data"));
    	List<Cliente> resultado = cliente_banco.consulta();
    	tableCliente.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtPesquisarClienteRG.clear();
    	txtPesquisarClienteNome.clear();
    }

    @FXML
    void btnPesquisarOnAction(ActionEvent event) throws SQLException {
    	cliente_banco = new Cliente_Banco();
    	id.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("rg"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	data.setCellValueFactory(new PropertyValueFactory<>("data"));
    	List<Cliente> resultado = cliente_banco.consultaNome(txtPesquisarClienteNome.getText());
    	tableCliente.setItems(FXCollections.observableList(resultado));
    }
    
    @FXML
    void btnPesquisar1OnAction(ActionEvent event) throws SQLException {
    	cliente_banco = new Cliente_Banco();
    	id.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	rg.setCellValueFactory(new PropertyValueFactory<>("rg"));
    	email.setCellValueFactory(new PropertyValueFactory<>("email"));
    	data.setCellValueFactory(new PropertyValueFactory<>("data"));
    	List<Cliente> resultado = cliente_banco.consultaRg(txtPesquisarClienteRG.getText());
    	tableCliente.setItems(FXCollections.observableList(resultado));
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
    
    private Cliente_Banco cliente_banco;


}

