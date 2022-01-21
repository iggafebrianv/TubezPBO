/*
Topik   : Sekolah
Anggota : Arpriansah Yonathan (1301194112)
          Balqis Sayyidahtul Atikah (1301193480)
          Igga Febrian Virgiani (1301194283)
          Manuel Benedict (1301194182)
 */
package Controller;

import GUI.guiGuru;
import Model.Database;
import Model.siswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

public class ControllerGuru extends MouseAdapter implements ActionListener {
    private guiGuru viewGuru;
    private Database db;
    private String nis, nama, aktivitas, namasiswa, nama_mapel;
    private float nilai;
    
    private siswa student ;
    
    public ControllerGuru(Database db) {
        this.db = db;
        viewGuru = new guiGuru();
        viewGuru.addActionListener(this);
        //viewGuru.addMouseAdapter(this);
        //viewGuru.setDaftarMatkul(getMapel());
        //combobox();
        viewGuru.setVisible(true);
    }
    /*
    public String[] getMapel() {
        if (db.getListMapel().size() <= 0){
            JOptionPane.showMessageDialog(null, "Mata pelajaran Kosong");
        } else {
            String[] listMapel = new String[db.getListMapel().size()];
            for (int i = 0; i < listMapel.length; i++) {
                listMapel[i] = db.getListMapel().get(i).getMataPelajaran();
            }
        }
        return null;
    }
    */

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
        try {
            if (source.equals(viewGuru.getBtnBack())) {
                new Controller();
                viewGuru.dispose();
            } 
            else if (source.equals(viewGuru.getBtnAdd())) {
                try {
                        String nis = viewGuru.getTfNIS();
                        String id_mapel = viewGuru.getCbMapelText();
                        String task = viewGuru.getCbTaskText();
                        String f = viewGuru.getTfNilai();
                        float nilai = Float.parseFloat(f);
                        if (nis == null || f == null) {
                            JOptionPane.showMessageDialog(viewGuru, "Input Belum Benar");
                        }else{
                            student.addNilai(db, nis, namasiswa, id_mapel, aktivitas, nis);
                            JOptionPane.showMessageDialog(viewGuru, "Nilai berhasil diinput.");
                            viewGuru.resetView();  
                        }
                                     
                } catch (Exception es) {
                    JOptionPane.showMessageDialog(null, "input salah") ; 
                    //es.printStackTrace();
                }
            }else if(source.equals(viewGuru.getBtnCari())){
                lihatNisNama(db, nis, nama);
            }
        } catch (Exception ef) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public void lihatNisNama(Database db, String nis, String nama){
        try{
            db.connect();
            //////////--------////////
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}