package group.event.eventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.event.eventi.model.ArtistsEvent;

public interface ArtistsEventRepository extends JpaRepository<ArtistsEvent, Long> {
}
