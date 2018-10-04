package org.dev4u.hv.guia3_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MensajeActivity extends AppCompatActivity {

    private EditText texto;
    private Button btnBoton;
    private AdaptadorMensajes adaptadormensajes;
    private ArrayList<Mensajes> mensajesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        this.texto = findViewById(R.id.txtContenido);
        this.btnBoton  = findViewById(R.id.btnEnviar);

        mensajesArrayList = new ArrayList<>();
        adaptadormensajes = new AdaptadorMensajes(this,mensajesArrayList);

        ListView  listView = findViewById(R.id.lstMensaje);
        listView.setAdapter(adaptadormensajes);
        btnBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                Mensajes mensaje = new Mensajes(c.getTime().toString(),texto.getText().toString());
                mensajesArrayList.add(mensaje);
                adaptadormensajes.notifyDataSetChanged();
            }
        });


    }
}
