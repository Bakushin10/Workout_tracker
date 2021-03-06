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
import java.time.LocalDate;

import javafx.scene.control.TableView;

public class Serialization implements java.io.Serializable{
	
	
	private String workoutfileName = "D:\\workout.bin";
	private String numberName = "D:\\workoutNumber.bin";
	private int sum;
	
	public Serialization(){
		
	}
	
	void SerializationRead() throws FileNotFoundException{
		
		try {
			FileInputStream fi = new FileInputStream(workoutfileName);
			ObjectInputStream oi = new ObjectInputStream(fi);

			
			for (int i = 0; i < (sum-1); i++) {	
				Person person = (Person) oi.readObject();
				Main.list.add(person);
				System.out.println("SerializationRead");
			}
 
			//fi.close();
			fi.close();
			oi.close();
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
	}//end of serialization read 
	
	void SerializationWrite(int edit, int rowCounter){

		try {
			if(edit == 0){
			FileOutputStream fo = new FileOutputStream(workoutfileName); 
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			
			System.out.println(Main.list.size());
			
			for (int i = 0; i < Main.list.size(); i++) {
					Person p = new Person();
					oo.writeObject(Main.list.get(i));
					System.out.println("writing now ");
				}
			writeNumber();
			fo.close();
			oo.close();	
			}
			if(edit == 1){
				//temp values...
				TableView tempworkOutTable = Main.list.get(rowCounter).workOutTable;
				 String firstName = Main.list.get(rowCounter).getFirstName();
				 String lastName = Main.list.get(rowCounter).getLastName();
				 double initialWeight = Main.list.get(rowCounter).getInitialWeight();
				 double currentWeight = Main.list.get(rowCounter).getCurrentWeight();
				 int numberOfWeek = Main.list.get(rowCounter).getNumberOfWeek();
				 double diffrenceInWeight = Main.list.get(rowCounter).getDiffrenceInWeight();
				 double goalWeight = Main.list.get(rowCounter).getGoalWeight();
				 double Goalweek = Main.list.get(rowCounter).getGoalweek();
				 double[] growthRate = Main.list.get(rowCounter).getGrowthRate();
				 double[] idealGrowthRate = Main.list.get(rowCounter).getIdealGrowthRate();
				 int xaxisCounter=Main.list.get(rowCounter).getXaxisCounter();
				 int firstTimeCounter = Main.list.get(rowCounter).getFirstTimeCounter();
				 int turnOff = Main.list.get(rowCounter).getTurnOff();
				 int turnOn = Main.list.get(rowCounter).getTurnOn(); //first time is on 
				 int turnOnfirstTime = Main.list.get(rowCounter).getTurnOnfirstTime();
				 LocalDate localDate = Main.list.get(rowCounter).getLocalDate();
				 int workOutListSize = Main.list.get(rowCounter).getWorkOutListSize();//for work out list 
				 int workoutListCounter = Main.list.get(rowCounter).getWorkoutListCounter();
				 int editCounter = Main.list.get(rowCounter).getEditCounter();
				 int tableCounter = Main.list.get(rowCounter).getTableCounter() ;
				 
				Main.list.remove(rowCounter);
				Person person = new Person(); // create new person Class
				Main.list.add(person);
				putitBack(rowCounter,firstName,lastName,initialWeight,currentWeight,numberOfWeek,diffrenceInWeight,goalWeight,
						Goalweek,growthRate,idealGrowthRate,xaxisCounter,firstTimeCounter,turnOff,turnOn,turnOnfirstTime,localDate,
						workOutListSize,workoutListCounter,editCounter,tableCounter);	
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}//end of serialization write
	
	private void putitBack(int rowCounter,String firstName, String lastName,double initialWeight, double currentWeight, int numberOfWeek,
			double diffrenceInWeight, double goalWeight, double Goalweek , double[] growthRate, double[] idealGrowthRate,int xaxisCounter,
			int firstTimeCounter, int turnOff, int turnOn, int turnOnfirstTime, LocalDate localDate, int workOutListSize,
			int workoutListCounter, int editCounter,int tableCounter){
		
		Main.list.get(rowCounter).setFirstName(firstName);
		Main.list.get(rowCounter).setLastName(lastName);
		Main.list.get(rowCounter).setInitialWeight(initialWeight);
		Main.list.get(rowCounter).setCurrentWeight(currentWeight);
		Main.list.get(rowCounter).setNumberOfWeek(numberOfWeek);
		Main.list.get(rowCounter).setDiffrenceInWeight(diffrenceInWeight);
		Main.list.get(rowCounter).setGoalWeight(goalWeight);
		Main.list.get(rowCounter).setGoalweek(Goalweek);
		Main.list.get(rowCounter).setGrowthRate(growthRate);
		Main.list.get(rowCounter).setIdealGrowthRate(idealGrowthRate);
		Main.list.get(rowCounter).setXaxisCounter(xaxisCounter);
		Main.list.get(rowCounter).setWorkoutListCounter(workoutListCounter);
		Main.list.get(rowCounter).setEditCounter(editCounter);
		Main.list.get(rowCounter).setTableCounter(tableCounter);
		Main.list.get(rowCounter).setEditWeight(1);
		
		for(int i=0; i<(Main.list.get(rowCounter).getXaxisCounter());i++){
			//Main.list.get(rowCounter).setGrowthRate(idealGrowthRate[i]);
		}
		
	}
	
	void writeNumber() {
		
		//String fileName = "intData.dat";
		int sum = Main.list.size()+1;
		
		try {
			DataOutputStream instr = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(numberName)));
			instr.writeInt(sum);
			Main.listSize = sum-1;
			System.out.println("write number count = " + sum);
			instr.close();
		} catch (IOException iox) {
			System.out.println("Problem reading numberName file" + numberName);
		}
	}//end of write number
	
	void readNumber() {
		//String fileName = "C:\\intData.dat";

		try {
			DataInputStream instr = new DataInputStream(new BufferedInputStream(new FileInputStream(numberName)));

			sum = sum + instr.readInt();
			System.out.println("count : "+sum);
			instr.close();
		} catch (IOException iox) {
			System.out.println("Problem writing " + numberName);
		}
	}

}
