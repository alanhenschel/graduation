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
import model.Produto;
import dao.Produto_Banco;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

public class TabelaProdutoController {

    @FXML
    private TableView<Produto> tableProduto;

    @FXML
    private TableColumn<Produto, Double> valor;

    @FXML
    private TableColumn<Produto, String> categoria;

    @FXML
    private TableColumn<Produto, String> titulo;

    @FXML
    private TableColumn<Produto, Integer> idproduto;

    @FXML
    private TableColumn<Produto, String> tipo;

    @FXML
    private TableColumn<Produto, String> estoque;

    @FXML
    private TableColumn<Produto, String> estudio;

    @FXML
    private TableColumn<Produto, Integer> idfornecedor;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtCategoria;

    @FXML
    private Button btnPesquisarNome;

    @FXML
    private Button btnPesquisarTipo;

    @FXML
    private Button btnPesquisarCategoria;
    
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
    	Produto produto = new Produto();
    	Produto_Banco produto_banco = new Produto_Banco();
    	produto_banco.remove(produto, txtNome.getText());

    }

    @FXML
    void btnExibirOnAction(ActionEvent event) throws SQLException {
    	Produto_Banco produto_banco = new Produto_Banco();
    	idproduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	titulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    	estudio.setCellValueFactory(new PropertyValueFactory<>("estudio"));
    	tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	estoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	idfornecedor.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	List<Produto> resultado = produto_banco.consulta();
    	tableProduto.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtNome.clear();
    	txtTipo.clear();
    	txtCategoria.clear();
    }

    @FXML
    void btnPesquisarCategoriaOnAction(ActionEvent event) throws SQLException {
    	Produto_Banco produto_banco = new Produto_Banco();
    	idproduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	titulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    	estudio.setCellValueFactory(new PropertyValueFactory<>("estudio"));
    	tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	estoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	idfornecedor.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	List<Produto> resultado = produto_banco.consultaCategoria(txtCategoria.getText());
    	tableProduto.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnPesquisarNomeOnAction(ActionEvent event) throws SQLException {
    	Produto_Banco produto_banco = new Produto_Banco();
    	idproduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	titulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    	estudio.setCellValueFactory(new PropertyValueFactory<>("estudio"));
    	tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	estoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	idfornecedor.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	List<Produto> resultado = produto_banco.consultaNome(txtNome.getText());
    	tableProduto.setItems(FXCollections.observableList(resultado));
    }

    @FXML
    void btnPesquisarTipoOnAction(ActionEvent event) throws SQLException {
    	Produto_Banco produto_banco = new Produto_Banco();
    	idproduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	titulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	categoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    	estudio.setCellValueFactory(new PropertyValueFactory<>("estudio"));
    	tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	estoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	idfornecedor.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	List<Produto> resultado = produto_banco.consultaTipo(txtTipo.getText());
    	tableProduto.setItems(FXCollections.observableList(resultado));
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