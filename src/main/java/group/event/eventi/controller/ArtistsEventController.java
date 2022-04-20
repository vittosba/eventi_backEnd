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

import group.event.eventi.model.ArtistsEvent;
import group.event.eventi.repository.ArtistsEventRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArtistsEventController {

	@Autowired
	ArtistsEventRepository artistsEventRepository;

	@GetMapping("/artistsEvent")
	public ResponseEntity<List<ArtistsEvent>> getAllArtistsEvents() {
		try {
			List<ArtistsEvent> artistsEvent = new ArrayList<ArtistsEvent>();

            artistsEventRepository.findAll().forEach(artistsEvent::add);

			if (artistsEvent.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(artistsEvent, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/artistsEvent/{id}")
	public ResponseEntity<ArtistsEvent> getArtistsEventById(@PathVariable("id") long id) {
		Optional<ArtistsEvent> artistsEventData = artistsEventRepository.findById(id);

		if (artistsEventData.isPresent()) {
			return new ResponseEntity<>(artistsEventData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/artistsEvent")
	public ResponseEntity<ArtistsEvent> createArtistsEvent(@RequestBody ArtistsEvent artistsEvent) {
		try {
			ArtistsEvent _artistsEvent = artistsEventRepository
					.save(new ArtistsEvent(artistsEvent.getArtist(), artistsEvent.getEvent()));
			return new ResponseEntity<>(_artistsEvent, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/artistsEvent/{id}")
	public ResponseEntity<ArtistsEvent> updateArtistsEvent(@PathVariable("id") long id, @RequestBody ArtistsEvent artistsEvent) {
		Optional<ArtistsEvent> artistsEventEventData = artistsEventRepository.findById(id);

		if (artistsEventEventData.isPresent()) {
			ArtistsEvent _artistsEvent = artistsEventEventData.get();
			_artistsEvent.setArtist(artistsEvent.getArtist());
			_artistsEvent.setEvent(artistsEvent.getEvent());
			return new ResponseEntity<>(artistsEventRepository.save(_artistsEvent), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/artistsEvent/{id}")
	public ResponseEntity<HttpStatus> deleteArtistsEvent(@PathVariable("id") long id) {
		try {
			artistsEventRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/artistsEvent")
	public ResponseEntity<HttpStatus> deleteAllArtistsEvents() {
		try {
			artistsEventRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
