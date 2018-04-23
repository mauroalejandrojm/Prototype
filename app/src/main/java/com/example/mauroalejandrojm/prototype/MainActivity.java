package com.example.mauroalejandrojm.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private EditText latitud, longitud;
    private TextView dateTextView;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        latitud = (EditText) findViewById(R.id.latitudeField);
        dateTextView = (TextView) findViewById(R.id.dateField);
        longitud = (EditText) findViewById(R.id.longitudeField);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        dateTextView.setText(dateString);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BackgroundTask bt = new BackgroundTask(getBaseContext());
                System.out.println("DATOS:   Lat: "+latitud.getText().toString()+" , Long: "+longitud.getText().toString()+" , date: "+dateTextView.getText().toString());
                String[] params = new String[3];
                params[0] = latitud.getText().toString();
                params[1] = longitud.getText().toString();
                params[2] = dateTextView.getText().toString();
                bt.doInBackground(params);
            }
        });
    }
}
