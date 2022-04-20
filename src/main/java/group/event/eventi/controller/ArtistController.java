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

import group.event.eventi.model.Artist;
import group.event.eventi.repository.ArtistRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArtistController {

	@Autowired
	ArtistRepository artistRepository;

	@GetMapping("/artists")
	public ResponseEntity<List<Artist>> getAllArtists() {
		try {
			List<Artist> artists = new ArrayList<Artist>();

            artistRepository.findAll().forEach(artists::add);

			if (artists.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(artists, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/artists/{id}")
	public ResponseEntity<Artist> getUserById(@PathVariable("id") long id) {
		Optional<Artist> artistData = artistRepository.findById(id);

		if (artistData.isPresent()) {
			return new ResponseEntity<>(artistData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/artists")
	public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
		try {
			Artist _artist = artistRepository
					.save(new Artist(artist.getName(), artist.getSurname(), artist.getArtName()));
			return new ResponseEntity<>(_artist, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/artists/{id}")
	public ResponseEntity<Artist> updateArtist(@PathVariable("id") long id, @RequestBody Artist artist) {
		Optional<Artist> artistData = artistRepository.findById(id);

		if (artistData.isPresent()) {
			Artist _artist = artistData.get();
			_artist.setName(artist.getName());
			_artist.setSurname(artist.getSurname());
			_artist.setArtName(artist.getArtName());
			return new ResponseEntity<>(artistRepository.save(_artist), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/artists/{id}")
	public ResponseEntity<HttpStatus> deleteArtist(@PathVariable("id") long id) {
		try {
			artistRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/artists")
	public ResponseEntity<HttpStatus> deleteAllArtists() {
		try {
			artistRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
