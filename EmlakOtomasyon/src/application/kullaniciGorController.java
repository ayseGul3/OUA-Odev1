package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.EmlakMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;

public class kullaniciGorController {
	
	public kullaniciGorController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_kulgor;

    @FXML
    private Button btn_cikis;

    @FXML
    private TableColumn<Kayitlar, String> table_ad;

    @FXML
    private TableView<Kayitlar> table_kayitlikul;

    @FXML
    private TableColumn<Kayitlar, String> table_kulad; 

    @FXML
    private TableColumn<Kayitlar, String> table_posta;

    @FXML
    private TableColumn<Kayitlar, String> table_sifre;

    @FXML
    private TableColumn<Kayitlar, String> table_soyad;

    @FXML
    private TableColumn<Kayitlar, String> table_tel;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public void degerAl(TableView tablo,String sql)
    {
    	ObservableList<Kayitlar>kayitlarListe=FXCollections.observableArrayList();
    	
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		while(getirilen.next())
    		{
    			kayitlarListe.add(new Kayitlar(getirilen.getString("ad"),getirilen.getString("soyad"),getirilen.getString("kulad"),getirilen.getString("tel"),getirilen.getString("eposta"),getirilen.getString("sifre")));
    		}
    		
			
			table_ad.setCellValueFactory(new PropertyValueFactory<>("ad"));
			table_soyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
			table_kulad.setCellValueFactory(new PropertyValueFactory<>("kulad"));
			table_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
			table_posta.setCellValueFactory(new PropertyValueFactory<>("eposta"));
			table_sifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
			
			table_kayitlikul.setItems(kayitlarListe);

		} 
    	catch (Exception e) {
    		System.out.println(e.getMessage().toString());
		}
    	
    }
    
    

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	

    	try
    	{
    		Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("yetkiliMenu.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.setTitle("AGT Emlak");
    		stage.show();
    		
    		Stage stage1 = (Stage) btn_cikis.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void table_kayitlikul_mauseclick(MouseEvent event) {

    }

    @FXML
    void initialize() {
    	
    	sql="select*from kayit";
    	degerAl(table_kayitlikul,sql);
     
    }

}
