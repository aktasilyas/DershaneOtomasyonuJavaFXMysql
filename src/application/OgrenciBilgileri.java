package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OgrenciBilgileri {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Kayitlar> table_view;
    
    @FXML
    private TableColumn<Kayitlar, Integer> K_id;

    @FXML
    private TableColumn<Kayitlar, String> K_Adi;

    @FXML
    private TableColumn<Kayitlar, String> K_Soyadi;

    @FXML
    private TableColumn<Kayitlar, String> K_sinifi;

    @FXML
    private TableColumn<Kayitlar, String> K_Bolumu;

    @FXML
    private TableColumn<Kayitlar, String> K_Cinsiyet;

    @FXML
    private TableColumn<Kayitlar, String> K_Ev_Adresi;

    @FXML
    private TableColumn<Kayitlar, Integer> K_Posta_Kodu;
    
    @FXML
    private TableColumn<Kayitlar, String> K_Semt;

    @FXML
    private TableColumn<Kayitlar, String> K_Sehir;

    @FXML
    private TableColumn<Kayitlar, Integer> K_Numara;
 

    @FXML
    private TextField txtAdi;

    @FXML
    private TextField txtsoyadi;

    @FXML
    private TextField txtsinifi;

    @FXML
    private TextField txtsehir;
    
    @FXML
    private TextField txtbolumu;

    @FXML
    private RadioButton rdbBayan;

    @FXML
    private RadioButton rdbErkek;

    @FXML
    private TextField txtpostakodu;

    @FXML
    private TextField txtsemt;

    @FXML
    private TextArea textareaAdres;

    @FXML
    private TextField txtnumara;

    @FXML
    private Button KayitSil;

    @FXML
    private Button Guncelle;
    

    @FXML
    private Button Ara;

    @FXML
    private TextField txt_Ara_Sil;
    @FXML
    private TextField txtsil;

    @FXML
    private Label lblAnasayfa;
    
    @FXML
    private Label lblsonuc;
    @FXML
    private Label lblbilgi;
    

    @FXML
    private Label lblcýkýsyap;
    
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet result=null;
    String sql="";
    
   public OgrenciBilgileri(){
    	baglanti=sqlBaglanti.Baglan();
    }

    @FXML
    void btn_guncelle(ActionEvent event) {
    	
   sql="update ogrencikayit set Adi=?,Soyadi=?,Sinifi=?,Bolumu=?,Cinsiyet=?,EvAdresi=?,PostaKodu=?,Semt=?,Sehir=?,Numara=?  where id=? ";
   String cinsiyet="";
   if(rdbBayan.isSelected()) {
		cinsiyet=rdbBayan.getText();
	}
	if(rdbErkek.isSelected()) {
		cinsiyet=rdbErkek.getText();
	}
	
	Kayitlar kayitlar=new Kayitlar();
	kayitlar=table_view.getItems().get(table_view.getSelectionModel().getSelectedIndex());
	int GelenId=kayitlar.getId();
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
		sorguifadesi.setInt(10, Integer.valueOf(txtnumara.getText().trim()));
		sorguifadesi.setInt(11, Integer.valueOf(GelenId));
		
		
		sorguifadesi.executeUpdate();
		bilgileriGetir(table_view);
		lblsonuc.setText("Basarili Bir Sekilde Guncellendi");
		Temizle();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		lblsonuc.setText(e.getMessage().toString());
	}
       
     
          
   
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
    void btn_kayitsil(ActionEvent event) {

    	sql="delete from ogrencikayit where id=?";
    	
    	Kayitlar kayitlar=new Kayitlar();
    	kayitlar=table_view.getItems().get(table_view.getSelectionModel().getSelectedIndex());
    	int GelenId=kayitlar.getId();    	
  	try {
			sorguifadesi=baglanti.prepareStatement(sql);
		
			sorguifadesi.setInt(1,GelenId);
			
			sorguifadesi.executeUpdate();
			bilgileriGetir(table_view);
			lblsonuc.setText("Basarili bir sekilde silindi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			lblsonuc.setText(e.getMessage().toString());
		}
    	
    	Temizle();
    }

    @FXML
    void lbl_Anasayfadon(MouseEvent event) {
    	try {
			AnchorPane pane=FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
			
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Stage stage=new Stage();
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
    void lbl_Cikisyap(MouseEvent event) {
       System.exit(0);
    }
    
    @FXML
    void Table_view_clicked(MouseEvent event) {
    	  Kayitlar kayitlar=new Kayitlar();
    	if(table_view.getSelectionModel().getSelectedIndex()!=-1) {
    	kayitlar=	table_view.getItems().get(table_view.getSelectionModel().getSelectedIndex());
    	txtAdi.setText(kayitlar.getAdi());
    	txtsoyadi.setText(kayitlar.getSoyadi());
    	txtsinifi.setText(kayitlar.getSinifi());
    	txtbolumu.setText(kayitlar.getBolumu());
    	if(kayitlar.getCinsiyet().equals("Bayan".toLowerCase())||kayitlar.getCinsiyet().equals("kiz".toLowerCase())) {
    		rdbBayan.setSelected(true);
    		
    	}
    	if(kayitlar.getCinsiyet().equals("Erkek".toLowerCase())) {
    		
    		rdbErkek.setSelected(true);
    		
    	}
    		
    	textareaAdres.setText(kayitlar.getEvadresi());
    	txtpostakodu.setText(String.valueOf(kayitlar.getPostakodu()));
    	txtsemt.setText(kayitlar.getSemt());
    	txtsehir.setText(kayitlar.getSehir());
    	txtnumara.setText(String.valueOf(kayitlar.getNumara()));
    	
    	
    	
    		
    	}
    	

    }    @FXML
    void Table_view_exited(MouseEvent event) {
    	lblbilgi.setText("");

    }

    @FXML
    void Table_view_moved(MouseEvent event) {
   lblbilgi.setText("Guncelleme islemi icin tiklayin");
    }
    
    public void bilgileriGetir(TableView< Kayitlar> tablo) {
    	
    	
    	sql="select*from ogrencikayit";
    	
    	try {
			sorguifadesi=baglanti.prepareStatement(sql);
			
			result=sorguifadesi.executeQuery();
			ObservableList<Kayitlar> liste=FXCollections.observableArrayList();
			
		while(result.next()) {
			liste.add(new Kayitlar(result.getInt("id"), result.getString("Adi"), result.getString("Soyadi"),
					result.getString("Sinifi"), result.getString("Bolumu"),
					result.getString("Cinsiyet"), result.getString("EvAdresi"), result.getInt("PostaKodu"),
					result.getString("Semt"), result.getString("Sehir"), result.getInt("Numara")));
		}
				

			K_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			K_Adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
			K_Soyadi.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
			K_sinifi.setCellValueFactory(new PropertyValueFactory<>("sinifi"));
			K_Bolumu.setCellValueFactory(new PropertyValueFactory<>("bolumu"));
			K_Cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
			K_Ev_Adresi.setCellValueFactory(new PropertyValueFactory<>("evadresi"));
			K_Posta_Kodu.setCellValueFactory(new PropertyValueFactory<>("postakodu"));
			K_Semt.setCellValueFactory(new PropertyValueFactory<>("semt"));
			K_Sehir.setCellValueFactory(new PropertyValueFactory<>("sehir"));
			K_Numara.setCellValueFactory(new PropertyValueFactory<>("numara"));
			table_view.setItems(liste);
			lblsonuc.setText("Baglanti basarili");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			lblsonuc.setText("Baglanti Hatasi");
		}
    	
    	
    	
    	
    }


    @FXML
    void Key_released(KeyEvent event) {
sql="select*from ogrencikayit where Numara like '%"+txt_Ara_Sil.getText()+"%'";
    	
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		//sorguifadesi.setInt(1, Integer.valueOf(txt_Ara_Sil.getText().trim()));
    		
    		result =sorguifadesi.executeQuery();
    	ObservableList<Kayitlar> liste=FXCollections.observableArrayList();
    	
    	while(result.next()) {
    		liste.add(new Kayitlar(result.getInt("id"), result.getString("Adi"), result.getString("Soyadi"),
    				result.getString("Sinifi"), result.getString("Bolumu"), result.getString("Cinsiyet"), 
    				result.getString("EvAdresi"), result.getInt("PostaKodu"), result.getString("Semt"),
    				result.getString("Sehir"), result.getInt("Numara")));
    	}
    		
    		K_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		K_Adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
    		K_Soyadi.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
    		K_sinifi.setCellValueFactory(new PropertyValueFactory<>("sinifi"));
    		K_Bolumu.setCellValueFactory(new PropertyValueFactory<>("bolumu"));
    		K_Cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyet"));
    		K_Ev_Adresi.setCellValueFactory(new PropertyValueFactory<>("evadresi"));
    		K_Posta_Kodu.setCellValueFactory(new PropertyValueFactory<>("postakodu"));
    		K_Semt.setCellValueFactory(new PropertyValueFactory<>("semt"));
    		K_Sehir.setCellValueFactory(new PropertyValueFactory<>("sehir"));
    		K_Numara.setCellValueFactory(new PropertyValueFactory<>("numara"));
    		table_view.setItems(liste);
    		lblsonuc.setText("kayit getirildi");
    		
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		lblsonuc.setText("Hata");
    	}


    }


  


    @FXML
    void initialize() {
    	
    	ToggleGroup toggleGroup=new ToggleGroup();
    	rdbBayan.setToggleGroup(toggleGroup);
    	rdbErkek.setToggleGroup(toggleGroup);
    	
    
    	
       bilgileriGetir(table_view);

    }
}
