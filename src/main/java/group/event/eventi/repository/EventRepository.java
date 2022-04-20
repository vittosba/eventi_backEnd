package group.event.eventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.event.eventi.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
