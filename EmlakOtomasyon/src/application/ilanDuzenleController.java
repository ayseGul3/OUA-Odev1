package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.EmlakMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ilanDuzenleController {
	
	public ilanDuzenleController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_temizle;
    

    @FXML
    private TableColumn<Ilan, String> tab_aciklama;

    @FXML
    private TableColumn<Ilan, String> tab_adres;

    @FXML
    private TableColumn<Ilan, String> tab_baslik;

    @FXML
    private TableColumn<Ilan, Integer> tab_bulkat;

    @FXML
    private TableColumn<Ilan, Double> tab_fiyat;

    @FXML
    private TableColumn<Ilan, Integer> tab_id;

    @FXML
    private TableColumn<Ilan, String> tab_kategori;

    @FXML
    private TableColumn<Ilan, Integer> tab_katsay;

    @FXML
    private TableColumn<Ilan, Integer> tab_metrekare;

    @FXML
    private TableColumn<Ilan, Integer> tab_odasay;

    @FXML
    private TableColumn<Ilan, String> tab_sehir;

    @FXML
    private TableColumn<Ilan, String> tab_tur;    

    @FXML
    private TableView<Ilan> tableview_ilangor;

    @FXML
    private TextField txt_bulkat;

    @FXML
    private TextField txt_fiyat;

    @FXML
    private TextField txt_ilanbaslik;

    @FXML
    private TextField txt_ilanid;

    @FXML
    private TextField txt_kategori;

    @FXML
    private TextField txt_katsay;

    @FXML
    private TextField txt_metrek;

    @FXML
    private TextField txt_odasay;

    @FXML
    private TextField txt_sehir;

    @FXML
    private TextField txt_tur;

    @FXML
    private TextArea txta_aciklama;

    @FXML
    private TextArea txta_adres;
    

    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public void degerAl(TableView tablo)
    {
    	sql="select*from ilan";
    	ObservableList<Ilan>ilanListe=FXCollections.observableArrayList();
    	try {
			
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		while(getirilen.next())
    		{
    			ilanListe.add(new Ilan(getirilen.getInt("ilanid"),getirilen.getString("ilanbaslik"),getirilen.getString("kategori"),getirilen.getString("tur"),getirilen.getString("sehir"),getirilen.getInt("katsayi"),getirilen.getInt("bulkat"),getirilen.getInt("odasayi"),getirilen.getInt("metrekare"),getirilen.getDouble("fiyat"),getirilen.getString("adres"),getirilen.getString("aciklama")));
    			
    		}
    			tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    			tab_baslik.setCellValueFactory(new PropertyValueFactory<>("baslik"));
    			tab_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
    			tab_tur.setCellValueFactory(new PropertyValueFactory<>("tur"));
    			tab_sehir.setCellValueFactory(new PropertyValueFactory<>("sehir"));
    			tab_katsay.setCellValueFactory(new PropertyValueFactory<>("katsay"));
    			tab_bulkat.setCellValueFactory(new PropertyValueFactory<>("bulkat"));
    			tab_odasay.setCellValueFactory(new PropertyValueFactory<>("odasay"));
    			tab_metrekare.setCellValueFactory(new PropertyValueFactory<>("metrekare"));
    			tab_fiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
    			tab_adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
    			tab_aciklama.setCellValueFactory(new PropertyValueFactory<>("aciklama"));
    			
    			tableview_ilangor.setItems(ilanListe);
    			
    			
    			
    		
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	
    	try
    	{
    		Alert alert=new Alert(AlertType.WARNING);
        	alert.setTitle("AGT Emlak");
        	alert.setHeaderText("Çýkýþ yapmak istediðiniz emin misiniz?");
        	alert.setContentText("Çýkýþ yapmadan önce ayarlarýnýzý kaydettiðinizden emin olunuz.");
        	alert.showAndWait();
    		
        	Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("yetkiliMenu.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
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
    void btn_ekle_click(ActionEvent event) {
    	
    	sql="insert into ilan (ilanbaslik,kategori,tur,sehir,katsayi,bulkat,odasayi,metrekare,fiyat,adres,aciklama) values (?,?,?,?,?,?,?,?,?,?,?)";
    	try {
			
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_ilanbaslik.getText().trim());
    		sorguIfadesi.setString(2,txt_kategori.getText().trim());
    		sorguIfadesi.setString(3,txt_tur.getText().trim());
            sorguIfadesi.setString(4,txt_sehir.getText().trim());
    		sorguIfadesi.setString(5,txt_katsay.getText().trim());
    		sorguIfadesi.setString(6,txt_bulkat.getText().trim());
    		sorguIfadesi.setString(7,txt_odasay.getText().trim());
    		sorguIfadesi.setString(8,txt_metrek.getText().trim());
    		sorguIfadesi.setString(9,txt_fiyat.getText().trim());
    		sorguIfadesi.setString(10,txta_adres.getText().trim());
    		sorguIfadesi.setString(11,txta_aciklama.getText().trim());
    		
    		sorguIfadesi.executeUpdate();
    		degerAl(tableview_ilangor);
    		
    		Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("AGT Emlak");
        	alert.setHeaderText("Ýlan eklendi.");
        	alert.setContentText("Ekleme iþleminiz baþarýyla gerçekleþtirildi.");
        	alert.showAndWait();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}

    }

    @FXML
    void btn_guncelle_click(ActionEvent event) {
    	
    	sql="update ilan set ilanbaslik=?, kategori=?, tur=?, sehir=?, katsayi=?, bulkat=?, odasayi=?, metrekare=?, fiyat=?, adres=?, aciklama=? where ilanid=?";

		
    	try {
			
    		
			sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_ilanbaslik.getText().trim());
    		sorguIfadesi.setString(2,txt_kategori.getText().trim());
    		sorguIfadesi.setString(3,txt_tur.getText().trim());
            sorguIfadesi.setString(4,txt_sehir.getText().trim());
    		sorguIfadesi.setString(5,txt_katsay.getText().trim());
    		sorguIfadesi.setString(6,txt_bulkat.getText().trim());
    		sorguIfadesi.setString(7,txt_odasay.getText().trim());
    		sorguIfadesi.setString(8,txt_metrek.getText().trim());
    		sorguIfadesi.setString(9,txt_fiyat.getText().trim());
    		sorguIfadesi.setString(10,txta_adres.getText().trim());
    		sorguIfadesi.setString(11,txta_aciklama.getText().trim());
    		sorguIfadesi.setString(12,txt_ilanid.getText().trim());
    		
    		Alert alert=new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("AGT Emlak");
        	alert.setHeaderText("Ýlan üzerinde deðiþiklik yapmak istediðinize emin misiniz?");
        	alert.setContentText("Ýlan üzerinde yapýlan deðiþiklikler geri alýnamaz.");
        	
        	ButtonType btn1=new ButtonType("Evet");
        	ButtonType btn2=new ButtonType("Hayýr",ButtonData.CANCEL_CLOSE);
        	
        	alert.getButtonTypes().setAll(btn1,btn2);
        	Optional<ButtonType> buton=alert.showAndWait();
        	if(buton.get()==btn1)
        	{
        		sorguIfadesi.executeUpdate();
        		degerAl(tableview_ilangor);
        	}
        	
    	
    		
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    	
    

    }

    @FXML
    void btn_sil_click(ActionEvent event) {
    	
    	  sql="delete from ilan where ilanID=? ";
    	
    	try {
 
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1,txt_ilanid.getText().trim());
    		
    		Alert alert=new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("AGT Emlak");
        	alert.setHeaderText("Ýlaný silmek istediðinize emin misiniz?");
        	alert.setContentText("Ýlan üzerinde yapýlan deðiþiklikler geri alýnamaz.");
        	
        	ButtonType btn1=new ButtonType("Evet");
        	ButtonType btn2=new ButtonType("Hayýr",ButtonData.CANCEL_CLOSE);
        	
        	alert.getButtonTypes().setAll(btn1,btn2);
        	Optional<ButtonType> buton=alert.showAndWait();
        	if(buton.get()==btn1)
        	{
        		sorguIfadesi.executeUpdate();
        		degerAl(tableview_ilangor);
        	}
    		
    		
		} catch (Exception e) {
			
		}

    }

    @FXML
    void btn_temizle_click(ActionEvent event) {
    	
    	txt_ilanid.clear();
    	txt_ilanbaslik.clear();
    	txt_kategori.clear();
    	txt_tur.clear();
    	txt_sehir.clear();
    	txt_katsay.clear();
    	txt_bulkat.clear();
    	txt_odasay.clear();
    	txt_metrek.clear();
    	txt_fiyat.clear();
    	txta_adres.clear();
    	txta_aciklama.clear();
    	

    }

    @FXML
    void tableview_ilangor_mauseclick(MouseEvent event) {
    	
    	Ilan ilangor=new Ilan();
    	ilangor=(Ilan)tableview_ilangor.getItems().get(tableview_ilangor.getSelectionModel().getSelectedIndex());
    	
    	txt_ilanid.setText(String.valueOf(ilangor.getId()));
    	txt_ilanbaslik.setText(ilangor.getBaslik());
    	txt_kategori.setText(ilangor.getKategori());
    	txt_tur.setText(ilangor.getTur());
    	txt_sehir.setText(ilangor.getSehir());
    	txt_katsay.setText(String.valueOf(ilangor.getKatsay()));
    	txt_bulkat.setText(String.valueOf(ilangor.getBulkat()));
    	txt_odasay.setText(String.valueOf(ilangor.getOdasay()));
    	txt_metrek.setText(String.valueOf(ilangor.getMetrekare()));
    	txt_fiyat.setText(String.valueOf(ilangor.getFiyat()));
    	txta_adres.setText(ilangor.getAdres());
    	txta_aciklama.setText(ilangor.getAciklama());
    
    	
    	
    	

    }
    
  

    @FXML
    void initialize() {
    	
    	degerAl(tableview_ilangor);
       

    }

}
