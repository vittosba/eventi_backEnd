package group.event.eventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.event.eventi.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
