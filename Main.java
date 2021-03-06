package application;
	

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/*
 *				 ---------     Things to do   ---------	
 *
 *  x1) develop Update Workout v
 * 	2) display updated info on Details-> see detail info
 * 	3) Edit and delete info
 * 	4) Edit graph lines
 * 	5) serialization 
 * 
 *  6) when a user clicks corner x to exit, make sure to have a same function as exiting from cancel button
 * 
 * 
 * 
 */

public class Main extends Application implements java.io.Serializable{

	static ArrayList<Person> list  = new ArrayList<Person>();
	static final TableView table = new TableView();
	static int removeArray=0;
	static int listSize=0;
	static int firstTimeVisit=0;
	
	private String fileName = "D:\\Person.bin";
	private String numberName = "D:\\Number.bin";
	private int sum;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public ArrayList<Person> getList() {
		return list;
	}

	public void setList(ArrayList<Person> list) {
		this.list = list;
	}

	public void start(Stage primaryStage) {
		
		
		try {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Ooops, there was an error!");
			
			try{
				Serialization se = new Serialization();
				se.readNumber();
				se.SerializationRead();
				se.writeNumber();
				Main.table.setItems(Main.getPerson());

				
			}catch(Exception e){
				alert.setContentText("An Error - "+e.getMessage());
				alert.showAndWait();
				
			}
			
			Stage window = primaryStage;
			window.setOnCloseRequest(e-> mainCloseMethod());
			BorderPane bordepane = new BorderPane();
			
			final NumberAxis xAxis = new NumberAxis();
			final NumberAxis yAxis = new NumberAxis();
			xAxis.setLabel("Number of Week");
			yAxis.setLabel("Weight ( lbs)");
			LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
			lineChart.setTitle("JUST DO IT by Shia Labeouf");
			
			Scene scene = new Scene(bordepane, 300, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			///
			MenuBar menuBar = new MenuBar();
			menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
			Menu newPerson = new Menu("New");
			MenuItem getCreateNewPerson = new MenuItem("Create New Person");
			newPerson.getItems().addAll(getCreateNewPerson);
			menuBar.getMenus().addAll(newPerson);
			
			TableColumn<Person,String> firstname = new TableColumn<Person, String>("firstName");
			firstname.setMinWidth(40);
			firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		        
			TableColumn<Person,String> lastname = new TableColumn<Person, String>("lastName");
			lastname.setMinWidth(40);
			lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));

			TableRow<Person> row = new TableRow<>();
			
			table.getColumns().add(firstname);
			table.getColumns().add(lastname);

			
			bordepane.setLeft(table);
			bordepane.setTop(menuBar);
			
			//Action listener here
			newPerson.setOnAction(e->getNewPerson());
			
			table.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent mouseEvent) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Ooops, there was an error!");
					
					if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
						if (mouseEvent.getClickCount() == 2) {
						
							try{
								@SuppressWarnings("rawtypes")
								TablePosition focusedCell = table.getFocusModel().getFocusedCell();
								int row = focusedCell.getRow();
								System.out.println("Double clicked. a is "+row);
								personalInfo personalinfo = new personalInfo(row);
								
							}catch(Exception e){
								alert.setContentText("Error messsage : No contents to show\n "+e.getMessage());
								alert.showAndWait();
							}
						}
					}
				}
			});
			
			scene.setFill(Color.BLACK);//snow??
			window.setScene(scene);
			window.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void mainCloseMethod(){
		System.out.println("closing time");
		//Serialization se = new Serialization();
		 //se.SerializationWrite();
	}

	static public ObservableList<Person> getPerson(){
		
		ObservableList<Person> persons  = FXCollections.observableArrayList();
		
		persons.removeAll(persons);//remove all pre-existing persons and add new elements every time sll over again
		
		//System.out.println("listsize = "+listSize);
		for(int i=0;i<listSize;i++){
			persons.add(new Person(list.get(i).getFirstName(),list.get(i).getLastName()));
		}
		return persons;
	}

	private void getNewPerson() {

		if(removeArray > 0){
			list.remove(list.size()-1);
			removeArray=0;
		}
		 	Person person = new Person();
		 	personalInfo p = new personalInfo();
		 	p.userInputMenu();
		 	list.add(person);
		 	listSize=list.size();
		}//end of getnewPerson

}
