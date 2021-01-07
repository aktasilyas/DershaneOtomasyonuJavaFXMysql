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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonelListele {
	
	String sorgu="";
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	ResultSet getirilen=null;
	
	public PersonelListele() {
		
		baglanti=sqlBaglanti.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane panePersonelListele;

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
    private TableView<PersonelKay�tlar> tableview;

    @FXML
    private TableColumn<PersonelKay�tlar, Integer> ID;

    @FXML
    private TableColumn<PersonelKay�tlar, String> Adi;

    @FXML
    private TableColumn<PersonelKay�tlar, String> Soyadi;

    @FXML
    private TableColumn<PersonelKay�tlar, String> Gorevi;

    @FXML
    private TableColumn<PersonelKay�tlar, String> Cinsiyet;

    @FXML
    private TableColumn<PersonelKay�tlar, String> EvAdresi;

    @FXML
    private TableColumn<PersonelKay�tlar, Integer> Postakodu;

    @FXML
    private TableColumn<PersonelKay�tlar, String> Sehir;

    @FXML
    private TableColumn<PersonelKay�tlar, String> Semt;

    @FXML
    private TableColumn<PersonelKay�tlar, Integer> Maas;

    @FXML
    private Button sil;

    @FXML
    private Button guncelle;

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
	    	  panePersonelListele.getScene().getWindow().hide();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


    @FXML
    void btnguncelle(ActionEvent event) {
    	
    	sorgu="update personelkayit set Adi=?,Soyadi=?,gorevi=?,Cinsiyet=?,EvAdresi=?,Semt=?,Sehir=?,PostaKodu=?,maas=?  where id=? ";
    	   String cinsiyet="";
    	   if(rdbBayan.isSelected()) {
    			cinsiyet=rdbBayan.getText();
    		}
    		if(rdbErkek.isSelected()) {
    			cinsiyet=rdbErkek.getText();
    		}
    		
    		PersonelKay�tlar kayitlar=new PersonelKay�tlar();
    		kayitlar=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    		int GelenId=kayitlar.getId();
    	       try {
    			sorguifadesi=baglanti.prepareStatement(sorgu);
    			sorguifadesi.setString(1, txtAdi.getText().trim());
    			sorguifadesi.setString(2, txtsoyadi.getText().trim());
    			sorguifadesi.setString(3, gorevi.getText().trim());
    			sorguifadesi.setString(4,  cinsiyet.trim().toLowerCase());
    			sorguifadesi.setString(5,textareaAdres.getText().trim());
    			sorguifadesi.setString(6, txtsemt.getText().trim() );
    			sorguifadesi.setString(7,txtsehir.getText().trim());
    			sorguifadesi.setInt(8, Integer.valueOf(txtpostakodu.getText().trim()));
    			sorguifadesi.setInt(9, Integer.valueOf(maas.getText().trim()));
    			sorguifadesi.setInt(10, Integer.valueOf(GelenId));
    			
    			
    			sorguifadesi.executeUpdate();
    			Kayitlar(tableview);
    			lblsonuc.setText("Basarili Bir Sekilde Guncellendi");
    			Temizle();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			lblsonuc.setText(e.getMessage().toString());
    		}

    }

    @FXML
    void btnsil(ActionEvent event) {
sorgu="delete from personelkayit where id=?";
    	
    	PersonelKay�tlar kayitlar=new PersonelKay�tlar();
    	kayitlar=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    	int GelenId=kayitlar.getId();    	
  	try {
			sorguifadesi=baglanti.prepareStatement(sorgu);
		
			sorguifadesi.setInt(1,GelenId);
			
			sorguifadesi.executeUpdate();
			Kayitlar(tableview);
			lblsonuc.setText("Basarili bir sekilde silindi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			lblsonuc.setText(e.getMessage().toString());
		}
    	
    	Temizle();

    }
    ObservableList<PersonelKay�tlar> veriler;
    public void Kayitlar(TableView<PersonelKay�tlar> tablolar) {
    	
    	  sorgu="select *from personelkayit";
    	  
    	  try {
			sorguifadesi=baglanti.prepareStatement(sorgu);
			
			getirilen=sorguifadesi.executeQuery();
			
			veriler=FXCollections.observableArrayList();
			while(getirilen.next()) {
				veriler.add(new PersonelKay�tlar(getirilen.getInt("id"), getirilen.getString("Adi"),  getirilen.getString("Soyadi"),
						 getirilen.getString("gorevi"),  getirilen.getString("Cinsiyet"),  getirilen.getString("EvAdresi"),
						 getirilen.getString("Semt"),  getirilen.getString("Sehir"),  getirilen.getInt("postakodu"),  getirilen.getInt("maas")));
			}
			
			ID.setCellValueFactory(new PropertyValueFactory<>("id"));
			Adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
			Soyadi.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
			Gorevi.setCellValueFactory(new PropertyValueFactory<>("gorevi"));
			Cinsiyet.setCellValueFactory(new PropertyValueFactory<>("cinsiyeti"));
			EvAdresi.setCellValueFactory(new PropertyValueFactory<>("evadresi"));
			Semt.setCellValueFactory(new PropertyValueFactory<>("semt"));
			Sehir.setCellValueFactory(new PropertyValueFactory<>("sehir"));
			Postakodu.setCellValueFactory(new PropertyValueFactory<>("postakodu"));
			Maas.setCellValueFactory(new PropertyValueFactory<>("maas"));
			tableview.setItems(veriler);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public void Temizle() {
    	txtAdi.setText("");
    	txtsoyadi.setText("");
    	gorevi.setText("");
    	maas.setText("");
    	textareaAdres.setText("");
    	txtpostakodu.setText("");
    	txtsemt.setText("");
    	txtsehir.setText("");
    	rdbBayan.setSelected(false);
    	rdbErkek.setSelected(false);
    }
    @FXML
    void tableclick(MouseEvent event) {
    	  PersonelKay�tlar kayitlar=new PersonelKay�tlar();
      	if(tableview.getSelectionModel().getSelectedIndex()!=-1) {
      	kayitlar=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
      	txtAdi.setText(kayitlar.getAdi());
      	txtsoyadi.setText(kayitlar.getSoyadi());
      	maas.setText(String.valueOf(kayitlar.getMaas()));
      	gorevi.setText(kayitlar.getGorevi());
      	
      	if(kayitlar.getCinsiyeti().equals("Bayan".toLowerCase())||kayitlar.getCinsiyeti().equals("kiz".toLowerCase())) {
      		rdbBayan.setSelected(true);
      		
      	}
      	if(kayitlar.getCinsiyeti().equals("Erkek".toLowerCase())) {
      		
      		rdbErkek.setSelected(true);
      		
      	}
      		
      	textareaAdres.setText(kayitlar.getEvadresi());
      	txtpostakodu.setText(String.valueOf(kayitlar.getPostakodu()));
      	txtsemt.setText(kayitlar.getSemt());
      	txtsehir.setText(kayitlar.getSehir());
      	}
      	

    }

    @FXML
    void initialize() {
    	Kayitlar(tableview);
    	
    	ToggleGroup toggleGroup=new ToggleGroup();
    	rdbBayan.setToggleGroup(toggleGroup);
    	rdbErkek.setToggleGroup(toggleGroup);
       

    }
}
