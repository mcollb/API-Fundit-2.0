package fundit.api.demo.Demo;



import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    @Autowired
    private EventService eventService;

    //Mostrar todos
    @GetMapping
    public ArrayList<Event> getEvents(){
        return this.eventService.getEvents();
    }

    //Guardar
    @PostMapping("/add")
    public Event saveEvent(@RequestBody Event event){
        return this.eventService.saveEvent(event);
    }

    //Mostrar por id
    @GetMapping(path = "/{id}")
    public Optional<Event> getEventById(@PathVariable Long id){
        return this.eventService.getById(id);
    }

    //Modificar
    @PutMapping(path = "/{id}")
    public Event updateEventById(@RequestBody Event request, @PathVariable("id") Long id){
        return this.eventService.updateById(request,id);
    }

    //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        boolean ok = this.eventService.deleteEvent(id);

        return ok?ResponseEntity.ok("Event with id "+id+" deleted."): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
    }
}
