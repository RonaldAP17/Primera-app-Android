package com.example.onboarding.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.onboarding.R;
import com.example.onboarding.datos.DatosSQLite;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class GastoFragment extends Fragment {
    ListView mLvGastos;
    ArrayList arrayList = new ArrayList<HashMap<String,String>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gastos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLvGastos = view.findViewById(R.id.lvGastos);
        leerDatos();
    }

    private void leerDatos() {
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.mostrarGasto(datosSQLite);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    HashMap map = new HashMap<String,String>();
                    map.put("idmovimiento", cursor.getString(cursor.getColumnIndex("idmovimiento")));
                    map.put("descripcion", cursor.getString(cursor.getColumnIndex("descripcion")));
                    map.put("fecha", cursor.getString(cursor.getColumnIndex("fecha")));
                    map.put("monto", cursor.getString(cursor.getColumnIndex("monto")));
                    arrayList.add(map);
                }while (cursor.moveToNext());

                String[] datos = {"descripcion", "fecha", "monto"};
                int[] ids = {R.id.tvDescripcion, R.id.tvFecha, R.id.tvMonto};

                ListAdapter listAdapter = new SimpleAdapter(
                        getActivity(),
                        arrayList,
                        R.layout.item_movimiento,
                        datos,
                        ids
                );
                mLvGastos.setAdapter(listAdapter);
            }
        }
    }
}