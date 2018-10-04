package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorMensajes extends ArrayAdapter<Mensajes> {
    public AdaptadorMensajes(@NonNull Context context, @NonNull List<Mensajes> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     Mensajes mensaje= getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView contenido = convertView.findViewById(R.id.txtContenidoo);
        TextView fecha = convertView.findViewById(R.id.txtfecha);

        contenido.setText(mensaje.contenido);
        fecha.setText(mensaje.fecha);

       return convertView;
    }

}
