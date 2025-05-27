
package DaoImplement;

import model.DataMovie;
import java.util.List;

public interface DataMovieImplement {
    void insert(DataMovie movie);
    void update(DataMovie movie);
    void delete(int id);
    List<DataMovie>getAll();
}
