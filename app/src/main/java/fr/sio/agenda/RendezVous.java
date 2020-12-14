package fr.sio.agenda;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Time;
import java.util.Date;

@DatabaseTable (tableName = "RendezVous")
public class RendezVous {
    @DatabaseField (generatedId = true)
    private int idRdv;
    @DatabaseField
    private String Objet;
    @DatabaseField
    private Date date;
    @DatabaseField
    private Time heure;
    @DatabaseField
    private Time duree;
    @DatabaseField
    private String detail;

    public RendezVous() {
    }

    public RendezVous(String objet, Date date, Time heure, Time duree, String detail) {
        Objet = objet;
        this.date = date;
        this.heure = heure;
        this.duree = duree;
        this.detail = detail;
    }

    public int getIdRdv() {
        return idRdv;
    }

    public String getObjet() {
        return Objet;
    }

    public void setObjet(String objet) {
        Objet = objet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHeure() {
        return heure;
    }

    public void setHeure(Time time) {
        this.heure = time;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
