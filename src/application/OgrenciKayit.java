package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OgrenciKayit {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAdi;

    @FXML
    private TextField txtpostakodu;

    @FXML
    private TextField txtsoyadi;

    @FXML
    private TextField txtsinifi;

    @FXML
    private TextArea textareaAdres;

    @FXML
    private TextField txtnumara;

    @FXML
    private Button anasayfa;

    @FXML
    private Button kaydet;

    @FXML
    private Label lblsonuc;

    @FXML
    private RadioButton rdbBayan;

    @FXML
    private RadioButton rdbErkek;

    @FXML
    private TextField txtbolumu;


    @FXML
    private TextField txtsehir;
    @FXML
    private TextField txtsemt;
 
    
    
   
    
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    String sql="";
    
    public OgrenciKayit() {
		
    	baglanti=sqlBaglanti.Baglan();
	}
    
    


    public void Temizle() {
    	txtAdi.setText("");
    	txtsoyadi.setText("");
    	txtsinifi.setText("");
    	txtbolumu.setText("");
    	textareaAdres.setText("");
    	txtpostakodu.setText("");
    	txtsemt.setText("");
    	txtsehir.setText("");
    	txtnumara.setText("");
    	rdbBayan.setSelected(false);
    	rdbErkek.setSelected(false);
    	
    	
    }

    @FXML
    void btn_anasayfa(ActionEvent event) {
    	Stage stage = null;
    	try {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
			Scene scene=new Scene(pane);
			 stage=new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setScene(scene);
			stage.showAndWait();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			lblsonuc.setText(e.getMessage().toString());
		}
   
    	

    }

    @FXML
    void btn_kaydet(ActionEvent event) {
    
    	
    	String cinsiyet="";
    	sql="insert into ogrencikayit(Adi,Soyadi,Sinifi,Bolumu,Cinsiyet,EvAdresi,PostaKodu,Semt,Sehir,Numara) values(?,?,?,?,?,?,?,?,?,?)";
    	
    	if(rdbBayan.isSelected()) {
    		cinsiyet=rdbBayan.getText();
    	}
    	if(rdbErkek.isSelected()) {
    		cinsiyet=rdbErkek.getText();
    	}
    	
    	try {
    		
			sorguifadesi=baglanti.prepareStatement(sql);
			sorguifadesi.setString(1, txtAdi.getText().trim());
			sorguifadesi.setString(2, txtsoyadi.getText().trim());
			sorguifadesi.setString(3, txtsinifi.getText().trim());
			sorguifadesi.setString(4, txtbolumu.getText().trim());
			sorguifadesi.setString(5, cinsiyet.trim().toLowerCase());
			sorguifadesi.setString(6, textareaAdres.getText().trim());
			sorguifadesi.setInt(7, Integer.valueOf(txtpostakodu.getText().trim()));
			sorguifadesi.setString(8, txtsemt.getText().trim());
			sorguifadesi.setString(9, txtsehir.getText().trim());
			sorguifadesi.setInt(10,Integer.valueOf( txtnumara.getText().trim()));
			sorguifadesi.executeUpdate();
			lblsonuc.setText("Basarli Bir Sekilde Eklendi");
			
			
			
			
			
			Temizle();
			
		} catch (SQLException e) {
			
			lblsonuc.setText(e.getMessage().toString());
		}

    }

    @FXML
    void initialize() {
    	ToggleGroup toggleGroup=new ToggleGroup();
    	rdbBayan.setToggleGroup(toggleGroup);
    	rdbErkek.setToggleGroup(toggleGroup);
    	
    	
       

    }
}
