package fr.sio.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //affichage des rendez-vous
    }

    public void saisieRendezVous(View v) {
        intent = new Intent(MainActivity.this, SaisieRendezVous.class);
        startActivity(intent);
    }
}