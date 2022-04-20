package group.event.eventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import group.event.eventi.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
