package fr.sio.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.security.PrivateKey;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

public class SaisieRendezVous extends AppCompatActivity {
    private Intent intent;
    private TextView saisieDate;
    private TextView saisieHeure;
    private TextView saisieDuree;
    private Calendar DateSaisie;
    private Calendar HeureSaisie;
    private Calendar DureeSaisie;
    private String affTimDat;
    private NumberFormat fommatJM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_rendez_vous);

        fommatJM = new DecimalFormat("00");
        saisieDate = findViewById(R.id.infoDate);
        saisieHeure = findViewById(R.id.infoHeure);
        saisieDuree = findViewById(R.id.infoDuree);

        //initialisation de la date à celle du jour sur l'affichage
        DateSaisie = Calendar.getInstance();
        int month1 = DateSaisie.get(Calendar.MONTH)+1;
        affTimDat = DateSaisie.get(Calendar.DAY_OF_MONTH) + "/" + month1 + "/" + DateSaisie.get(Calendar.YEAR);
        saisieDate.setText(affTimDat);

       //initialisation de l'heure à celle actuelle
        HeureSaisie = Calendar.getInstance();
        affTimDat = HeureSaisie.get(Calendar.HOUR_OF_DAY) + ":" + HeureSaisie.get(Calendar.MINUTE);
        saisieHeure.setText(affTimDat);

        DureeSaisie = Calendar.getInstance();
        saisieDuree.setText("00:00");

    }

    public void memorisationRendezVous(View v) {
        //Enregistrement d'un Rendez-vous
        intent = new Intent(SaisieRendezVous.this, MainActivity.class);
        startActivity(intent);
    }

    public void annulation(View v) {
        intent = new Intent(SaisieRendezVous.this, MainActivity.class);
        startActivity(intent);
    }

    public void saisieDate(View v) {
        int annee = DateSaisie.get(Calendar.YEAR);
        int mois = DateSaisie.get(Calendar.MONTH);
        int jour = DateSaisie.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dateDial = new DatePickerDialog(
                SaisieRendezVous.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListene,
                annee, mois, jour);
        dateDial.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dateDial.show();
    }

    private DatePickerDialog.OnDateSetListener mDateSetListene = (DatePicker arg0, int an, int mois, int jour) -> {
        DateSaisie.set(an,mois,jour);
        saisieDate.setText(new StringBuilder().append(fommatJM.format(jour)).append("/")
                .append(fommatJM.format(mois+1)).append("/").append(an));
    };

    public void saisieHeure(View v) {
        int heure = HeureSaisie.get(Calendar.HOUR_OF_DAY);
        int minute = HeureSaisie.get(Calendar.MINUTE);
        TimePickerDialog timeDial = new TimePickerDialog(
                SaisieRendezVous.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mTimeSetListene,
                heure, minute, true);
        timeDial.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timeDial.show();
    }

    private TimePickerDialog.OnTimeSetListener mTimeSetListene = (TimePicker arg0, int heure, int minute) -> {
        HeureSaisie.set(heure,minute);
        saisieHeure.setText(new StringBuilder().append(fommatJM.format(heure)).append(":")
                .append(fommatJM.format(minute)));
    };

    public void saisieDuree(View v) {
        int heure = DureeSaisie.get(Calendar.HOUR_OF_DAY);
        int minute = DureeSaisie.get(Calendar.MINUTE);
        TimePickerDialog timeDial = new TimePickerDialog(
                SaisieRendezVous.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mTimeSetListene2,
                heure, minute, true);
        timeDial.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        timeDial.show();
    }

    private TimePickerDialog.OnTimeSetListener mTimeSetListene2 = (TimePicker arg0, int heure, int minute) -> {
        DureeSaisie.set(heure,minute);
        saisieDuree.setText(new StringBuilder().append(fommatJM.format(heure)).append(":")
                .append(fommatJM.format(minute)));
    };

}