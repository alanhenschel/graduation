package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conect implements Iconst {
   public static Connection getConect(String stringConect, String usuario, String senha) {
    try {
	  return DriverManager.getConnection(stringConect, usuario, senha);
    } catch (SQLException e) {		
        throw new RuntimeException(e);
      } 
  }
}