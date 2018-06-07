package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import model.Fornecedor;
import dao.Fornecedor_Banco;

public class TabelaFornecedorController {

    @FXML
    private TableView<Fornecedor> tableFornecedor;

    @FXML
    private TableColumn<Fornecedor, Integer> id;

    @FXML
    private TableColumn<Fornecedor, String> nome;

    @FXML
    private TableColumn<Fornecedor, String> cnpj;

    @FXML
    private TableColumn<Fornecedor, String> rua;

    @FXML
    private TableColumn<Fornecedor, String> bairro;

    @FXML
    private TableColumn<Fornecedor, Integer> numero;

    @FXML
    private TableColumn<Fornecedor, String> cep;

    @FXML
    private TableColumn<Fornecedor, String> pais;
    
    @FXML
    private TableColumn<Fornecedor, String> cidade;

    @FXML
    private TextField txtPesquisarFornecedorNome;

    @FXML
    private TextField txtPesquisarFornecedorCNPJ;

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
    
    @FXML
    void btnExcluirOnAction(ActionEvent event) throws SQLException {
    	Fornecedor fornecedor = new Fornecedor();
    	Fornecedor_Banco fornecedor_banco = new Fornecedor_Banco();
    	fornecedor_banco.remove(fornecedor, txtPesquisarFornecedorCNPJ.getText());
    }

    @FXML
    void btnExibir(ActionEvent event) throws SQLException {
    	Fornecedor_Banco fornecedor_banco = new Fornecedor_Banco();
    	id.setCellValueFactory(new PropertyValueFactory<>("fornecedorId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	cnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
    	pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	List<Fornecedor> resultado = fornecedor_banco.consulta();
    	tableFornecedor.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtPesquisarFornecedorNome.clear();
    	txtPesquisarFornecedorCNPJ.clear();
    }

    @FXML
    void btnPesquisarOnAction(ActionEvent event) throws SQLException {
    	Fornecedor_Banco fornecedor_banco = new Fornecedor_Banco();
    	id.setCellValueFactory(new PropertyValueFactory<>("fornecedorId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	cnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
    	pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	List<Fornecedor> resultado = fornecedor_banco.consultaNome(txtPesquisarFornecedorNome.getText());
    	tableFornecedor.setItems(FXCollections.observableList(resultado));
    }
    
    @FXML
    void btnPesquisar1OnAction(ActionEvent event) throws SQLException {
    	Fornecedor_Banco fornecedor_banco = new Fornecedor_Banco();
    	id.setCellValueFactory(new PropertyValueFactory<>("fornecedorId"));
    	nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	cnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
    	rua.setCellValueFactory(new PropertyValueFactory<>("rua"));
    	bairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
    	numero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	cep.setCellValueFactory(new PropertyValueFactory<>("cep"));
    	pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
    	cidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
    	List<Fornecedor> resultado = fornecedor_banco.consultaCNPJ(txtPesquisarFornecedorCNPJ.getText());
    	tableFornecedor.setItems(FXCollections.observableList(resultado));
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
