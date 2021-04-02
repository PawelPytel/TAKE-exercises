/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Pawel Pytel
 */
@Named(value = "manageBean")
@ManagedBean
@RequestScoped
public class ManageBean {

    private int firstNumber;
    private int secondNumber;
    private int result;
    private LocalDateTime date;
    private ArrayList<Student> students;
    private LineChartModel model;

    /**
     * Creates a new instance of ManagedBean
     */
    public ManageBean() {
        students=new ArrayList<>();
        students.add(new Student("Jan", "Kowalski", 4.5));
        students.add(new Student("Jan", "Nowak", 4.0));
        students.add(new Student("Tomasz", "Kowalski", 3.5));
        students.add(new Student("Zbigniew", "Kowalski", 2.5));
        students.add(new Student("Zbigniew", "Kwiatkowski", 3.0));
        students.add(new Student("Testowy", "Student", 5.0));
        students.add(new Student("Kolejny", "Student", 3.5));
        
        model=new LineChartModel();
        
        LineChartSeries sinus=new LineChartSeries();
        sinus.setLabel("sin");
        LineChartSeries cosinus=new LineChartSeries();
        cosinus.setLabel("cos");
        
        for(int i=0; i<=360; i+=10){
            sinus.set(i, Math.sin(Math.toRadians(i)));
            cosinus.set(i,Math.cos(Math.toRadians(i)));
        }
        
        model.addSeries(sinus);
        model.addSeries(cosinus);
        model.setTitle("Chart");
        model.setZoom(true);
        model.setLegendPosition("e");
    }

    /**
     * @return the firstNumber
     */
    public int getFirstNumber() {
        return firstNumber;
    }

    /**
     * @param firstNumber the firstNumber to set
     */
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * @return the secondNumber
     */
    public int getSecondNumber() {
        return secondNumber;
    }

    /**
     * @param secondNumber the secondNumber to set
     */
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    
    public void calculate(){
        setResult(getFirstNumber()+getSecondNumber());
        setDate(LocalDateTime.now());
        
        FacesContext context=FacesContext.getCurrentInstance();
        String message=Integer.toString(getFirstNumber()) + " + " + Integer.toString(getSecondNumber()) + " = " + Integer.toString(getResult());
        context.addMessage("growl", new FacesMessage(message));
    }

    /**
     * @return the model
     */
    public LineChartModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(LineChartModel model) {
        this.model = model;
    }
    
}
