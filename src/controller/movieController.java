
package controller;

import java.util.List;
import DaoDataMovie.DataMovieDao;
import DaoImplement.DataMovieImplement;
import model.*;
import view.mainView;


public class movieController {
    mainView frame;
    DataMovieImplement implDataMovie;
    List<DataMovie> dm;

    public movieController(mainView frame) {
        this.frame = frame;
        implDataMovie = new DataMovieDao(); 
        dm = implDataMovie.getAll();
    }

    public void isiTable() {
        dm = implDataMovie.getAll();
        model.ModelTabelDataMovie mp = new ModelTabelDataMovie(dm);
        frame.getTabelDataMovie().setModel(mp);
    }

    public void insert() {
        DataMovie dm = new DataMovie();
        dm.setJudul(frame.getjTFJudul().getText());
        double alur = Double.parseDouble(frame.getjTFAlur().getText());
        dm.setAlur(alur);
        double penokohan = Double.parseDouble(frame.getjTFPenokohan().getText());
        dm.setPenokohan(penokohan);
        double akting = Double.parseDouble(frame.getjTFAkting().getText());
        dm.setAkting(akting);
        dm.setRating((dm.getAlur() + dm.getPenokohan() + dm.getAkting()) / 3);
        implDataMovie.insert(dm);
    }

    public void update(){
        DataMovie dm = new DataMovie();
        dm.setJudul(frame.getjTFJudul().getText());
        double alur = Double.parseDouble(frame.getjTFAlur().getText());
        dm.setAlur(alur);
        double penokohan = Double.parseDouble(frame.getjTFPenokohan().getText());
        dm.setPenokohan(penokohan);
        double akting = Double.parseDouble(frame.getjTFAkting().getText());
        dm.setAkting(akting);
        dm.setRating((dm.getAlur() + dm.getPenokohan() + dm.getAkting()) / 3);
        dm.setId(Integer.parseInt(frame.getjTFId2().getText()));
        implDataMovie.update(dm);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getjTFId2().getText());
        implDataMovie.delete(id);
    }
}
