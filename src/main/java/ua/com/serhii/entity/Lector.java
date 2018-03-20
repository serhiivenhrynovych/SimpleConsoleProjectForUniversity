package ua.com.serhii.entity;

import org.springframework.stereotype.Component;
import ua.com.serhii.entity.helpingModels.Degree;

@Component
public class Lector extends BaseObject {
    private String firstName;
    private String lastName;
    private Double salary;
    private Boolean isHead;
    private Degree degree;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getHead() {
        return isHead;
    }

    public void setHead(Boolean head) {
        isHead = head;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}
