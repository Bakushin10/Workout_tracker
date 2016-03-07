package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class personalInfo extends Main{

private Label initialWeightLabel = new Label("Inicial Weight(lbs)");
private Label goalWeightLabel = new Label("Ideal Weight(lbs)");
private Label goalWeekLabel = new Label("Week in/Goal Week");
private Label startingDate = new Label("Account Created");
private int rowCounter;
private static int chestInt=1;
private static int shoulderInt=1;
private static int backInt=1;
private static int bicepint=1;
private static int tricepInt=1;
private static int legsInt=1;
private static int absInt=1;
private DatePicker workoutDatePicker;
private LocalDate workoutlocalDate;
Label firstnameLabel= new Label("First Name");
Label lastnameLabel = new Label("Last Name");

TextField getFirstText = new TextField();
TextField getLastText = new TextField();
TextField getInitialWeightText = new TextField();
TextField getGoalWeightText = new TextField();
TextField getGoalWeekText = new TextField();
private DatePicker checkInDatePicker;
private String pattern = "yyyy-MM-dd";
Button submitButton = new Button("Submit");
Button cancelButtom = new Button("Cancel");
private int tableActivate=0;
Serialization se = new Serialization();
public personalInfo(){

}

public personalInfo(int row){

    Stage window2 = new Stage();
    window2.setTitle(list.get(row).getFirstName()+"'s Info");
    rowCounter = row;

    if(list.get(row).getXaxisCounter()==0){ //for CurrentWeight first time
        list.get(row).setCurrentWeight(list.get(row).getInitialWeight());
    }

    Label initialWeightLabelToShow = new Label(String.valueOf(list.get(row).getInitialWeight()));
    Label goalWeightLabelToShow = new Label(String.valueOf(list.get(row).getGoalWeight()));
    Label goalWeekLabelToShow = new Label(String.valueOf(list.get(row).getXaxisCounter()+1)+
            "/"+String.valueOf(list.get(row).getGoalweek()));
    Label startingDateToShow = new Label(String.valueOf(list.get(row).getLocalDate()));
    Label currentWight = new Label("Current Weight");
    Label currentWightToShow = new Label(String.valueOf(list.get(row).getCurrentWeight()));

    Label growthRate = new Label("Growth Rate");
    Label growthRateToShow = new Label();

    Label idealGrowthWught = new Label("Ideal Growth Rate");
    Label idealGrowthWughtToShow = new Label();


    //menu bar here
    MenuBar menuBar = new MenuBar();
    //menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
    Menu updateMenu = new Menu("Update");
    Menu detailMenu = new Menu("Details");
    Menu settingMenu = new Menu("Setting");
    MenuItem updateWeightMenuItem = new MenuItem("Update Weight/Week");
    MenuItem updateWorkoutMenuItem = new MenuItem("Update Workout");
    MenuItem detailMenuItem = new MenuItem("See Detail Info");
    MenuItem settingMenuItem = new MenuItem("Turn on/off IGLL");
    updateMenu.getItems().addAll(updateWeightMenuItem,updateWorkoutMenuItem);
    detailMenu.getItems().addAll(detailMenuItem);
    settingMenu.getItems().addAll(settingMenuItem);
    menuBar.getMenus().addAll(updateMenu,detailMenu,settingMenu);


    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);

    Text text = new Text(list.get(row).getFirstName()+" "+list.get(row).getLastName());
    text.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 45));

    //set Font
    initialWeightLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    goalWeightLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    goalWeekLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    startingDate.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    startingDateToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    currentWight.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    growthRate.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    idealGrowthWught.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    initialWeightLabelToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    goalWeightLabelToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    goalWeekLabelToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    currentWightToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    growthRateToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    idealGrowthWughtToShow.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));

    //Text
    grid.add(text, 0, 1, 2, 1);

    //menuBar 
    grid.add(menuBar, 0,0,1, 1);

    //chart
    getUpdated(0,0);
    grid.add(list.get(row).getLineChart(), 0, 2);

    //Label
    grid.add(startingDate, 0, 3);
    grid.add(initialWeightLabel, 0, 4);
    grid.add(currentWight, 0, 5);
    grid.add(goalWeightLabel, 0, 6);
    grid.add(goalWeekLabel, 0, 7);
    grid.add(idealGrowthWught, 0, 8);
    grid.add(growthRate, 0, 9);

    //user info 
    grid.add(startingDateToShow, 1, 3);
    grid.add(initialWeightLabelToShow, 1, 4);
    grid.add(currentWightToShow, 1, 5);
    grid.add(goalWeightLabelToShow, 1, 6);
    grid.add(goalWeekLabelToShow, 1, 7);
    grid.add(idealGrowthWughtToShow, 1, 8);
    grid.add(growthRateToShow, 1, 9);

    //grid.add(cancelButtom, 1, 8);
    Scene scene = new Scene(grid, 620, 710);

    //action listener here  
    updateWorkoutMenuItem.setOnAction(e-> updateWorkoutInfo());
    updateWeightMenuItem.setOnAction(e->updateWeightInfo(row));
    settingMenuItem.setOnAction(e->turnOffILL());
    detailMenuItem.setOnAction(e->viewDetail());
    scene.setFill(Color.BLACK);//snow??
    window2.setScene(scene);
    window2.show();

}//end of personalInfo

