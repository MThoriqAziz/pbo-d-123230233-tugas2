
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelDataMovie extends AbstractTableModel{

    List<DataMovie> dm;
    public ModelTabelDataMovie(List<DataMovie>dm){
        this.dm = dm;
    }
    
    @Override
    public int getRowCount() {
        return dm.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName (int column){
        switch(column){
            case 0:
                return "Id";
            case 1:
                return "Judul";
            case 2:
                return "Alur";
            case 3:
                return "Penokohan";
            case 4:
                return "Akting";
            case 5:
                return "Rating";
            default:
                return null;
        }
    }
    
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dm.get(row).getId();
            case 1:
                return dm.get(row).getJudul();
            case 2:
                return dm.get(row).getAlur();
            case 3:
                return dm.get(row).getPenokohan();
            case 4:
                return dm.get(row).getAkting();
            case 5:
                return dm.get(row).getRating();
            default:
                return null;
        }
    }
    
}
