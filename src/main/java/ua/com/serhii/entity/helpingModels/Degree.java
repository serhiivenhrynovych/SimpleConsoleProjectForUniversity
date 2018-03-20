package ua.com.serhii.entity.helpingModels;

public enum Degree {
    ASSISTANT("Assistant"),
    ASSOCIATE("Associate"),
    PROFESSOR("Professor");

    private String name;

    public String getName() {
        return name;
    }

    Degree(String name) {
        this.name = name;
    }
}