public void viewDetail(){

    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    BorderPane bordepane = new BorderPane();
    Scene scene = new Scene(bordepane, 450, 600);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

    TableColumn<WorkOutDetails,LocalDate> date = new TableColumn<WorkOutDetails, LocalDate>("date");
    date.setMinWidth(40);
    date.setCellValueFactory(new PropertyValueFactory<>("date"));

    TableColumn<WorkOutDetails,String> workout = new TableColumn<WorkOutDetails, String>("workout");
    workout.setMinWidth(40);
    workout.setCellValueFactory(new PropertyValueFactory<>("workout"));

    TableColumn<WorkOutDetails,TextArea> memo = new TableColumn<WorkOutDetails, TextArea>("memo");
    memo.setMinWidth(290);
    memo.setCellValueFactory(new PropertyValueFactory<>("memo"));

    TableRow<WorkOutDetails> row = new TableRow<>();

    if(firstTimeVisit == 0){
        Person.workOutTable.getColumns().add(date);
        Person.workOutTable.getColumns().add(workout);
        Person.workOutTable.getColumns().add(memo);
        firstTimeVisit=1;
    }
    list.get(rowCounter).workOutTable.setItems(getWorkOutDetails());
    //.setItems(getWorkOutDetails());
    bordepane.setCenter(Person.workOutTable);
    window.setScene(scene);
    window.show();
}

