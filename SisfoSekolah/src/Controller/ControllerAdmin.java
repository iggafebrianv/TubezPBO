/*
Topik   : Sekolah
Anggota : Arpriansah Yonathan (1301194112)
          Balqis Sayyidahtul Atikah (1301193480)
          Igga Febrian Virgiani (1301194283)
          Manuel Benedict (1301194182)
 */
package Controller;

import GUI.guiAdmin;
import Model.Database;
import Model.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

public class ControllerAdmin extends MouseAdapter implements ActionListener {
    private guiAdmin viewAdmin;
    private admin adminModel;
    private Database db;

    public ControllerAdmin(Database db) {
        this.viewAdmin = viewAdmin;
        this.adminModel = adminModel;
        this.db = db;
        
        viewAdmin = new guiAdmin();
        viewAdmin.addActionListener(this);
        //viewAdmin.addMouseAdapter(this);
        
        viewAdmin.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
            try {
                if (source.equals(viewAdmin.getBtnBack())) {
                    new Controller();
                    viewAdmin.dispose();
                }
                else if (source.equals(viewSiswa.getBtnCariNIS())) {
                    try {
                        if (viewSiswa.getjTextFieldNIS().getText().equals("")){
                            JOptionPane.showMessageDialog(null, "NIS harus diisi terlebih dahulu");
                        } else {
                            String NIS = viewSiswa.getjTextFieldNIS().getText();
                            viewSiswa.resetTable();
                            lihatNilai(NIS, db);
                        }
                    } catch (Exception es) {
                        System.out.println("Error 404 "+ es.getMessage());
                        JOptionPane.showMessageDialog(null, "Data siswa tidak ditemukan");
                    }
                }
            } catch (Exception ef) {
                JOptionPane.showMessageDialog(null, "Data siswa tidak ditemukan");
            }
    }
}
