package guru.springframework.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.demo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}
