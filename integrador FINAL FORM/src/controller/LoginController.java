package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.*;
import dao.Iconst;
import javafx.application.Platform;
import java.sql.SQLException;

public class LoginController implements Iconst {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSair;

    @FXML
    void btnEntrarOnAction(ActionEvent event) throws SQLException{
    	/*Funcionario_Banco funcionario_banco = new Funcionario_Banco();
    	if(funcionario_banco.login(txtLogin.getText(), txtSenha.getText())) {
    		System.out.println("deu certo");
    	}
    	else {
    		System.out.println(""+txtSenha.getText());
    		System.out.println("n deu certo");
    	}*/
    }

    @FXML
    void btnSairOnAction(ActionEvent event) {
    	Platform.exit();
    }
    
    public void setUsuario(String usuario2) {
    	//Iconst.usuario=usuario2;
    }

}
