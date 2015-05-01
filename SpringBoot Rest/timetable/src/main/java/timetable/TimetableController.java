package timetable;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import timetable.model.Event;
import timetable.model.EventRepository;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    @Autowired
    EventRepository eventRepo;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Collection<Event> getEvents() {
        return eventRepo.findAll();
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Event getEventById(@PathVariable Long id) {
        Event result = eventRepo.findOne(id);
        if (result == null) {
            throw new EventNotFoundException(id);
        }
        return result;
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public ResponseEntity<?> addEvent(@RequestBody Event evt) {
        Event result = eventRepo.save(evt);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<>(result, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable Long id) {
        eventRepo.delete(id);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class EventNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -9174199038443186877L;

    public EventNotFoundException(Long eventId) {
        super("could not find event '" + eventId + "'.");
    }
}
