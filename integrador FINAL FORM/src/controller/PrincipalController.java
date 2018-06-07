package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;
import java.io.IOException;
import application.Main;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;

public class PrincipalController {

    @FXML
    private MenuBar mbMenu;

    @FXML
    private Menu menuVenda;
    
    @FXML
    private MenuItem menuRealizarVenda;

    @FXML
    private Menu menuClientes;

    @FXML
    private MenuItem menuClientesCadastrar;

    @FXML
    private MenuItem menuClientesEditar;

    @FXML
    private MenuItem menuClientesAlterar;

    @FXML
    private Menu menuProdutos;

    @FXML
    private MenuItem menuProdutosCadastrar;

    @FXML
    private MenuItem menuProdutosEditar;
    
    @FXML
    private MenuItem menuProdutosAlterar;

    @FXML
    private Menu menuFornecedores;

    @FXML
    private MenuItem menuFornecedoresCadastrar;

    @FXML
    private MenuItem menuFornecedoresEditar;

    @FXML
    private MenuItem menuFornecedoresAlterar;

    @FXML
    private Menu menuVendedores;

    @FXML
    private MenuItem menuVendedoresCadastrar;

    @FXML
    private MenuItem menuVendedoresEditar;

    @FXML
    private MenuItem menuVendedoresAlterar;

    @FXML
    private Menu menuRegistros;

    @FXML
    private Menu menuSair;

    @FXML
    private MenuItem menuSairS;
    
    @FXML
    void menuClientesAlterarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/MudarCliente.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void menuClientesCadastrarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/CadastroCliente.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuClientesEditarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/EditarCliente.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void menuFornecedoresAlterarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/MudarFornecedor.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuFornecedoresCadastrarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/CadastroFornecedor.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuFornecedoresEditarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/EditarFornecedor.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void menuProdutosAlterarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/MudarProduto.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuProdutosCadastrarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/CadastroProduto.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuProdutosEditarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/EditarProduto.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuSairOnAction(ActionEvent event) {

    }
    
    @FXML
    void menuSairSOnAction(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void menuRealizarVendaOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/Venda.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void menuVendedoresAlterarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/MudarFuncionario.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuVendedoresCadastrarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/CadastroFuncionario.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void menuVendedoresEditarOnAction(ActionEvent event) {
    	try {
			BorderPane bpane = FXMLLoader.load(getClass().getResource("/view/EditarFuncionario.fxml"));
			BorderPane border = Main.getRoot();
			border.setCenter(bpane);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}


    