public void updateWorkoutInfo(){

    //set values back to 1
    chestInt=1;
    shoulderInt=1;
    backInt=1;
    bicepint=1;
    tricepInt=1;
    legsInt=1;
    absInt=1;

    Stage window2 = new Stage();
    window2.initModality(Modality.APPLICATION_MODAL);
    window2.setTitle("Update "+list.get(rowCounter).getFirstName()+"'s Info");

    GridPane grid = new GridPane();
    VBox vbchecks  = new VBox();
    HBox hbox = new HBox();
    Button submitButtomWI = new Button("Submit");
    Button cancelButtonWI = new Button("Cancel");
    Label workOutLabel = new Label("How Was Your Workout Today?");
    CheckBox Chest = new CheckBox("Chest");
    CheckBox shoulder = new CheckBox("Shoulder");
    CheckBox Back = new CheckBox("Back");
    CheckBox Biceps = new CheckBox("Biceps");
    CheckBox Triceps = new CheckBox("Triceps");
    CheckBox Legs = new CheckBox("Legs");
    CheckBox Abs = new CheckBox("Abs");
    TextArea memo = new TextArea ();

    workOutLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 30));

    workoutDatePicker = new DatePicker();
    workoutDatePicker.setValue(LocalDate.now());

    memo.setPromptText("Any tips about Workouts...");
    vbchecks.setSpacing(10);
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);

    vbchecks.getChildren().addAll(Chest,shoulder,Back,Biceps,Triceps,Legs,Abs);
    hbox.getChildren().addAll(submitButtomWI,cancelButtonWI);
    grid.add(workOutLabel, 0, 1);
    grid.add(workoutDatePicker, 0, 4);
    grid.add(vbchecks, 0, 5);
    grid.add(memo, 0, 6);
    grid.add(hbox, 0, 7);
    Scene scene = new Scene(grid, 560, 650);
    scene.setFill(Color.BLACK);//snow??
    window2.setScene(scene);
    window2.show();

    //action listeners here
    Chest.setOnAction(e->chestMethod(chestInt));
    shoulder.setOnAction(e->shoulderMethod(shoulderInt));
    Back.setOnAction(e->BackMethod(backInt));
    Biceps.setOnAction(e->BicepsMethod(bicepint));
    Triceps.setOnAction(e->TricepsMethod(tricepInt));
    Legs.setOnAction(e->LegsMethod(legsInt));
    Abs.setOnAction(e->AbsMethod(absInt));

    cancelButtonWI.setOnAction(e->cancelMethod(window2));
    submitButtomWI.setOnAction(e->submitWorkoutDetails(memo,window2,chestInt,shoulderInt,backInt,bicepint,tricepInt,legsInt,absInt));

}//end of updatePersonalInfo
public void userInputMenu(){
    Stage window2 = new Stage();
    window2.initModality(Modality.APPLICATION_MODAL);
    window2.setTitle("New Person");
    window2.setOnCloseRequest(e->cancelThis(window2));
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    HBox hbox = new HBox();
    hbox.getChildren().addAll(submitButton,cancelButtom);

    //date picker
    Label startinglabel = new Label("Starting Date:");
    checkInDatePicker = new DatePicker();
    checkInDatePicker.setValue(LocalDate.now());
    StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
      checkInDatePicker.setConverter(converter);
      checkInDatePicker.setPromptText(pattern.toLowerCase());

    //text
    Text text = new Text("Create New Account!");
    text.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 30));
    firstnameLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 15));
    lastnameLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 15));
    initialWeightLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 15));
    goalWeightLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 15));
    goalWeekLabel.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 15));

    //Text
    grid.add(text, 0, 0, 2, 1);

    //Label
    grid.add(firstnameLabel, 0, 3);
    grid.add(lastnameLabel, 0, 4);
    grid.add(initialWeightLabel, 0, 5);
    grid.add(goalWeightLabel, 0, 6);
    grid.add(goalWeekLabel, 0, 7);
    grid.add(startinglabel, 0, 8);

    //textfield
    grid.add(getFirstText, 1, 3);
    grid.add(getLastText, 1, 4);
    grid.add(getInitialWeightText, 1, 5);
    grid.add(getGoalWeightText, 1, 6);
    grid.add(getGoalWeekText, 1, 7);
    grid.add(checkInDatePicker, 1, 8);

    //button
    grid.add(hbox, 0, 9);

    Scene scene = new Scene(grid, 400, 400);
    scene.setFill(Color.BLACK);//snow??
    window2.setScene(scene);
    window2.show();

    //action listener here 
    submitButton.setOnAction(e->submitThis(window2));
    cancelButtom.setOnAction(e->cancelThis(window2));   
}//end of userInputMenu

private void cancelThis(Stage window2){
    Main.removeArray++;
    window2.close();
}

private void submitThis(Stage window2){

    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Dialog");
    alert.setHeaderText("Ooops, there was an error!");

    try {
        list.get((list.size()-1)).setFirstName(getFirstText.getText()) ; ;
        list.get((list.size()-1)).setLastName(getLastText.getText()) ; ;
        list.get((list.size()-1)).setInitialWeight(Double.parseDouble(getInitialWeightText.getText()));
        list.get((list.size()-1)).setGoalWeight((Double.parseDouble(getGoalWeightText.getText())));
        list.get((list.size()-1)).setGoalweek(((Double.parseDouble(getGoalWeekText.getText()))));;
        list.get((list.size()-1)).setLocalDate(checkInDatePicker.getValue());
        window2.close();
        tableActivate=1;//checks if all the conditions are fine for inputs

        se.SerializationWrite(0,0);
    } catch (Exception e) {
        alert.setContentText("Invalid Input Detected\nError - "+e.getMessage());
        alert.showAndWait();
        Main.removeArray++;
        getFirstText.clear();
        getLastText.clear();
        getInitialWeightText.clear();
        getGoalWeightText.clear();
        getGoalWeekText.clear();
        window2.close();
    }

    if(tableActivate == 1 ){
        Main.table.setItems(Main.getPerson());

        tableActivate=0;
    }
}


