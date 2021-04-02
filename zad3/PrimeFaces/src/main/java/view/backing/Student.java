/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

/**
 *
 * @author Pawel Pytel
 */
public class Student {
    private String firstName;
    private String lastName;
    private Double gradesAverage;

    public Student(String firstName, String lastName, Double avg){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gradesAverage=avg;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gradesAverage
     */
    public Double getGradesAverage() {
        return gradesAverage;
    }

    /**
     * @param gradesAverage the gradesAverage to set
     */
    public void setGradesAverage(Double gradesAverage) {
        this.gradesAverage = gradesAverage;
    }
}
