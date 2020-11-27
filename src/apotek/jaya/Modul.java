/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.jaya;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author dbss134
 */
public class Modul {

    static DefaultTableModel model = new DefaultTableModel();
    static Connection con = Koneksi.getKoneksi();

    public static PreparedStatement preState(String query) throws SQLException {
        return Modul.con.prepareStatement(query);
    }

    public static void fillComboBox(JComboBox cm, int kolom, String query) {
        try {
            ResultSet rs = preState(query).executeQuery();
            cm.removeAllItems();
            while (rs.next()) {
                cm.addItem(rs.getString(kolom));
                cm.getSelectedItem();
            }
        } catch (SQLException ex) {
            
        }
    }

    static public void filter(JTable jt, String query, DefaultTableModel model, JLabel lb) {        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jt.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
        lb.setText("Jumlah Data : "+model.getRowCount());
    }
    
    static public void refreshData(DefaultTableModel model, JTable j) {
        model = (DefaultTableModel) j.getModel();
        model.setRowCount(0);        
    }
}
