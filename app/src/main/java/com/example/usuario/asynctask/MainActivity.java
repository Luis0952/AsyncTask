package com.example.usuario.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    ProgressBar ProgressbarH, ProgressbarC;
    Button butprogress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        añadirvistas();
        butprogress.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask_load().execute();
                butprogress.setClickable(false);
            }
        });
    }

        private void añadirvistas() {

            butprogress = (Button) findViewById(R.id.bt_1);

            ProgressbarH = (ProgressBar) findViewById(R.id.prbar_1);


            ProgressbarC = (ProgressBar)findViewById(R.id.prbar_2);
            // progressBarHorizontal.setProgress(0);

//            progressBarCircular = (ProgressBar) findViewById(R.id.progressBarCircular);
            // progressBarCircular.setProgress(0);
            }

        public class AsyncTask_load extends AsyncTask<Void, Integer, Void> {

        int progreso;


            @Override

            protected void onPreExecute() {
                Toast.makeText(MainActivity.this, "onPreExecute", Toast.LENGTH_LONG).show();
                progreso = 0;
                ProgressbarC.setVisibility(View.VISIBLE);
            }
            @Override

            protected Void doInBackground(Void... params){

                while(progreso < 100) {
                    progreso++;
                    publishProgress(progreso);
                    SystemClock.sleep(20);
                }
                return null;
            }

            protected void onProgressUpdate(Integer... values) {

                ProgressbarH.setProgress(values[0]);
                ProgressbarC.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Void result) {
                Toast.makeText(MainActivity.this, "onPostExecute", Toast.LENGTH_LONG).show();
                butprogress.setClickable(true);
                ProgressbarC.setVisibility(View.INVISIBLE);
            }
    }

    }
