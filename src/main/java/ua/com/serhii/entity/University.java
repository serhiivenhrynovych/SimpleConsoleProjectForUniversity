package ua.com.serhii.entity;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class University extends BaseObject {

    private Set<Department> departments;

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
