
package DAO;

import koneksi.Connector;
import model.DataMovie;
import java.sql.*;
import java.util.*;

public class implMovieDao implements movieDao{
    Connection con;
    public implMovieDao(){
    con = Connector.connection();
    }

    @Override
    public void insert(DataMovie movie) {
        try {
            String sql = "INSERT INTO movie (judul, alur, penokohan, akting, rating) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, movie.getJudul());
            ps.setDouble(2, movie.getAlur());
            ps.setDouble(3, movie.getPenokohan());
            ps.setDouble(4, movie.getAkting());
            ps.setDouble(5, movie.getRating());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DataMovie movie) {
        try {
            String sql = "UPDATE movie SET judul=?, alur=?, penokohan=?, akting=?, rating=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, movie.getJudul());
            ps.setDouble(2, movie.getAlur());
            ps.setDouble(3, movie.getPenokohan());
            ps.setDouble(4, movie.getAkting());
            ps.setDouble(5, movie.getRating());
            ps.setInt(6, movie.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM movie WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DataMovie> getAll() {
         List<DataMovie> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM movie";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                DataMovie m = new DataMovie();
                m.setId(rs.getInt("id"));
                m.setJudul(rs.getString("judul"));
                m.setAlur(rs.getDouble("alur"));
                m.setPenokohan(rs.getDouble("penokohan"));
                m.setAkting(rs.getDouble("akting"));
                m.setRating(rs.getDouble("rating"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