private void chestMethod(int a1) {
    chestInt=a1+1;
}
private void shoulderMethod(int a2) {
    shoulderInt=a2+1;
}
private void BackMethod(int a3) {
    backInt =a3+1;
}
private void BicepsMethod(int a4) {
    bicepint=a4+1;
}
private void TricepsMethod(int a5) {
    tricepInt=a5+1;
}
private void LegsMethod(int a6){
    legsInt=a6+1;
}
private void AbsMethod(int a7){
    absInt=a7+1;
}

private void submitWorkoutDetails(TextArea memo,Stage window2 ,int chestInt, int shoulderInt, int backInt, int bicepint
        ,int tricepInt, int legsInt, int absInt){
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Dialog");
    alert.setHeaderText("Ooops, there was an error!");
    String workout = "";
    int tableCount;


    try {

        if (chestInt % 2 == 0) {
            workout = workout+ "Chest\n";
        }
        if (shoulderInt % 2 == 0) {
            workout = workout+ "Shoulder\n";
        }
        if (backInt % 2 == 0) {
            workout = workout+ "Back\n";
        }
        if (bicepint % 2 == 0) {
            workout = workout+ "Bicep\n";
        }
        if (tricepInt % 2 == 0) {
            workout = workout+ "Tricep\n";
        }
        if (legsInt % 2 == 0) {
            workout = workout+ "Legs\n";
        }
        if (absInt % 2 == 0) {
            workout = workout+ "Abs\n";
        }// end of if


        WorkOutDetails wod = new WorkOutDetails();
        workoutlocalDate = workoutDatePicker.getValue();


        list.get(rowCounter).workOutList.add(wod);
        //this guy man
        list.get(rowCounter).workOutList.get(list.get(rowCounter).getWorkoutListCounter()).setWorkout(workout);
        list.get(rowCounter).workOutList.get(list.get(rowCounter).getWorkoutListCounter()).setDate(workoutlocalDate);
        list.get(rowCounter).workOutList.get(list.get(rowCounter).getWorkoutListCounter()).setMemo(memo);

        list.get(rowCounter).setWorkoutListCounter((list.get(rowCounter).getWorkoutListCounter()+1));


        tableCount = list.get(rowCounter).getTableCounter()+1;//increment tableCount
        list.get(rowCounter).setTableCounter(tableCount);
        window2.close();

    } catch (Exception e) {
        alert.setContentText("An Error - "+e.getMessage());
        alert.showAndWait();
        window2.close();
    }

}//end of submitWorkoutDetails

public ObservableList<WorkOutDetails> getWorkOutDetails(){

    ObservableList<WorkOutDetails> workoutDetails  = FXCollections.observableArrayList();
    workoutDetails.removeAll(workoutDetails);//remove all previous data and add new elements every time 
    //System.out.println("table method "+list.get(rowCounter).getTableCounter());

    for(int i=0;i<list.get(rowCounter).getTableCounter();i++){
        workoutDetails.add(new WorkOutDetails(list.get(rowCounter).workOutList.get(i).getDate(),
                                            list.get(rowCounter).workOutList.get(i).getWorkout(),
                                            list.get(rowCounter). workOutList.get(i).getMemo()));
    }
    return workoutDetails;

}//end of workoutDetails

