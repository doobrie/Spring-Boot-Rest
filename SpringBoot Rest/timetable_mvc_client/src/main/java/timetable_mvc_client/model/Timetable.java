package timetable_mvc_client.model;

import java.util.List;

public class Timetable {
    private List<TimetableClass> classes;

    public List<TimetableClass> getClasses() {
        return classes;
    }

    public void setClasses(List<TimetableClass> classes) {
        this.classes = classes;
    }
}