package repositories;

import com.rnm.omdb.models.Bookmark;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {
    ArrayList<Bookmark> findByOwnerId(Integer ownerId);
}
