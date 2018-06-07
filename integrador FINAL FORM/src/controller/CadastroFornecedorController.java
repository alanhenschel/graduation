package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.*;
import model.Fornecedor;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import application.Main;
import dao.Fornecedor_Banco;
import javafx.collections.*;

public class CadastroFornecedorController {

    @FXML
    private TextField txtFornecedorNome;

    @FXML
    private TextField txtFornecedorBairro;

    @FXML
    private ComboBox<String> cbFornecedorPais;

    @FXML
    private TextField txtFornecedorEstado;

    @FXML
    private TextField txtCNPJ;

    @FXML
    private TextField txtFornecedorRua;

    @FXML
    private TextField txtFornecedorNumero;

    @FXML
    private TextField txtFornecedorCEP;

    @FXML
    private TextField txtFornecedorCidade;

    @FXML
    private Button btnFornecedorCadastrar;

    @FXML
    private Button btnFornecedorLimpar;

    @FXML
    private Button btnFornecedorSair;

    @FXML
    void btnFornecedorCadastrarOnAction(ActionEvent event) throws SQLException {
    	double d = Double.parseDouble(txtFornecedorNumero.getText());
    	int numero = (int) d;
    	Fornecedor fornecedor = new Fornecedor(txtFornecedorNome.getText(),txtCNPJ.getText(),txtFornecedorEstado.getText(),txtFornecedorRua.getText(),cbFornecedorPais.getValue(),txtFornecedorCidade.getText(),numero,txtFornecedorBairro.getText(),txtFornecedorCEP.getText());
    	
    	Fornecedor_Banco banco = new Fornecedor_Banco();
    	banco.inserir(fornecedor);
    }

    @FXML
    void btnFornecedorLimparOnAction(ActionEvent event) {
    	txtFornecedorNome.clear();
    	txtFornecedorBairro.clear();
    	txtCNPJ.clear();
    	txtFornecedorRua.clear();
    	txtFornecedorNumero.clear();
    	txtFornecedorCEP.clear();
    	txtFornecedorCidade.clear();
    }

    @FXML
    void btnFornecedorSairOnAction(ActionEvent event) {
    	
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    public void initialize() {
    	ObservableList<String> paises = FXCollections.observableArrayList();
   	 	String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                paises.add(obj.getDisplayCountry());
            }
        }
       cbFornecedorPais.setItems(paises);
    }


}
