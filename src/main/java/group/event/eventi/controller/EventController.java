package group.event.eventi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.event.eventi.model.Event;
import group.event.eventi.repository.EventRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventRepository eventRepository;

	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {
		try {
			List<Event> events = new ArrayList<Event>();

            eventRepository.findAll().forEach(events::add);

			if (events.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(events, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") long id) {
		Optional<Event> eventData = eventRepository.findById(id);

		if (eventData.isPresent()) {
			return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/events")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		try {
			Event _event = eventRepository
					.save(new Event(event.getName(), event.getDescription(), event.getImg(), event.getCategory()));
			return new ResponseEntity<>(_event, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/events/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event event) {
		Optional<Event> eventData = eventRepository.findById(id);

		if (eventData.isPresent()) {
			Event _event = eventData.get();
			_event.setName(event.getName());
			_event.setDescription(event.getDescription());
			_event.setImg(event.getImg());
            _event.setCategory(event.getCategory());
			return new ResponseEntity<>(eventRepository.save(_event), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/events/{id}")
	public ResponseEntity<HttpStatus> deleteEvent(@PathVariable("id") long id) {
		try {
			eventRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/events")
	public ResponseEntity<HttpStatus> deleteAllEvents() {
		try {
			eventRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
