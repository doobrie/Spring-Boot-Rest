package timetable_mvc_client.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import timetable_mvc_client.model.TimetableClass;

@Controller
public class ClassController {
    @RequestMapping("/class")
    public String showCreateClassForm(Model model){
        return "new_class";
    }

    @RequestMapping(value="/class", method=RequestMethod.POST)
    public String createNewClass(TimetableClass newClass){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TimetableClass> response = 
                restTemplate.postForEntity(
                        "http://localhost:8080/timetable/event", 
                        newClass, TimetableClass.class);
        return "redirect:timetable";
    }
}