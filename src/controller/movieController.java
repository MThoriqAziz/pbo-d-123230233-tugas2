
package controller;

import DAO.implMovieDao;
import DAO.movieDao;
import model.DataMovie;
import view.mainView;
import model.ModelTabelDataMovie;
import java.util.List;

public class movieController {
    mainView view;
    movieDao dao; // pakai interface
    List<DataMovie> list;

    public movieController(mainView view) {
        this.view = view;
        dao = new implMovieDao(); // pakai implementasi konkret
    }

    public void loadTable() {
        list = dao.getAll(); // sekarang sudah benar
        model.ModelTabelDataMovie model = new ModelTabelDataMovie(list);
        view.setTableModel(model);
    }

    public void insert() {
        DataMovie m = new DataMovie();
        m.setJudul(view.getJudul());
        m.setAlur(view.getAlur());
        m.setPenokohan(view.getPenokohan());
        m.setAkting(view.getAkting());
        m.setRating((m.getAlur() + m.getPenokohan() + m.getAkting()) / 3);

        dao.insert(m);
        loadTable();
    }

    public void update() {
        int selectedRow = view.getSelectedRow();
        if (selectedRow != -1) {
            DataMovie m = list.get(selectedRow);
            m.setJudul(view.getJudul());
            m.setAlur(view.getAlur());
            m.setPenokohan(view.getPenokohan());
            m.setAkting(view.getAkting());
            m.setRating((m.getAlur() + m.getPenokohan() + m.getAkting()) / 3);

            dao.update(m);
            loadTable();
        }
    }

    public void delete() {
        int selectedRow = view.getSelectedRow();
        if (selectedRow != -1) {
            int id = list.get(selectedRow).getId();
            dao.delete(id);
            loadTable();
        }
    }
}
