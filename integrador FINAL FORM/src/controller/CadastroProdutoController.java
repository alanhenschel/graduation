package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;
import dao.Produto_Banco;
import model.Produto;
import application.Main;
import javafx.collections.*;

public class CadastroProdutoController {

    @FXML
    private TextField txtTitulo;

    @FXML
    private ChoiceBox<String> cbTipo;

    @FXML
    private TextField txtValor;

    @FXML
    private TextField txtEstoque;

    @FXML
    private ChoiceBox<String> cbCategoria;

    @FXML
    private TextField txtEstudio;
    
    @FXML
    private TextField txtProdutoFornecedorId;

    @FXML
    private Button btnProdutoCadastrar;

    @FXML
    private Button btnProdutoLimpar;

    @FXML
    private Button btnProdutoSair;

    @FXML
    void btnProdutoCadastrarOnAction(ActionEvent event) throws SQLException  {
    	double valor = Double.parseDouble(txtValor.getText());
    	double e = Double.parseDouble(txtEstoque.getText());
    	int estoque = (int)e;
    	double f = Double.parseDouble(txtProdutoFornecedorId.getText());
    	int fornecedorId = (int)f;
    	Produto produto = new Produto(txtTitulo.getText(), valor, cbTipo.getValue(), txtEstudio.getText(), fornecedorId, cbCategoria.getValue(), estoque);
    	Produto_Banco banco = new Produto_Banco();
    	banco.inserir(produto);
    }
    
    public void initialize() {
    	ObservableList<String> tipo = FXCollections.observableArrayList("Manga","HQ","Seriado","Desenho","Filme","Jogo PS4","Jogo Nintendo Switch","Jogo Wii(U)","Jogo Xbox One","Outros");
    	ObservableList<String> categoria = FXCollections.observableArrayList("Acao","Aventura","Ficcao Cientifica","RPG","Casual","Terror","Drama","Romance","Comedia","Velho-Oeste","Medieval");
    	cbTipo.setItems(tipo);
    	cbCategoria.setItems(categoria);
    }

    @FXML
    void btnProdutoLimparOnAction(ActionEvent event) {
    	txtTitulo.clear();
    	txtValor.clear();
    	txtEstoque.clear();
    	txtEstudio.clear();
    	txtProdutoFornecedorId.clear();
    }

    @FXML
    void btnProdutoSairOnAction(ActionEvent event) {
    	
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}	

    }

}

