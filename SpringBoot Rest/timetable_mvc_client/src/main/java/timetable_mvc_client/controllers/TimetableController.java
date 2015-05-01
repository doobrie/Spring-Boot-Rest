package timetable_mvc_client.controllers;

import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import timetable_mvc_client.model.Timetable;
import timetable_mvc_client.model.TimetableClass;

@Controller
public class TimetableController {

    @RequestMapping("/timetable")
    public String showFullTimetable(Model model){
        model.addAttribute("timetable", this.getFullTimetable());
        return "full_timetable";
    }

    private Timetable getFullTimetable() {
        RestTemplate restTemplate = new RestTemplate();
        TimetableClass[] classes = restTemplate.getForObject( 
                "http://localhost:8080/timetable", 
                TimetableClass[].class);
        Timetable fullTimetable = new Timetable();
        fullTimetable.setClasses(Arrays.asList(classes));
        return fullTimetable;
    }
}