void updateWeightInfo(int row){

    int weightEdit=0;
    int tempXaxis=list.get(row).getXaxisCounter();
    int edit = 1;
    //tempXaxis++;
    //list.get(rowCounter).setXaxisCounter(tempXaxis);

    Stage window2 = new Stage();
    window2.initModality(Modality.APPLICATION_MODAL);
    window2.setTitle("Update "+list.get(row).getFirstName()+"'s Weight");

    Button submitButtonForWeight = new Button("Submit");
    Button cancelButton = new Button("Cancel");
    Label addWeight1 = new Label(list.get(row).getFirstName()+", "+"ready to Add the Weight of");
    Label addWeight2 = new Label("      Week "+(tempXaxis+1));
    Label addWeight3 = new Label("Enter Weight(lbs) ");
    TextField addWeightText = new TextField();
    HBox hbox = new HBox();
    hbox.getChildren().addAll(submitButtonForWeight,cancelButton);
    addWeight1.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));
    addWeight2.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 32));
    addWeight3.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 16));

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);

    grid.add(addWeight1, 0, 1);
    grid.add(addWeight2, 0, 2);
    grid.add(addWeight3, 0, 6);
    grid.add(addWeightText, 1, 6);
    grid.add(hbox, 0, 8);

    Scene scene = new Scene(grid, 550, 300);
    scene.setFill(Color.BLACK);//snow??
    window2.setScene(scene);
    window2.show();

    //Action listers here
    submitButtonForWeight.setOnAction(e->submitWeight(addWeightText,window2,tempXaxis,weightEdit, edit));
    cancelButton.setOnAction(e->cancelMethod(window2));
}

private void submitWeight(TextField addWeightText,Stage window2,int tempXaxis,int weightEdit, int edit){

    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Dialog");
    alert.setHeaderText("Ooops, there was an error!");
    alert.setContentText("Invalid Input Detected");

    try{

        list.get(rowCounter).setCurrentWeight(Double.parseDouble(addWeightText.getText()));

        //increment Xaxis here
        tempXaxis++;
        list.get(rowCounter).setXaxisCounter(tempXaxis);
        weightEdit=1;
        getUpdated(weightEdit, edit);
    }catch(Exception e){
        alert.showAndWait();
    }

    window2.close();
}

@SuppressWarnings("unchecked")
private void turnOffILL(){
    Stage window2 = new Stage();
    window2.initModality(Modality.APPLICATION_MODAL);
    window2.setTitle("IGLL");

    Button turnOnButton = new Button("turn on");
    Button turnOffButton = new Button("turn off");
    Label label = new Label("Turning on/off Ideal Growth Linear Line(IGLL)");
    label.setFont(Font.font(java.awt.Font.DIALOG_INPUT, 15));
    HBox hbox = new HBox();
    hbox.getChildren().addAll(turnOnButton,turnOffButton);

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.add(label, 0, 2);
    grid.add(hbox, 0, 8);

    Scene scene = new Scene(grid, 520, 200);
    scene.setFill(Color.BLACK);//snow??
    window2.setScene(scene);
    window2.show();

    turnOnButton.setOnAction(e->turnOnMethod(window2));
    turnOffButton.setOnAction(e->turnOffMethod(window2));

}
private void turnOnMethod(Stage window2){
    int weightEdit=0;
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Dialog");
    alert.setHeaderText("Ooops, there was an error!");
    alert.setContentText("IGLL is already on");

    if(list.get(rowCounter).getTurnOn()==0 && list.get(rowCounter).getTurnOff()==1){
        list.get(rowCounter).setTurnOn(1);
        list.get(rowCounter).setTurnOff(0);
        window2.close();
        getUpdated(weightEdit,0);
    }else{
        alert.showAndWait();
    }
}

private void turnOffMethod(Stage window2){

    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Error Dialog");
    alert.setHeaderText("Ooops, there was an error!");
    alert.setContentText("IGLL is already off");

    if(list.get(rowCounter).getTurnOn()==1 && list.get(rowCounter).getTurnOff()==0){
        list.get(rowCounter).setTurnOn(0);
        list.get(rowCounter).setTurnOff(1);
        window2.close();
        getUpdated(0,0);
    }else{
        alert.showAndWait();
    }
}

private void cancelMethod(Stage window2){
    window2.close();
}

