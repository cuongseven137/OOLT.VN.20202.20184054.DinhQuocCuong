package sample;

import algorithmg.City;
import algorithmg.TSP;
import ga.annealing.SimulatedAnnealing;
import ga.ant_colony.AntColonyOptimization;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public static String CITY_COLOR="#130f40";
    public static int CITY_RADIUS=5;
    public static int DELAY_TIME=500;

    @FXML
    private Button setDelay;
    @FXML
    private Slider speedSlider;
    @FXML
    private Button pauseButton;
    @FXML
    private ComboBox chooseAlgorithm;
    @FXML
    private Button ResetButton;
    @FXML
    private Button startButton;
    @FXML
    private TextField inputFile;
    @FXML
    private Button setInputFile;
    @FXML
    private TextField numberOfCityInputFile;
    @FXML
    public AnchorPane display;
    @FXML
    private ComboBox speedButton;
    TSP tsp;
    SimulatedAnnealing SA;
    AntColonyOptimization antColony;
    String nameOFAlgori;
    ArrayList<City>  cityList;
    SequentialTransition st=new SequentialTransition();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameOFAlgori="PSO";
        numberOfCityInputFile.setText("");
        inputFile.setText("C:\\Users\\Pro\\Downloads\\test.txt");
        List<Integer> speedList = new ArrayList<Integer>();
        speedList.add(50);
        speedList.add(100);
        speedList.add(200);
        speedList.add(500);
        ObservableList obSpeedList = FXCollections.observableList(speedList);
        speedButton.getItems().clear();
        speedButton.setItems(obSpeedList);

        List<String> AlogorithmList = new ArrayList<String>();
        AlogorithmList.add("PSO");
        AlogorithmList.add("ACO");
        AlogorithmList.add("SA");
        ObservableList obAlgorithmList = FXCollections.observableList(AlogorithmList);
        chooseAlgorithm.getItems().clear();
        chooseAlgorithm.setItems(obAlgorithmList);
        chooseAlgorithm.getSelectionModel().select(0);
    }
    public void startButtonOnAction(ActionEvent event){
        nameOFAlgori= (String) chooseAlgorithm.getSelectionModel().getSelectedItem();
        System.out.println(nameOFAlgori);
        switch(nameOFAlgori){
            case "PSO": st=tsp.PSOTranslateTrans(display);break;
            case "ACO": st= antColony.startAntOptimization(display);break;
            case "SA":  st=SA.SATranslateTrans(display);break;
        }
        st.play();
    }
    public void chooseAlgorithmOnAction(ActionEvent event){
        nameOFAlgori= (String) chooseAlgorithm.getSelectionModel().getSelectedItem();
        switch(nameOFAlgori){
            case "PSO":break;
            case "ACO":antColony= new AntColonyOptimization(display);break;
            case "SA":SA=new SimulatedAnnealing(display);break;
        }
    }
    public void speedSliderOnChange(){
        st.rateProperty().setValue(speedSlider.getValue());
    }
    public void pauseButtonOnAction(ActionEvent event){
        if(pauseButton.getText().equals("Pause")){
            st.pause();
            pauseButton.setText("Resume");
            pauseButton.setStyle("-fx-background-color: #55efc4");
        }else{
            st.play();
            pauseButton.setText("Pause");
            pauseButton.setStyle("-fx-background-color: #dcdde1");
        }
    }
    public void ResetButtonOnAction(){
        display.getChildren().clear();
    }
    public void setInputFileButtonOnAction(ActionEvent event){
        int x= Integer.parseInt(numberOfCityInputFile.getText());
        String location= inputFile.getText();
        getCityFromFile gcf=new getCityFromFile(x,location);
        this.tsp=gcf.returnTSP();
        this.tsp.initCityList();
       // display.getChildren()
        cityList=this.tsp.getCityList();
        for (int i=0;i<cityList.size();i++){
            Circle cirTemp= new Circle();
            cirTemp.setCenterX(tsp.XLocations[i]);
            cirTemp.setCenterY(tsp.YLocations[i]);
            cirTemp.setFill(Color.web(CITY_COLOR));
            cirTemp.setRadius(CITY_RADIUS);
            display.getChildren().add(cirTemp);
        }
    }
    public void setDelayOnAction(ActionEvent event){
        DELAY_TIME= (int) speedButton.getSelectionModel().getSelectedItem();
    }

}
