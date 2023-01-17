package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.EmlakMySQL.Util.VeritabaniUtil;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.*;

public class GirisController {

	public GirisController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane anc;
    
    @FXML
    private AnchorPane achor_giris;

    @FXML
    private AnchorPane achor_giris1;

    @FXML
    private AnchorPane anc_yetki;

    @FXML
    private AnchorPane anchor_yetkiligiris;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_giris;

    @FXML
    private Button btn_giris_yetkili;

    @FXML
    private Button btn_kayit;

    @FXML
    private Button btn_yetkiligiris;

    @FXML
    private TextField txt_kulad;

    @FXML
    private TextField txt_kulad1;
    
    @FXML
    private PasswordField txt_sifre;

    @FXML
    private TextField txt_sifre1;
    
    @FXML
    private PasswordField txt_sifre2;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	try
    	{
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Giris.fxml"));
    		
    		achor_giris.getChildren().setAll(pane1);
    		
    		
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void btn_giris_click(ActionEvent event) {
       
    	sql="select*from kayit where kulad=? and sifre=?";
    	
    	try
    	{
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_kulad.getText().trim());
    		sorguIfadesi.setString(2, VeritabaniUtil.MD5Sifrele(txt_sifre.getText().trim()));
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next())
    		{
    			Alert alert=new Alert(AlertType.ERROR);
            	alert.setTitle("AGT Emlak");
            	alert.setHeaderText("Hatalý giriþ yaptýnýz!");
            	alert.setContentText("Kullanýcý adý veya þifrenizi kontrol ederek yeniden deneyiniz.");
            	alert.showAndWait();
    		}
    		else
    		{
    			Stage stage=new Stage();
        		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("ilanGor.fxml"));
        		
        		Scene scene1=new Scene(pane1);
        		stage.setScene(scene1);
        		stage.show();
        		
    			Stage stage1 = (Stage) btn_giris.getScene().getWindow();
        	    stage1.close();
    		}
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		

    }

    @FXML
    void btn_giris_yetkili_click(ActionEvent event) {

    	
    	sql="select*from yonetici where yonetici_ad=? and yonetici_sifre=?";

    	
    	try
    	{
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_kulad1.getText().trim());
    		sorguIfadesi.setString(2, VeritabaniUtil.MD5Sifrele(txt_sifre2.getText().trim()));
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next())
    		{
    			Alert alert=new Alert(AlertType.ERROR);
            	alert.setTitle("AGT Emlak");
            	alert.setHeaderText("Hatalý veya eksik giriþ yaptýnýz.");
            	alert.setContentText("Yönetici giriþi içindir.Bilgilerinizi kontrol edip tekrar deneyiniz.");
            	alert.showAndWait();
    			
    		}
    		else
    		{
    			
            	Alert alert=new Alert(AlertType.INFORMATION);
            	alert.setTitle("AGT Emlak");
            	alert.setHeaderText("Sn. Ayþe Gül Tüysüz");
            	alert.setContentText("Hoþgeldiniz");
            	alert.showAndWait();
        		
        		Stage stage=new Stage();
        		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("yetkiliMenu.fxml"));
        		
        		Scene scene1=new Scene(pane1);
        		stage.setScene(scene1);
        		stage.setTitle("AGT Emlak");
        		stage.show();
        		
        		Stage stage1 = (Stage) btn_giris_yetkili.getScene().getWindow();
        	    stage1.close();
    		}
    		
    		
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    	

    }

    @FXML
    void btn_kayit_click(ActionEvent event) {
    	try
    	{
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("kayit.fxml"));
    		
    		achor_giris.getChildren().setAll(pane1);
    		
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void btn_yetkiligiris_click(ActionEvent event) {
    	try
    	{
    		TranslateTransition tt=new TranslateTransition(Duration.seconds(0.5),anchor_yetkiligiris);
    		
    		tt.setByX(-935);
    		tt.play();
    		
    		
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
