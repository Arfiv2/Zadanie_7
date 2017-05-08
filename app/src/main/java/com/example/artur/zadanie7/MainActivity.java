package com.example.artur.zadanie7;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaRecorder myAudioRecorder;
    private MediaPlayer mediaPlayer;
    private static String mFileName = "raw/MyRec.3gp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void stopRec(View view) {
        myAudioRecorder = new MediaRecorder();
        myAudioRecorder.stop();
        myAudioRecorder.release();
        myAudioRecorder = null;

    }

    public void startRec(View view) throws IOException {
        myAudioRecorder = new MediaRecorder();
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myAudioRecorder.setOutputFile(mFileName);

        myAudioRecorder.prepare();
        myAudioRecorder.start();


    }

    public void playRec(View view) throws IOException {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(mFileName);
        mediaPlayer.prepare();
        mediaPlayer.start();


    }
}