@SuppressWarnings("unchecked")
public void getUpdated(int weightEdit, int edit){

    int tempX=list.get(rowCounter).getXaxisCounter();
    if(list.get(rowCounter).getEditWeight() == 1)
    	tempX=0;
    
    
    //setting chart info
    list.get(rowCounter).getxAxis().setLabel("Number of Week");
    list.get(rowCounter).getyAxis().setLabel("Weight (lbs)");
    list.get(rowCounter).getXylinePerson().setName(list.get(rowCounter).getFirstName());
    list.get(rowCounter).getIdealLinearLine().setName("Ideal Growth Linear Line ");

    if(list.get(rowCounter).getXaxisCounter() == 0){
    	
        list.get(rowCounter).getXylinePerson().getData().add(
            new XYChart.Data<Number, Number>(list.get(rowCounter).getXaxisCounter(),
                    list.get(rowCounter).getInitialWeight()));
    }

if(weightEdit ==1){
	
	//list.get(rowCounter).setEditCounter(edit); //edit gets 1 or 0
	
	//Serialization s = new Serialization();
	//s.SerializationWrite(1,rowCounter);
	
    if(list.get(rowCounter).getXaxisCounter() >= 1 && list.get(rowCounter).getEditCounter() == 0){ //after the first time
        list.get(rowCounter).getXylinePerson().getData().add(
                new XYChart.Data<Number, Number>(list.get(rowCounter).getXaxisCounter(),
                        list.get(rowCounter).getCurrentWeight()));
       
    } 

}else{//ideal linear line

    //I want to be able to edit in run time 
    if(list.get(rowCounter).getXaxisCounter() == 0){
        list.get(rowCounter).getIdealLinearLine().getData().add(
                new XYChart.Data<Number, Number>(0,
                        list.get(rowCounter).getInitialWeight()));

        list.get(rowCounter).getIdealLinearLine().getData().add(
                new XYChart.Data<Number, Number>(list.get(rowCounter).getGoalweek(),
                        list.get(rowCounter).getGoalWeight()));
    }

    //turn off
    if((list.get(rowCounter).getTurnOn()==0 && list.get(rowCounter).getTurnOff()==1)
            && list.get(rowCounter).getFirstTimeCounter() != 0){


        list.get(rowCounter).getLineChart().getData().removeAll(list.get(rowCounter).getIdealLinearLine());
        list.get(rowCounter).setTurnOnfirstTime(0);
    }
    //turn on
    if((list.get(rowCounter).getTurnOn()==1 && list.get(rowCounter).getTurnOff()==0) 
            && list.get(rowCounter).getFirstTimeCounter() != 0){

        list.get(rowCounter).getIdealLinearLine().getData().add(
                new XYChart.Data<Number, Number>(0,
                        list.get(rowCounter).getInitialWeight()));

        list.get(rowCounter).getIdealLinearLine().getData().add(
                new XYChart.Data<Number, Number>(list.get(rowCounter).getGoalweek(),
                        list.get(rowCounter).getGoalWeight()));

        if(list.get(rowCounter).getTurnOnfirstTime()==0){
            list.get(rowCounter).getLineChart().getData().add(list.get(rowCounter).getIdealLinearLine());
            list.get(rowCounter).setTurnOnfirstTime(1);
        }

    }//end of if-turn on 

    //I guess this code only executes once to generate a chart for the first  time? 
    System.out.println("tempx = "+tempX);
    System.out.println("getfirsttimecounter  = "+ list.get(rowCounter).getFirstTimeCounter());
    if(tempX==0 && list.get(rowCounter).getFirstTimeCounter() == 0){
        list.get(rowCounter).getLineChart().getData().add(list.get(rowCounter).getIdealLinearLine());
        list.get(rowCounter).setTurnOnfirstTime(1);
        list.get(rowCounter).getLineChart().getData().add(list.get(rowCounter).getXylinePerson());
        list.get(rowCounter).setFirstTimeCounter(1);//to make this only works for the first time 
    }
        //list.get(rowCounter).lineChart.getData().removeAll(idealLinearLine);
    }//end od else
	}
}//end of getUpdated