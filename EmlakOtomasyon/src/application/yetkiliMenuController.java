package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class yetkiliMenuController {

	@FXML
	private AnchorPane anchor_menu;
	   
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_ilanduzenle;

    @FXML
    private Button btn_kullistele;

    @FXML
    void btn_cikis_click(ActionEvent event) {
    	
    	try
    	{
    		
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Emlak.fxml"));
    		
    		anchor_menu.getChildren().setAll(pane1);	
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void btn_ilanduzenle_click(ActionEvent event) {
    	
    	try
    	{
    		Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("ilanDuzenle.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.show();
    		
			Stage stage1 = (Stage) btn_ilanduzenle.getScene().getWindow();
    	    stage1.close();
    		
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    

    }

    @FXML
    void btn_kullistele_click(ActionEvent event) {
    	

    	try
    	{
    		Stage stage=new Stage();
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("kullaniciGor.fxml"));
    		
    		Scene scene1=new Scene(pane1);
    		stage.setScene(scene1);
    		stage.setTitle("AGT Emlak");
    		stage.show();
    		
    		Stage stage1 = (Stage) btn_kullistele.getScene().getWindow();
    	    stage1.close();
    		
    		
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
