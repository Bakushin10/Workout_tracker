package application;



import java.time.LocalDate;
import javafx.scene.control.TextArea;

public class WorkOutDetails{
	
	private LocalDate date;
	private TextArea memo = new TextArea();
	private String workout = new String();
	
	public WorkOutDetails(){
		
	}

	public WorkOutDetails(LocalDate date, String workout, TextArea memo){
		this.date=date;
		this.workout=workout;
		this.memo=memo;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TextArea getMemo() {
		return memo;
	}

	public void setMemo(TextArea memo) {
		this.memo = memo;
	}

	public String getWorkout() {
		return workout;
	}

	public void setWorkout(String workout) {
		this.workout = workout;
	}
	
}//end of WorkOutDetails
