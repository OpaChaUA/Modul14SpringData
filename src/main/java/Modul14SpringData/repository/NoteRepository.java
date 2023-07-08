package Modul14SpringData.repository;

import Modul14SpringData.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository <Note, Long> {

}
