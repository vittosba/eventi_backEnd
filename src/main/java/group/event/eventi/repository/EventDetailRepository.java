package group.event.eventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.event.eventi.model.EventDetails;

public interface EventDetailRepository extends JpaRepository<EventDetails, Long> {
}
