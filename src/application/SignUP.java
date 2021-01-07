package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class SignUP {
	
	String sorgu="";
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	
	public SignUP() {
		
		baglanti=sqlBaglanti.Baglan();
	}
	
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView paneUyeol;

    @FXML
    private TextField txtadý;

    @FXML
    private PasswordField txtsifre;

    @FXML
    private PasswordField txtsifretekrar;

    @FXML
    void btnuyeol(ActionEvent event) {
    	
    	sorgu="insert into loging (Adi,Sifre) values(?,?)";
    	
    	
    	String hataString="";
    	
    	if (!(txtsifre.getText().equals(txtsifretekrar.getText())&&txtsifre.getText().length()==txtsifretekrar.getText().length())) {
    		
    		hataString="Þifreler ayný olmalý";
			
		}
    	if (hataString.length()==0) {
    		try {
    			sorguifadesi=baglanti.prepareStatement(sorgu);
    			
    			sorguifadesi.setString(1, txtadý.getText().trim());
    			sorguifadesi.setString(2, txtsifre.getText().trim());
    			
    			sorguifadesi.executeUpdate();
    			Alert alert=new Alert(AlertType.CONFIRMATION);
    			alert.setContentText("Uye Basarili");
    			alert.showAndWait();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			
		}
    	else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setContentText(hataString);
			alert.showAndWait();
		}
    	

    }

    @FXML
    void initialize() {
       

    }
}
