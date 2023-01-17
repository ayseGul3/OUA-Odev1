package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.EmlakMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class kayitController {
	
	public kayitController()
	{
		 baglanti = VeritabaniUtil.Baglan();

	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_kayit;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_kayitol;

    @FXML
    private TextField txt_ad;

    @FXML
    private TextField txt_kulad;

    @FXML
    private TextField txt_posta;

    @FXML
    private TextField txt_sifre;

    @FXML
    private TextField txt_soyad;

    @FXML
    private DatePicker txt_tarih;

    @FXML
    private TextField txt_tel;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	
    	try
    	{
    		Alert alert=new Alert(AlertType.WARNING);
        	alert.setTitle("AGT Emlak");
        	alert.setHeaderText("Çýkýþ yapmak istediðinize emin misiniz?");
        	alert.setContentText("Çýkýþ yaptýðýnýz anda kayýt iþleminiz gerçekleþtirilmeyecektir!");
        	alert.showAndWait();
    		
    		
    	    AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Giris.fxml"));
    		
    		anchor_kayit.getChildren().setAll(pane1);	
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    	

    }

    @FXML
    void btn_kayitol_click(ActionEvent event) {
    	
		sql="insert into kayit (ad,soyad,kulad,tel,eposta,sifre) values(?,?,?,?,?,?)";
    	
		try
    	{
			if(txt_ad.getText().isEmpty()|| txt_soyad.getText().isEmpty() || txt_kulad.getText().isEmpty() || txt_tel.getText().isEmpty()||txt_posta.getText().isEmpty()||VeritabaniUtil.MD5Sifrele(txt_sifre.getText()).isEmpty())
			{
				Alert alert=new Alert(AlertType.ERROR);
            	alert.setTitle("AGT Emlak");
            	alert.setHeaderText("Alanlar boþ geçilemez!");
            	alert.setContentText("Boþ alanlarý doldurunuz!");
            	alert.showAndWait();
			}
			else
			{
				sorguIfadesi=baglanti.prepareStatement(sql);
	    		sorguIfadesi.setString(1,txt_ad.getText().trim());
	    		sorguIfadesi.setString(2, txt_soyad.getText().trim());
	    		sorguIfadesi.setString(3, txt_kulad.getText().trim());
	    		sorguIfadesi.setString(4, txt_tel.getText().trim());
	    		sorguIfadesi.setString(5, txt_posta.getText().trim());
	    		sorguIfadesi.setString(6, VeritabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
	    		sorguIfadesi.executeUpdate();

	    		
	    			Alert alert=new Alert(AlertType.INFORMATION);
	            	alert.setTitle("AGT Emlak");
	            	alert.setHeaderText("Kayýt iþlemiz tamamlanmýþtýr.");
	            	alert.setContentText("Aramýza hoþgeldiniz. Giriþ yapmak için 'Giriþ' ekranýna yönlendiriliyorsunuz.");
	            	alert.showAndWait();
	    		
	    			AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Giris.fxml"));
	        		
	        		anchor_kayit.getChildren().setAll(pane1);	
			}
			
    		
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	

    }

    @FXML
    void initialize() {
        

    }

}
