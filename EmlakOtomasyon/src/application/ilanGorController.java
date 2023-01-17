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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ilanGorController {
	public ilanGorController()
	{
		baglanti=VeritabaniUtil.Baglan();
	}


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anhor_ilangor;

    @FXML
    private Button btn_cikis;
    
    @FXML
    private Button btn_ara;
    
    @FXML
    private Button btn_temizle;
    
    @FXML
    private RadioButton radio_artan;

    @FXML
    private RadioButton radio_azalan;

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
    private ToggleButton tog_fiyat;

    @FXML
    private ToggleButton tog_kategori;

    @FXML
    private ToggleButton tog_odasay;

    @FXML
    private ToggleButton tog_sehir;

    @FXML
    private ToggleButton tog_tur;

    @FXML
    private TextField txt_ara;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    public void degerAl(TableView tablo, String sql)
    {
    	
    	ObservableList<Ilan>ilanListe=FXCollections.observableArrayList();
    	try {
			
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		
    		while(getirilen.next())
    		{
    			ilanListe.add(new Ilan(getirilen.getInt("ilanid"),getirilen.getString("ilanbaslik"),getirilen.getString("kategori"),getirilen.getString("tur"),getirilen.getString("sehir"),getirilen.getInt("katsayi"),getirilen.getInt("bulkat"),getirilen.getInt("odasayi"),getirilen.getInt("metrekare"),getirilen.getDouble("fiyat"),getirilen.getString("adres"),getirilen.getString("aciklama")));
    			
    		}
    			
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
    public void degerGetir(TableView tablo)
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
    void btn_ara_click(ActionEvent event) {
    	
    	try {
			
				if(tog_tur.isSelected())
				{
					sql= "select * from ilan where tur like '%" + txt_ara.getText() + "%' order by tur ASC";
					degerAl(tableview_ilangor,sql);
					
				}
				else if(tog_kategori.isSelected())
				{
					sql= "select * from ilan where kategori like '%" + txt_ara.getText() + "%' order by kategori ASC";
					degerAl(tableview_ilangor,sql);
				}
				else if(tog_fiyat.isSelected())
				{
					sql="select * from ilan where fiyat>="+ txt_ara.getText();
					degerAl(tableview_ilangor,sql);	
					
					if(radio_artan.isSelected())
					{
						sql="select*from ilan order by fiyat asc";
						degerAl(tableview_ilangor,sql);	
						
					}
					else if(radio_azalan.isSelected())
					{
						sql="select*from ilan order by fiyat desc";
						degerAl(tableview_ilangor,sql);	
					}
					
					
				}
				else if(tog_odasay.isSelected())
				{
					sql="select * from ilan where odasayi>" +txt_ara.getText();
					degerAl(tableview_ilangor,sql);
					
					if(radio_artan.isSelected())
					{
						sql="select*from ilan order by odasayi asc";
						degerAl(tableview_ilangor,sql);	
					}
					
					else if(radio_azalan.isSelected())
					{
						sql="select*from ilan order by odasayi desc";
						degerAl(tableview_ilangor,sql);	
					}
					
				}
				else if(tog_sehir.isSelected())
				{
					sql="select*from ilan where sehir like '%" + txt_ara.getText() + "%' order by tur ASC";
					degerAl(tableview_ilangor,sql);
				}
				
			
		} 
    	catch (Exception e) {
			// TODO: handle exception
		}

    }

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	
    	try
    	{
    		
           AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Emlak.fxml"));
    		
    		anhor_ilangor.getChildren().setAll(pane1);	
    	    
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    	

    }
    @FXML
    void btn_temizle_click(ActionEvent event) {
    	txt_ara.clear();
    	
    	degerGetir(tableview_ilangor);

    }

    @FXML
    void tableview_ilangor_mauseclick(MouseEvent event) {

    }

    @FXML
    void tog_fiyat_click(ActionEvent event) {

    }

    @FXML
    void tog_kategori_click(ActionEvent event) {

    }

    @FXML
    void tog_odasay_click(ActionEvent event) {

    }

    @FXML
    void tog_sehir_click(ActionEvent event) {

    }

    @FXML
    void tog_tur_click(ActionEvent event) {

    }
    
    @FXML
    void radio_artan_click(ActionEvent event) {

    }

    @FXML
    void radio_azalan_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
    	sql="select*from ilan";
    	degerAl(tableview_ilangor,sql);
    	
    	ToggleGroup grup=new ToggleGroup();
    	radio_azalan.setToggleGroup(grup);
    	radio_artan.setToggleGroup(grup);
    	
    	ToggleGroup grup1=new ToggleGroup();
    	tog_tur.setToggleGroup(grup1);
    	tog_fiyat.setToggleGroup(grup1);
    	tog_sehir.setToggleGroup(grup1);
    	tog_kategori.setToggleGroup(grup1);
    	tog_odasay.setToggleGroup(grup1);


    	
    	
    	
        
    }

}
