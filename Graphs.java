package application;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class Graphs {
	Label initialWeightLabel = new Label("Initial Weight(lbs)");
	Label goalWeightLabel = new Label("Ideal Weight(lbs)");
	Label goalWeekLabel = new Label("Goal Week");
	NumberAxis xAxis = new NumberAxis();
	NumberAxis yAxis = new NumberAxis();
	LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
	XYChart.Series<Number, Number> xylinePerson = new XYChart.Series<Number, Number>();
	XYChart.Series<Number, Number> idealLinearLine = new XYChart.Series<Number, Number>();
	
	public Label getInitialWeightLabel() {
	    return initialWeightLabel;
	}

	public void setInitialWeightLabel(Label initialWeightLabel) {
	    this.initialWeightLabel = initialWeightLabel;
	}

	public Label getGoalWeightLabel() {
	    return goalWeightLabel;
	}

	public void setGoalWeightLabel(Label goalWeightLabel) {
	    this.goalWeightLabel = goalWeightLabel;
	}

	public Label getGoalWeekLabel() {
	    return goalWeekLabel;
	}

	public void setGoalWeekLabel(Label goalWeekLabel) {
	    this.goalWeekLabel = goalWeekLabel;
	}

	public NumberAxis getxAxis() {
	    return xAxis;
	}

	public void setxAxis(NumberAxis xAxis) {
	    this.xAxis = xAxis;
	}

	public NumberAxis getyAxis() {
	    return yAxis;
	}

	public void setyAxis(NumberAxis yAxis) {
	    this.yAxis = yAxis;
	}

	public LineChart<Number, Number> getLineChart() {
	    return lineChart;
	}

	public void setLineChart(LineChart<Number, Number> lineChart) {
	    this.lineChart = lineChart;
	}

	public XYChart.Series<Number, Number> getXylinePerson() {
	    return xylinePerson;
	}

	public void setXylinePerson(XYChart.Series<Number, Number> xylinePerson) {
	    this.xylinePerson = xylinePerson;
	}

	public XYChart.Series<Number, Number> getIdealLinearLine() {
	    return idealLinearLine;
	}

	public void setIdealLinearLine(XYChart.Series<Number, Number> idealLinearLine) {
	    this.idealLinearLine = idealLinearLine;
	}

}
