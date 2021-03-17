package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtinserisci;

    @FXML
    private TextArea txtrisultato;

    @FXML
    void handleinserisci(ActionEvent event) {
    	String testo=txtinserisci.getText();
    	if(testo.length()==0) {
    		txtrisultato.setText("ERRORE: Inserire una parola!");
    		return;
    	}
    	
    	testo.toLowerCase();
		String[] parole = testo.split(" ");
		
    	for(String s:parole)
   			for(char c: s.toCharArray()) {
   				if(!Character.isLetter(c)) {
   					txtrisultato.setText("ERRORE: Inserire solo lettere!");
   					return;
   				}
    		}
    	
    	if(parole.length == 1) {
    		txtrisultato.setText(model.translateWord(parole[0]));
    	}
    	else if(parole.length == 2) {
    		model.addWord(parole[0], parole[1]);
    	}
    	else {
    		txtrisultato.setText("ERRORE; Inserire massimo due parole!");
    		return;
    	}
    	
    }
    
    @FXML
    void handleclear(ActionEvent event) {

    }

    public void setModel(AlienDictionary model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtinserisci != null : "fx:id=\"txtinserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtrisultato != null : "fx:id=\"txtrisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
