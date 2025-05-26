
package DAO;

import model.DataMovie;
import java.util.List;

public interface movieDao {
    void insert(DataMovie movie);
    void update(DataMovie movie);
    void delete(int id);
    List<DataMovie>getAll();
}
