package hng2.stagetwotask;

import hng2.stagetwotask.entity.Person;

import java.time.LocalTime;

public class ApiResponse {

    private final Long id;
    private final String name;

    //private final String person;

    public ApiResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return name;
    }

    public String getTimeStamp(){
        return LocalTime.now().toString();
    }
}
