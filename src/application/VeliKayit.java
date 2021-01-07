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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class VeliKayit {
	
	
	String sql="";
	
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	
	public VeliKayit() {
	   
		baglanti=sqlBaglanti.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAdi;

    @FXML
    private TextField txtsoyadi;

    @FXML
    private Button anasayfa;

    @FXML
    private Button kaydet;

    @FXML
    private Label lblsonuc;

    @FXML
    private TextField txtyakinligi;

    @FXML
    private ImageView imageviewKayit;

    @FXML
    private TextField txtposta;

    @FXML
    private TextField txttelefon;

    @FXML
    private TextField txttc;

    @FXML
    private TextField txtgelir;


    @FXML
    private TextField txtegitimdurumu;

    @FXML
    private TextArea txtareaisadresi;

    @FXML
    private TextArea txtareaevadresi;
   

   

    @FXML
    void btn_anasayfa(ActionEvent event) {
    	
    	try {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
			Scene scene= new Scene(pane);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }

    @FXML
    void btn_kaydet(ActionEvent event) {
    	
    	sql="insert into velikayit (Adi,Soyadi,Yakinligi,isAdresi,EvAdresi,PostaKodu,CepTelefonu,TcKimlikNo,"
    			+ "EgitimDurumu,GelirDuzeyi) values(?,?,?,?,?,?,?,?,?,?)";
    	
    	try {
			sorguifadesi=baglanti.prepareStatement(sql);
			
			sorguifadesi.setString(1, txtAdi.getText().trim());
			sorguifadesi.setString(2, txtsoyadi.getText().trim());
			sorguifadesi.setString(3, txtyakinligi.getText().trim());
			sorguifadesi.setString(4, txtareaisadresi.getText().trim());
			sorguifadesi.setString(5, txtareaevadresi.getText().trim());
			sorguifadesi.setInt(6, Integer.parseInt(txtposta.getText().trim()));
			sorguifadesi.setInt(7, Integer.parseInt(txttelefon.getText().trim()));
			sorguifadesi.setInt(8, Integer.parseInt(txttc.getText().trim()));
			sorguifadesi.setString(9, txtegitimdurumu.getText().trim());
			sorguifadesi.setInt(10, Integer.parseInt(txtgelir.getText().trim()));
			
			sorguifadesi.executeUpdate();
			lblsonuc.setText("Ekleme basarili");
			
			Temizle();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public void Temizle() {
    	txtAdi.setText("");
    	txtsoyadi.setText("");
    	txtyakinligi.setText("");
    	txtareaevadresi.setText("");
    	txtareaisadresi.setText("");
    	txtposta.setText("");
    	txttc.setText("");
    	txttelefon.setText("");
    	txtegitimdurumu.setText("");
    	txtgelir.setText("");
    	
    }

    @FXML
    void initialize() {
    


    }
}
