package com.famake.ideasnapper.snapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeRepository extends CrudRepository<Ide, Long> {

}
