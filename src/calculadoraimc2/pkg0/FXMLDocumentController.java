/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraimc2.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daw
 */
public class FXMLDocumentController implements Initializable {
    Double altura;
    Double alturaCm;
    Double peso;
    Double imc;
    String alturaString=null;
    String pesoString=null;
    private Label label;
    @FXML
    private Label AlturaLabel;
    @FXML
    private Label PesoLabel;
    @FXML
    private TextField Estatura;
    @FXML
    private TextField Peso;
    @FXML
    private Label IMCLabel;
    @FXML
    private RadioButton Obesidad;
    @FXML
    private RadioButton SobrePreso;
    @FXML
    private RadioButton Normal;
    @FXML
    private RadioButton Delgadez;
    @FXML
    private Slider SlideAltura;
    @FXML
    private ScrollBar ScrollPeso;
    @FXML
    private Label ResultadoLabel;
    @FXML
    private ListView<String> DescripcionID;
    
    private void handleButtonAction(ActionEvent event) {
    }
     ObservableList<String> descipcionPeso=FXCollections.observableArrayList("Sufres es una enfermedad crónica de origen multifactorial \n prevenible, caracterizada por acumulación excesiva de grasa \n en el cuerpo.","Sufres sobrepeso causado probablemente por una alimentación abundantes \n y/o un estilo de vida sedentarios. ","Tu IMC es adecuado, enhorabuena","Su peso es demasiado bajo, su peso \n se encuentra por debajo de un valor saludable.");
    public void initialize(URL url, ResourceBundle rb) {
        DescripcionID.setItems(descipcionPeso);
    }    

    @FXML
    private void IntroducirAltura(ActionEvent event) {
    }

    @FXML
    private void IntroducirPeso(ActionEvent event) {
    }

    @FXML
    private void ActionObesidad(ActionEvent event) {
    }

    @FXML
    private void ActionSobrepeso(ActionEvent event) {
    }

    @FXML
    private void ActionNormal(ActionEvent event) {
    }

    @FXML
    private void ActionDelgadez(ActionEvent event) {
    }

    @FXML
    private void SlideDeAltura(MouseEvent event) {
        alturaString=String.valueOf(this.SlideAltura.getValue()).substring(0, 6);
        this.Estatura.setText(alturaString);
    }
     public void color(double color){
        if(color > 30 || color < 18.4){
            this.ResultadoLabel.setStyle("-fx-background-color: #fb0000 ; -fx-text-inner-color: #fbec00");
            
        }else if (color<29.9 && color>25){
            this.ResultadoLabel.setStyle("-fx-background-color: #fbec00 ; -fx-text-inner-color: #656565");
        }else{
         this.ResultadoLabel.setStyle("-fx-background-color: #48fb00 ; -fx-text-inner-color: #ffffff");
        }
    }

    @FXML
    private void ScrollDePeso(MouseEvent event) {
        pesoString=String.valueOf(this.ScrollPeso.getValue()).substring(0, 6);
        this.Peso.setText(pesoString);
         try{
            alturaCm = Double.parseDouble(alturaString);
        }catch(Exception e){
           this.Estatura.setText("Datos no validos");
           this.Estatura.setStyle("-fx-border-color: #fb0000 ; -fx-text-inner-color: #fb0000");
       } 
       altura=alturaCm/100;
       try{
       peso=Double.parseDouble(pesoString);
       }catch(Exception e){
           this.Peso.setText("Datos no validos");
           this.Peso.setStyle("-fx-border-color: #fb0000 ; -fx-text-inner-color: #fb0000");
       } 
       imc=peso/(Math.pow(altura, 2));
       color(imc);
       String iMc=""+imc;
       
      this.ResultadoLabel.setText(iMc.substring(0, 6));
        if (imc>30) {
       this.SobrePreso.setSelected(false);
       this.Normal.setSelected(false);
       this.Delgadez.setSelected(false);
            this.Obesidad.setSelected(true);
        DescripcionID.getSelectionModel().select(0);
        }
        if(imc<29.9 && imc>25){
             this.Obesidad.setSelected(false);
       this.Normal.setSelected(false);
       this.Delgadez.setSelected(false);
            this.SobrePreso.setSelected(true);
            DescripcionID.getSelectionModel().select(1);
          }
        if (imc<24.9 && imc>18.5) {
             this.Obesidad.setSelected(false);
       this.SobrePreso.setSelected(false);
       this.Delgadez.setSelected(false);
              this.Normal.setSelected(true);
              DescripcionID.getSelectionModel().select(2);
        }
        if(imc<18.5){
             this.Obesidad.setSelected(false);
       this.SobrePreso.setSelected(false);
       this.Normal.setSelected(false);
           this.Delgadez.setSelected(true);
           DescripcionID.getSelectionModel().select(3);
        }
       
    }

    @FXML
    private void SeleccionCurso(MouseDragEvent event) {
    }
    
}
