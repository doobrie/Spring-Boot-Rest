package timetable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import timetable.model.Event;
import timetable.model.EventRepository;

@SpringBootApplication
public class TimetableApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimetableApplication.class, args);
    }
    
    @Bean
    CommandLineRunner init(EventRepository eventRepository) {
        return (evt)-> { 
            eventRepository.save( new Event("Yoga", 
                4,
                "8pm", "9pm"));
            eventRepository.save(new Event("Boxercise", 
                5,
                "7pm", "8pm"));
        };      
    }
}
