package com.maxescobar.audioplayer_mediaplayer_soundpool;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Crear variables de tipo Boton, y de Soundpool
    Button btnsound;
    SoundPool sp;
    int sonido_player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lo de siempre extraemos el ID del objeto
        btnsound = (Button) findViewById(R.id.btnSoundPool);

        //le asignamos a la variable con un maximo de reproducciones de 1 y el tipo de Stream y la calidad de reproduccion
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        //En el archivo entero cargamos la pista de audio con el SoundoPool y su metodo Load()
        sonido_player = sp.load(this,R.raw.coin,1);
    }

    public void AudioSoundPool(View vista){
        //Metodo para la reproduccion de la pista
        //Primero el dato con la pista de audio luego el nivel de stereo, la prioridad, las repeticiones
        //Siendo -1 como de manera indefinida, 0 solo una vez y 1 se repite de manera espontanea, la velocidad de reproduccion
        sp.play(sonido_player,1,1, 1,0,0);
    }

    public void MediaPlayer(View vista){
        //Crear un objeto mediaplayer para un audio largo
        //En donde le asignamos sus caracteristicas
        MediaPlayer mp = MediaPlayer.create(this,R.raw.solar_bowler);
        //con esta linea simplemente se reproduce el audio. pero se reproduce y si el boton se toca no para jajaja
        mp.start();
    }
}