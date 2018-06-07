package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import application.Main;
import dao.Fornecedor_Banco;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import model.Fornecedor;
import javafx.event.*;

public class AlterarFornecedorController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtBairro;

    @FXML
    private ComboBox<String> cbPais;

    @FXML
    private TextField txtEstado;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtRua;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtCEP;

    @FXML
    private TextField txtCidade;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSair;

    @FXML
    void btnAlterarOnAction(ActionEvent event) throws SQLException  {
    	double id = Double.parseDouble(txtCodigo.getText());
    	int fornecedorid = (int)id;
    	Fornecedor_Banco fornecedor_banco = new Fornecedor_Banco();
    	double d = Double.parseDouble(txtNumero.getText());
    	int numero = (int) d;
    	Fornecedor fornecedor = new Fornecedor(txtNome.getText(),txtEstado.getText(),txtRua.getText(),cbPais.getValue(),txtCidade.getText(),numero,txtBairro.getText(),txtCEP.getText());
    	
    	fornecedor_banco.update(fornecedor,fornecedorid);
    }

    @FXML
    void btnLimparOnAction(ActionEvent event) {
    	txtNome.clear();
    	txtBairro.clear();
    	txtCodigo.clear();
    	txtRua.clear();
    	txtNumero.clear();
    	txtCEP.clear();
    	txtCidade.clear();
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
    	ObservableList<String> paises = FXCollections.observableArrayList();
   	 	String[] locales1 = Locale.getISOCountries();
        for (String countrylist : locales1) {
            Locale obj = new Locale("", countrylist);
            String[] city = { obj.getDisplayCountry() };
            for (int x = 0; x < city.length; x++) {
                paises.add(obj.getDisplayCountry());
            }
        }
       cbPais.setItems(paises);
    }

}
