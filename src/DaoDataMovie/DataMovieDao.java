
package DaoDataMovie;

import java.sql.*;
import java.util.*;
import koneksi.Connector;
import model.*;
import DaoImplement.DataMovieImplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMovieDao implements DataMovieImplement{
    Connection connection;
    
    final String select = "SELECT * FROM data_movie ";
    final String insert = "INSERT INTO data_movie (judul, alur, penokohan, akting, rating) VALUES (?, ?, ?, ?, ?)";
    final String update = "UPDATE data_movie SET judul=?, alur=?, penokohan=?, akting=?, rating=? where id=?";
    final String delete = "DELETE FROM data_movie WHERE id=?";
    
    
    public DataMovieDao(){
        connection = Connector.connection();
    }

    @Override
    public void insert(DataMovie m) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getRating());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                m.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataMovie m) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getJudul());
            statement.setDouble(2, m.getAlur());
            statement.setDouble(3, m.getPenokohan());
            statement.setDouble(4, m.getAkting());
            statement.setDouble(5, m.getRating());
            statement.setInt(6, m.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public List<DataMovie> getAll() {
        List<DataMovie> dm = null;
        try {
            dm = new ArrayList<DataMovie>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataMovie movie = new DataMovie();
                movie.setId(rs.getInt("id"));
                movie.setJudul(rs.getString("judul"));
                movie.setAlur(rs.getDouble("alur"));
                movie.setPenokohan(rs.getDouble("penokohan"));
                movie.setAkting(rs.getDouble("akting"));
                movie.setRating(rs.getDouble("rating"));
                dm.add(movie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataMovieDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return dm;
    }
}
