/*
Topik   : Sekolah
Anggota : Arpriansah Yonathan (1301194112)
          Balqis Sayyidahtul Atikah (1301193480)
          Igga Febrian Virgiani (1301194283)
          Manuel Benedict (1301194182)
 */
package Model;

import java.util.ArrayList;

public class siswa extends Identity {
    private String nis;
    
    public siswa(String nama, String nis){
        super(nama);
        this.nis = nis;
    }   

    public void setNIS(String nis){
        this.nis = nis;
    }
    public String getNIS(){
        return nis;
    }
    public void addNilai(Database db, String nis, String nama_siswa, String mapel, String activity, String nilai) {
        try {
            db.connect();
            String sql = "INSERT INTO nilai VALUES ('"
                    +nis+"','"
                    +nama_siswa+"','"
                    +mapel+"','"
                    +activity+"','"
                    +nilai+"')";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } 
    
    public void lihatSiswa(Database db, String nama_siswa){
        try{
            db.connect();
            String sql = "SELECT nama_siswa FROM siswa";
            db.setRs(db.getStmt().executeQuery(sql));
            db.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
