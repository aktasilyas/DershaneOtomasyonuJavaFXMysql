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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VeliBilgileri {
	
	
String sql="";
	
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	ResultSet getirilen=null;
	
	 public VeliBilgileri() {
	
	   
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
    private TextField txtegitimdurumu;

    @FXML
    private TextArea txtareaisadresi;

    @FXML
    private TextArea txtareaevadresi;

    @FXML
    private TextField txtposta;

    @FXML
    private TextField txttelefon;

    @FXML
    private TextField txttc;

    @FXML
    private TextField txtgelir;

    @FXML
    private TableView<VeliKayitlari> tableview;

    @FXML
    private TableColumn<VeliKayitlari, Integer> V_Id;
    @FXML
    private TableColumn<VeliKayitlari, String> V_adi;

    @FXML
    private TableColumn<VeliKayitlari, String> V_soyadi;

    @FXML
    private TableColumn<VeliKayitlari, String> V_yakinligi;

    @FXML
    private TableColumn<VeliKayitlari, String> V_egitim;

    @FXML
    private TableColumn<VeliKayitlari, Integer> V_postakodu;

    @FXML
    private TableColumn<VeliKayitlari, Integer> V_ceptelefonu;

    @FXML
    private TableColumn<VeliKayitlari, Integer> V_Tc;

    @FXML
    private TableColumn<VeliKayitlari, Integer> V_gelir;

    @FXML
    private TableColumn<VeliKayitlari, String> V_isadesi;

    @FXML
    private TableColumn<VeliKayitlari,String> V_evadresi;

    @FXML
    private TextField txtTCara;

    @FXML
    private Label lblAnasayfa;

    @FXML
    private Label lblcýkýsyap;
    @FXML
    private Button sil;

    @FXML
    private Button guncelle;
    

    @FXML
    void Key_released(KeyEvent event) {
sql="select*from velikayit where TcKimlikNo like '%"+txtTCara.getText()+"%'";
    	
    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		
    		//sorguifadesi.setInt(1, Integer.valueOf(txt_Ara_Sil.getText().trim()));
    		
    		getirilen =sorguifadesi.executeQuery();
    	ObservableList<VeliKayitlari> liste=FXCollections.observableArrayList();
    	
    	while(getirilen.next()) {
    		liste.add(new VeliKayitlari(getirilen.getInt("id"), getirilen.getString("Adi"), getirilen.getString("Soyadi"),
    				getirilen.getString("Yakinligi"),getirilen.getString("EgitimDurumu"),
    				getirilen.getInt("PostaKodu"), getirilen.getInt("CepTelefonu"), getirilen.getInt("TcKimlikNo"),
    				getirilen.getInt("GelirDuzeyi"),getirilen.getString("isAdresi"),
    				getirilen.getString("EvAdresi")));
    	}
    		
    		V_Id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		V_adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
    		V_soyadi.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
    		V_yakinligi.setCellValueFactory(new PropertyValueFactory<>("yakinligi"));
    		V_egitim.setCellValueFactory(new PropertyValueFactory<>("egitimdurumu"));
    		V_postakodu.setCellValueFactory(new PropertyValueFactory<>("postakodu"));
    		V_ceptelefonu.setCellValueFactory(new PropertyValueFactory<>("ceptelefonu"));
    		V_Tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
    		V_gelir.setCellValueFactory(new PropertyValueFactory<>("gelir"));
    		V_isadesi.setCellValueFactory(new PropertyValueFactory<>("isadresi"));
    		V_evadresi.setCellValueFactory(new PropertyValueFactory<>("evadresi"));
    		tableview.setItems(liste);
    		lblsonuc.setText("kayit getirildi");
    		
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		lblsonuc.setText("Hata");
    	}


    }

    @FXML
    void btn_anasayfa(ActionEvent event) {
    	AnchorPane pane;
		try {
			pane = FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
			Scene scene=new Scene(pane);
	    	Stage stage=new Stage();
	    	stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
	    	stage.setScene(scene);
	    	stage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void lbl_Anasayfadon(MouseEvent event) {
    	
    	AnchorPane pane;
		try {
			pane = FXMLLoader.load(getClass().getResource("Anasayfa.fxml"));
			Scene scene=new Scene(pane);
	    	Stage stage=new Stage();
	    	stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
	    	stage.setScene(scene);
	    	stage.showAndWait();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

    @FXML
    void lbl_Cikisyap(MouseEvent event) {
    	System.exit(0);

    }
    @FXML
    void btnguncelle(ActionEvent event) {
    	
    	
    	
    	VeliKayitlari kayitlari=new VeliKayitlari();
    	kayitlari=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    	int idgetir=kayitlari.getId();
    	
    	sql="update velikayit set Adi=?, Soyadi=?,  Yakinligi=?, isAdresi=?, EvAdresi=?,"
    			+ "PostaKodu=?, CepTelefonu=?, TcKimlikNo=?, EgitimDurumu=?,GelirDuzeyi=? where id=?";
    			
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
					sorguifadesi.setInt(11, idgetir);
					
					
					sorguifadesi.executeUpdate();
					bilgileriGetir(tableview);
					
					lblsonuc.setText("Güncelleme Baþarýlý");
					
					Temizle();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					lblsonuc.setText(e.getMessage().toString());
				}

    }
    

    @FXML
    void btnsil(ActionEvent event) {
    	
    	
    	VeliKayitlari kayitlari=new VeliKayitlari();
    	kayitlari=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    	int seciliId=kayitlari.getId();
    	sql="delete from velikayit where id=?";
    	
    	
    		try {
    			sorguifadesi=baglanti.prepareStatement(sql);
    			
    			
    			sorguifadesi.setInt(1, seciliId);
    			
    	    		
    				sorguifadesi.executeUpdate();
    				
    	    		
    				bilgileriGetir(tableview);
    				lblsonuc.setText("silme islemi basarili");
    				Temizle();
    			
    			
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			lblsonuc.setText(e.getMessage().toString());
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
    void table_view(MouseEvent event) {
    	
    	
    	
    	VeliKayitlari kayitlari=new VeliKayitlari();
    	if(tableview.getSelectionModel().getSelectedIndex()!=-1) {
    		
    		kayitlari=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    		txtAdi.setText(kayitlari.getAdi());
    		txtsoyadi.setText(kayitlari.getSoyadi());
    		txtyakinligi.setText(kayitlari.getYakinligi());
    		txtegitimdurumu.setText(kayitlari.getEgitimdurumu());
    		txtposta.setText(String.valueOf(kayitlari.getPostakodu()));
    		txttelefon.setText(String.valueOf(kayitlari.getTelefon()));
    		txttc.setText(String.valueOf(kayitlari.getTc()));
    		txtgelir.setText(String.valueOf(kayitlari.getGelir()));
    		txtareaisadresi.setText(kayitlari.getIsadresi());
    		txtareaevadresi.setText(kayitlari.getEvadresi());
    		
    		
    	}

    }
    
    public void bilgileriGetir(TableView<VeliKayitlari> tablo) {
    	
    	sql="select *from velikayit";
    	
    	try {
			sorguifadesi=baglanti.prepareStatement(sql);
			
		   getirilen= sorguifadesi.executeQuery();
		
		ObservableList<VeliKayitlari> veriler=FXCollections.observableArrayList();
		while(getirilen.next()) {
			veriler.add(new VeliKayitlari(getirilen.getInt("id"), getirilen.getString("Adi"), getirilen.getString("Soyadi"),getirilen.getString("Yakinligi"),
					getirilen.getString("EgitimDurumu"),getirilen.getInt("PostaKodu"),getirilen.getInt("CepTelefonu"),
				    getirilen.getInt("TcKimlikNo"),getirilen.getInt("GelirDuzeyi") ,getirilen.getString("isAdresi"), getirilen.getString("EvAdresi")));
		}
		
		V_Id.setCellValueFactory(new PropertyValueFactory<>("id"));
		 V_adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
		V_soyadi.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
		V_yakinligi.setCellValueFactory(new PropertyValueFactory<>("yakinligi"));
		V_egitim.setCellValueFactory(new PropertyValueFactory<>("egitimdurumu"));
		V_postakodu.setCellValueFactory(new PropertyValueFactory<>("postakodu"));
		V_ceptelefonu.setCellValueFactory(new PropertyValueFactory<>("telefon"));
		V_Tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
		V_gelir.setCellValueFactory(new PropertyValueFactory<>("gelir"));
		V_isadesi.setCellValueFactory(new PropertyValueFactory<>("isadresi"));
		V_evadresi.setCellValueFactory(new PropertyValueFactory<>("evadresi"));
		
		tableview.setItems(veriler);
		lblsonuc.setText("Baglanti basarili");
		} catch (SQLException e) {
			lblsonuc.setText(e.getMessage().toString());
		}
    	
    	
    	
    }

    @FXML
    void initialize() {
    	
    	Tooltip tooltip=new Tooltip();
    	tooltip.setText("silmek icin once kayit secin");
    	
    	sil.setTooltip(tooltip);
    	

	
    	bilgileriGetir(tableview);

    }
}
