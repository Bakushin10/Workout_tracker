package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.TableView;

public class Person extends Graphs implements Serializable{

//for work out details
ArrayList<WorkOutDetails> workOutList  = new ArrayList<WorkOutDetails>();

//
@SuppressWarnings("rawtypes")
static TableView workOutTable = new TableView();
private String firstName;
private String lastName;
private double initialWeight;
private double currentWeight;
private int numberOfWeek;
private double diffrenceInWeight;
private double goalWeight;
private double Goalweek;
private double[] growthRate;
private double[] idealGrowthRate;
private int xaxisCounter=0;
private int firstTimeCounter;
private int turnOff=0;
private int turnOn=1; //first time is on 
private int turnOnfirstTime=0;
private LocalDate localDate;
static int workOutListSize=0;//for work out list 
private int workoutListCounter=0;
private int editCounter=0;
private int tableCounter=0;
private int editWeight=0; ///delete if edit swapping it doesnt work out 

public Person(){

}

public Person(String firstName, String lastName) {
    this.firstName=firstName;
    this.lastName=lastName;
}
public int getEditWeight() {
	return editWeight;
}

public void setEditWeight(int editWeight) {
	this.editWeight = editWeight;
}

public int getEditCounter() {
	return editCounter;
}

public void setEditCounter(int editCounter) {
	this.editCounter = editCounter;
}
public ArrayList<WorkOutDetails> getWorkOutList() {
    return workOutList;
}

public void setWorkOutList(ArrayList<WorkOutDetails> workOutList) {
    this.workOutList = workOutList;
}

public static TableView getWorkOutTable() {
    return workOutTable;
}

public static void setWorkOutTable(TableView workOutTable) {
    Person.workOutTable = workOutTable;
}

public static int getWorkOutListSize() {
    return workOutListSize;
}

public static void setWorkOutListSize(int workOutListSize) {
    Person.workOutListSize = workOutListSize;
}

public int getTableCounter() {
    return tableCounter;
}

public void setTableCounter(int tableCounter) {
    this.tableCounter = tableCounter;
}

public int getTurnOff() {
    return turnOff;
}

public void setTurnOff(int turnOff) {
    this.turnOff = turnOff;
}

public int getTurnOn() {
    return turnOn;
}

public void setTurnOn(int turnOn) {
    this.turnOn = turnOn;
}

public int getFirstTimeCounter() {
    return firstTimeCounter;
}

public void setFirstTimeCounter(int firstTimeCounter) {
    this.firstTimeCounter = firstTimeCounter;
}

public LocalDate getLocalDate() {
    return localDate;
}

public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}


public String getLastName() {
    return lastName;
}


public void setLastName(String lastName) {
    this.lastName = lastName;
}


public double getInitialWeight() {
    return initialWeight;
}


public void setInitialWeight(double initialWeight) {
    this.initialWeight = initialWeight;
}


public double getCurrentWeight() {
    return currentWeight;
}


public void setCurrentWeight(double currentWeight) {
    this.currentWeight = currentWeight;
}


public int getNumberOfWeek() {
    return numberOfWeek;
}


public void setNumberOfWeek(int numberOfWeek) {
    this.numberOfWeek = numberOfWeek;
}


public double getDiffrenceInWeight() {
    return diffrenceInWeight;
}


public void setDiffrenceInWeight(double diffrenceInWeight) {
    this.diffrenceInWeight = diffrenceInWeight;
}


public double getGoalWeight() {
    return goalWeight;
}


public void setGoalWeight(double goalWeight) {
    this.goalWeight = goalWeight;
}


public double getGoalweek() {
    return Goalweek;
}


public void setGoalweek(double goalweek) {
    Goalweek = goalweek;
}

public double[] getGrowthRate() {
    return growthRate;
}

public void setGrowthRate(double[] growthRate) {
    this.growthRate = growthRate;
}

public double[] getIdealGrowthRate() {
    return idealGrowthRate;
}

public void setIdealGrowthRate(double[] idealGrowthRate) {
    this.idealGrowthRate = idealGrowthRate;
}

public int getXaxisCounter() {
    return xaxisCounter;
}

public void setXaxisCounter(int xaxisCounter) {
    this.xaxisCounter = xaxisCounter;
}

public int getTurnOnfirstTime() {
    return turnOnfirstTime;
}

public void setTurnOnfirstTime(int turnOnfirstTime) {
    this.turnOnfirstTime = turnOnfirstTime;
}
public int getWorkoutListCounter() {
    return workoutListCounter;
}

public void setWorkoutListCounter(int workoutListCounter) {
    this.workoutListCounter = workoutListCounter;
}
}