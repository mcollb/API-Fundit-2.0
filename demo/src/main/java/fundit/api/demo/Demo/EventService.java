package fundit.api.demo.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public ArrayList<Event> getEvents(){
        return (ArrayList<Event>) eventRepository.findAll();
    }

    public Event saveEvent(Event event){
        return eventRepository.save(event);
    }

    public Optional<Event> getById(Long id){
        return eventRepository.findById(id);
    }

    public Event updateById(Event request, Long id){
        Event event = eventRepository.findById(id).get();

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setCategory(request.getCategory());
        event.setUrlImage(event.getUrlImage());
        event.setPrice(event.getPrice());
        event.setUbication(event.getUbication());
        event.setDate(event.getDate());
        event.setTime(event.getTime());

        return eventRepository.save(event);
    }

    public Boolean deleteEvent(Long id){
        Optional<Event> event = eventRepository.findById(id);
        System.out.println(event);
        if (event.isPresent()){
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
