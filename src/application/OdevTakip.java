package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class OdevTakip {
	
	String sql="";
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	ResultSet getirilen=null;
	public OdevTakip() {
		
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
    private TextField txtsinifi;

    @FXML
    private TextField txtmailadresi;

    @FXML
    private TextField txtbolumu;

    @FXML
    private TextField txtodevalacagýders;

    @FXML
    private TextField txtderskonusu;

    @FXML
    private DatePicker dateverTarýhi;

    @FXML
    private DatePicker dateTeslimtarihi;

    @FXML
    private TextField txtverilennot;

    @FXML
    private TableView<OdevTakipKayitlar> tableview;

    @FXML
    private TableColumn<OdevTakipKayitlar, Integer> K_id;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_adi;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_soyadi;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_sinifi;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_bolumu;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_O_tarihi;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_DersKonusu;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_Vtarihi;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_Ttarihi;

    @FXML
    private TableColumn<OdevTakipKayitlar, Integer> K_not;

    @FXML
    private TableColumn<OdevTakipKayitlar, String> K_mailadresi;

    @FXML
    private Button anasayfa;

    @FXML
    private Button kaydet;
    @FXML
    private Button sil;

    @FXML
    private Button guncelle;

    @FXML
    private ImageView imageOdev;
    
    

    @FXML
    void btnanasayfa(ActionEvent event) {

    }

    @FXML
    void btnkaydet(ActionEvent event) {
    	
    	
    	sql="insert into odevtakip(Adi,Soyadi,Sinifi,Bolumu,OdevAlacagiDers,DersKonusu,VerilisTarihi,TeslimTarihi,VerilenNot,MailAdresi) values(?,?,?,?,?,?,?,?,?,?)";
    	
          try {
			sorguifadesi=baglanti.prepareStatement(sql);
			
			sorguifadesi.setString(1, txtAdi.getText().trim());
			sorguifadesi.setString(2, txtsoyadi.getText().trim());
			sorguifadesi.setString(3, txtsinifi.getText().trim());
			sorguifadesi.setString(4, txtbolumu.getText().trim());
			sorguifadesi.setString(5, txtodevalacagýders.getText().trim());
			sorguifadesi.setString(6, txtderskonusu.getText().trim());
			sorguifadesi.setString(7,String.valueOf(dateverTarýhi.getValue())) ;
			sorguifadesi.setString(8, String.valueOf(dateTeslimtarihi.getValue()));
			sorguifadesi.setInt(9, 	Integer.parseInt(txtverilennot.getText().trim()));
			sorguifadesi.setString(10, txtmailadresi.getText().trim());
			
			sorguifadesi.executeUpdate();
			Bilgilerigetir(tableview);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Temizle();

    }
    
    @FXML
    void btnsil(ActionEvent event) {
    	sql="delete from odevtakip where id=?";
    	OdevTakipKayitlar odev=new OdevTakipKayitlar();
    	odev=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    	int id=odev.getId();
    	
    	try {
			sorguifadesi=baglanti.prepareStatement(sql);
			
			sorguifadesi.setInt(1, id);
			sorguifadesi.executeUpdate();
			Bilgilerigetir(tableview);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Temizle();

    }
    @FXML
    void btnguncelle(ActionEvent event) {
    	OdevTakipKayitlar odev=new OdevTakipKayitlar();
    	odev=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    	int id=odev.getId();
    	
    	sql="update odevtakip set Adi=?,Soyadi=?,Sinifi=?,Bolumu=?,OdevAlacagiDers=?,DersKonusu=?,"
    			+ "VerilisTarihi=?,TeslimTarihi=?,VerilenNot=?,MailAdresi=? where id=?";
    	 try {
 			sorguifadesi=baglanti.prepareStatement(sql);
 			
 			sorguifadesi.setString(1, txtAdi.getText().trim());
 			sorguifadesi.setString(2, txtsoyadi.getText().trim());
 			sorguifadesi.setString(3, txtsinifi.getText().trim());
 			sorguifadesi.setString(4, txtbolumu.getText().trim());
 			sorguifadesi.setString(5, txtodevalacagýders.getText().trim());
 			sorguifadesi.setString(6, txtderskonusu.getText().trim());
 			sorguifadesi.setString(7,String.valueOf(dateverTarýhi.getValue())) ;
 			sorguifadesi.setString(8, String.valueOf(dateTeslimtarihi.getValue()));
 			sorguifadesi.setInt(9, 	Integer.parseInt(txtverilennot.getText().trim()));
 			sorguifadesi.setString(10, txtmailadresi.getText().trim());
 			sorguifadesi.setInt(11, id);
 			
 			sorguifadesi.executeUpdate();
 			Bilgilerigetir(tableview);
 			Temizle();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

    }

    @FXML
    void tableview_clicked(MouseEvent event) {
    	OdevTakipKayitlar odev=new OdevTakipKayitlar();
    	odev=tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
    	txtAdi.setText(odev.getAdi());
    	txtsoyadi.setText(odev.getSoyadi());
    	txtsinifi.setText(odev.getSinifi());
    	txtbolumu.setText(odev.getBolumu());
    	txtodevalacagýders.setText(odev.getOdevalacagiders());
    	txtderskonusu.setText(odev.getKonusu());
    	dateTeslimtarihi.setValue(LocalDate.parse(odev.getTtarihi()));
    	dateverTarýhi.setValue(LocalDate.parse(odev.getVtarihi()));
    	txtverilennot.setText(String.valueOf(odev.getNot()));
    	txtmailadresi.setText(odev.getMail());
    	
    	

    }
    public void Temizle() {
    	
    	LocalDate date=LocalDate.now();
    	txtAdi.setText("");
    	txtsoyadi.setText("");
    	txtsinifi.setText("");
    	txtbolumu.setText("");
    	txtodevalacagýders.setText("");
    	txtderskonusu.setText("");
    	dateTeslimtarihi.setValue(date);
    	dateverTarýhi.setValue(date);
    	txtverilennot.setText("");
    	txtmailadresi.setText("");
		
	}
    public void Bilgilerigetir(TableView<OdevTakipKayitlar> tablo) {
    	
    	sql="select *from odevtakip";
    	try {
			sorguifadesi=baglanti.prepareStatement(sql);
			
			getirilen=sorguifadesi.executeQuery();
			 ObservableList<OdevTakipKayitlar> veriler=FXCollections.observableArrayList();
			
			while(getirilen.next()) {
				veriler.add(new OdevTakipKayitlar(getirilen.getInt("id"), getirilen.getString("Adi"), getirilen.getString("Soyadi"),
						getirilen.getString("Sinifi"), getirilen.getString("Bolumu"), getirilen.getString("OdevAlacagiDers"), 
						getirilen.getString("DersKonusu"), getirilen.getString("VerilisTarihi"), getirilen.getString("TeslimTarihi"),
						getirilen.getInt("VerilenNot"), getirilen.getString("MailAdresi")));
				
			}
			
			K_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
			K_adi.setCellValueFactory(new PropertyValueFactory<>("adi"));
			K_soyadi.setCellValueFactory(new PropertyValueFactory<>("soyadi"));
			K_sinifi.setCellValueFactory(new PropertyValueFactory<>("sinifi"));
			K_bolumu.setCellValueFactory(new PropertyValueFactory<>("bolumu"));
			K_O_tarihi.setCellValueFactory(new PropertyValueFactory<>("odevalacagiders"));
			K_DersKonusu.setCellValueFactory(new PropertyValueFactory<>("konusu"));
			K_Vtarihi.setCellValueFactory(new PropertyValueFactory<>("Vtarihi"));
			K_Ttarihi.setCellValueFactory(new PropertyValueFactory<>("Ttarihi"));
			K_not.setCellValueFactory(new PropertyValueFactory<>("not"));
			K_mailadresi.setCellValueFactory(new PropertyValueFactory<>("mail"));
			tableview.setItems(veriler);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void initialize() {
    	Bilgilerigetir(tableview);
    	
    	Image image=new Image("Resim/Work.png");
    	imageOdev.setImage(image);
       

    }
}
