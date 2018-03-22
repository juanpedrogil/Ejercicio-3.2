package com.example.juanpedrog.ejercicio32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button clic;
    public static TextView data;
    public static TextView id;
    public static TextView input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clic=findViewById(R.id.clic);
        data=findViewById(R.id.nombre);
        id=findViewById(R.id.id);
        input=findViewById(R.id.input);
        clic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process=new GetJson();
                process.execute();
            }
        });
    }
}
