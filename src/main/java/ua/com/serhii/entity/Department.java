package ua.com.serhii.entity;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Department extends BaseObject {

    private Set<Lector> lectors;

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }
}
