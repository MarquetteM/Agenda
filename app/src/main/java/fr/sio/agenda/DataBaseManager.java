package fr.sio.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.List;

public class DataBaseManager extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NOM = "RendezVous.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseManager (Context context) {
        super (context, DATABASE_NOM, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, RendezVous.class);
        } catch (Exception e) {
            Log.e ("agenda", "Pb lors de la création de la base");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, RendezVous.class, true);
            onCreate(database, connectionSource);
        } catch (Exception e) {
            Log.e("agenda", "Pb lors de l'upgrade de la base");
        }
    }

    public int ajoutRdv (RendezVous newRdv){
        try {
            Dao<RendezVous,Integer> maDao = getDao(RendezVous.class);
            maDao.create(newRdv);
            return newRdv.getIdRdv();
        } catch (Exception e){
            Log.e ("agenda", "Pb lors de la création d'un nouveau RDV");
            return 0;
        }
    }

    public List<RendezVous> lecAllRendezVous() {
        try {
            Dao<RendezVous,Integer> maDao = getDao(RendezVous.class);
            return maDao.queryForAll();
        }catch (Exception e) {
            Log.e ("agenda", "PB lecture de tous les RDV ");
            return null;
        }
    }

    public List<RendezVous> lecRendezVous(int id) {
        try {
            Dao<RendezVous,Integer> maDao = getDao(RendezVous.class);
            return maDao.queryForEq("idRdv", id);
        } catch (Exception e) {
            Log.e ("agenda", "PB lors de la lecture d'un RDV par id");
            return null;
        }
    }

}
