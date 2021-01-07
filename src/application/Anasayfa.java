package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Anasayfa {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img8;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img7;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img5;

    @FXML
    private Button Ogr_kayit;

    @FXML
    private Button Odv_takip;

    @FXML
    private Button Ogr_bilgi;

    @FXML
    private Button Veli_bilgileri;

    @FXML
    private Button Veli_kayit;

    @FXML
    private Button Prs_bilgileri;

    @FXML
    private Button Prs_kayit;

    @FXML
    private Button Cari_hareket;

    @FXML
    private Button Hakkýmýzda;

    @FXML
    private Button Cýkýs; 
    @FXML
    private AnchorPane anchor1;

    @FXML
    void Btn_cari_hareket(ActionEvent event) {
    	

    }

    @FXML
    void btn_cikis(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void btn_hakkimizda(ActionEvent event) {

    }

    @FXML
    void btn_odv_takip(ActionEvent event) { AnchorPane pane;
	try {
		pane = (AnchorPane)FXMLLoader.load(getClass().getResource("OdevTakip.fxml"));
		Scene scene=new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	  Stage stage=new Stage();
    	  stage.initModality(Modality.APPLICATION_MODAL);
	    	  stage.initStyle(StageStyle.UTILITY);
    	  stage.setScene(scene);
    	  stage.show();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    }

    @FXML
    void btn_ogr_bilgi(ActionEvent event) {
    	 AnchorPane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("OgrenciBilgileri.fxml"));
			Scene scene=new Scene(pane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    	  Stage stage=new Stage();
	    	  stage.initModality(Modality.APPLICATION_MODAL);
 	    	  stage.initStyle(StageStyle.UTILITY);
	    	  stage.setScene(scene);
	    	  stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 

    }

    @FXML
    void btn_ogr_kayit(ActionEvent event) {
    	try {
    		
    		
	    	 AnchorPane pane=(AnchorPane)FXMLLoader.load(getClass().getResource("OgrenciKayit.fxml"));
	    	 Scene scene=new Scene(pane);
	    	 scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	    	  Stage stage=new Stage();
	    	  stage.initModality(Modality.APPLICATION_MODAL);
 	    	  stage.initStyle(StageStyle.UTILITY);
	    	  stage.setScene(scene);
	    	  stage.show();
	    	  
	    		
	    		
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
	}
	
    	
      

    

    @FXML
    void btn_prs_bilgileri(ActionEvent event) {
    	 AnchorPane pane;
 		try {
 			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("PersonelListele.fxml"));
 			Scene scene=new Scene(pane);
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 	    	  Stage stage=new Stage();
 	    	 stage.initModality(Modality.APPLICATION_MODAL);
	    	  stage.initStyle(StageStyle.UTILITY);
 	    	  stage.setScene(scene);
 	    	  stage.show();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

    }

    @FXML
    void btn_prs_kayit(ActionEvent event) {
    	 AnchorPane pane;
 		try {
 			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("PersonelEkle.fxml"));
 			Scene scene=new Scene(pane);
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 	    	  Stage stage=new Stage();
 	    	 stage.initModality(Modality.APPLICATION_MODAL);
	    	  stage.initStyle(StageStyle.UTILITY);
 	    	  stage.setScene(scene);
 	    	  stage.show();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

    }

    @FXML
    void btn_veli_bilgileri(ActionEvent event) {
    	 AnchorPane pane;
 		try {
 			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("VeliBilgileri.fxml"));
 			Scene scene=new Scene(pane);
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 	    	  Stage stage=new Stage();
 	    	 stage.initModality(Modality.APPLICATION_MODAL);
	    	  stage.initStyle(StageStyle.UTILITY);
 	    	  stage.setScene(scene);
 	    	  stage.show();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

    }

    @FXML
    void btn_veli_kayit(ActionEvent event) {
    	 AnchorPane pane;
 		try {
 			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("VeliKayit.fxml"));
 			Scene scene=new Scene(pane);
 			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 	    	  Stage stage=new Stage();
 	    	 stage.initModality(Modality.APPLICATION_MODAL);
	    	  stage.initStyle(StageStyle.UTILITY);
 	    	  stage.setScene(scene);
 	    	  stage.show();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

    }

    @FXML
    void initialize() {
    	
    	
       
    	  Image image1=new Image("/Resim/ogrenciKayit.png");
          Image image2=new Image("/Resim/ogrenciBilgileri.png");
          Image image3=new Image("/Resim/odevTakip.png");
          Image image4=new Image("/Resim/cariIslemler.png");
          Image image5=new Image("/Resim/personelKayit.png");
          Image image6=new Image("/Resim/personelBilgileri.png");
          Image image7=new Image("/Resim/veliKayit.png");
          Image image8=new Image("/Resim/veliBilgileri.png");
          
          img1.setImage(image1);
          img2.setImage(image2);
          img3.setImage(image3);
          img4.setImage(image4);
          img5.setImage(image5);
          img6.setImage(image6);
          img7.setImage(image7);
          img8.setImage(image8);
       
    }
}
