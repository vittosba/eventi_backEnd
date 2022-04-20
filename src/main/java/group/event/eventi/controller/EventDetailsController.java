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

import group.event.eventi.model.EventDetails;
import group.event.eventi.repository.EventDetailRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EventDetailsController {

	@Autowired
	EventDetailRepository eventDetailRepository;

	@GetMapping("/eventDetails")
	public ResponseEntity<List<EventDetails>> getAllEventDetails() {
		try {
			List<EventDetails> eventDetails = new ArrayList<EventDetails>();

            eventDetailRepository.findAll().forEach(eventDetails::add);

			if (eventDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(eventDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/eventDetails/{id}")
	public ResponseEntity<EventDetails> getEventDetailById(@PathVariable("id") long id) {
		Optional<EventDetails> eventDetailData = eventDetailRepository.findById(id);

		if (eventDetailData.isPresent()) {
			return new ResponseEntity<>(eventDetailData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/eventDetails")
	public ResponseEntity<EventDetails> createEventDetail(@RequestBody EventDetails eventDetail) {
		try {
			EventDetails _eventDetail = eventDetailRepository
					.save(new EventDetails(eventDetail.getEvent(), eventDetail.getCity(), eventDetail.getPlace(),eventDetail.getDate(), eventDetail.getTimeStart(), eventDetail.getPrice(), eventDetail.getCapacity()));
			return new ResponseEntity<>(_eventDetail, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/eventDetails/{id}")
	public ResponseEntity<EventDetails> updateEventDetail(@PathVariable("id") long id, @RequestBody EventDetails eventDetail) {
		Optional<EventDetails> eventDetailsData = eventDetailRepository.findById(id);

		if (eventDetailsData.isPresent()) {
			EventDetails _eventDetail = eventDetailsData.get();
			_eventDetail.setEvent(eventDetail.getEvent());
			_eventDetail.setCity(eventDetail.getCity());
			_eventDetail.setPlace(eventDetail.getPlace());
            _eventDetail.setDate(eventDetail.getDate());
			_eventDetail.setTimeStart(eventDetail.getTimeStart());
			_eventDetail.setPrice(eventDetail.getPrice());
			_eventDetail.setCapacity(eventDetail.getCapacity());
			return new ResponseEntity<>(eventDetailRepository.save(_eventDetail), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/eventDetails/{id}")
	public ResponseEntity<HttpStatus> deleteEventDetail(@PathVariable("id") long id) {
		try {
			eventDetailRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eventDetails")
	public ResponseEntity<HttpStatus> deleteAllEventDetails() {
		try {
			eventDetailRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
