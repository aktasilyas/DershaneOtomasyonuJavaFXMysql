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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonelEkle {
	
	String sorgu="";
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	
	public PersonelEkle() {
		
		baglanti=sqlBaglanti.Baglan();
	}

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
    private TextField gorevi;

    @FXML
    private TextArea textareaAdres;

    @FXML
    private TextField maas;

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
    private TextField txtsehir;

    @FXML
    private TextField txtsemt;

    @FXML
    private ImageView imageviewKayit;
    @FXML
    private AnchorPane panePersonelEkle;
    @FXML
    void btn_anasayfa(ActionEvent event) {
    	
    	try {
			AnchorPane	pane = (AnchorPane)FXMLLoader.load(getClass().getResource("AnaSayfa.fxml"));
			Scene scene=new Scene(pane);
	    	  Stage stage=new Stage();
	    	  stage.initModality(Modality.APPLICATION_MODAL);
	    	  stage.initStyle(StageStyle.UTILITY);
	    	  stage.setScene(scene);
	    	  stage.showAndWait();
	    	  panePersonelEkle.getScene().getWindow().hide();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void btn_kaydet(ActionEvent event) {
    	sorgu="insert into personelkayit (Adi,Soyadi,Cinsiyet,EvAdresi,Semt,Sehir,maas,gorevi,postakodu) values(?,?,?,?,?,?,?,?,?)";
    	
    	String seciliCinsiyet="";
    	if (rdbBayan.isSelected()) {
			seciliCinsiyet=rdbBayan.getText();
		}
    	if (rdbErkek.isSelected()) {
			seciliCinsiyet=rdbErkek.getText();
		}
    	
    	try {
			sorguifadesi=baglanti.prepareStatement(sorgu);
			
			sorguifadesi.setString(1, txtAdi.getText().trim());
			sorguifadesi.setString(2, txtsoyadi.getText().trim());
			sorguifadesi.setString(3,seciliCinsiyet);
			sorguifadesi.setString(4, textareaAdres.getText().trim());
			sorguifadesi.setString(5, txtsemt.getText().trim());
			sorguifadesi.setString(6, txtsehir.getText().trim());
			sorguifadesi.setInt(7, Integer.parseInt(maas.getText().trim()));
			sorguifadesi.setString(8, gorevi.getText().trim());
			sorguifadesi.setInt(9, Integer.parseInt(txtpostakodu.getText().trim()));
			
			sorguifadesi.executeUpdate();
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.setContentText("Ekleme basarili");
			alert.showAndWait();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void initialize() {
    	ToggleGroup toggleGroup=new ToggleGroup();
    	rdbBayan.setToggleGroup(toggleGroup);
    	rdbErkek.setToggleGroup(toggleGroup);
       
    }
}
