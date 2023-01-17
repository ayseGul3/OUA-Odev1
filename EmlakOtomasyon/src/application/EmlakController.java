package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class EmlakController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor_ana;

    @FXML
    private AnchorPane anchor_ic;

    @FXML
    void initialize() {
    	
    	try
    	{
    		AnchorPane pane1=(AnchorPane)FXMLLoader.load(getClass().getResource("Giris.fxml"));
    		
    		anchor_ic.getChildren().setAll(pane1);
    		
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
       

    }

}
