package main.dao.repository;

import main.dao.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findById(Long id);

    List<Post> findAll();
}
