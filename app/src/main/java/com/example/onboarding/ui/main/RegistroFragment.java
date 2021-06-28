package com.example.onboarding.ui.main;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.onboarding.R;
import com.example.onboarding.datos.DatosSQLite;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RegistroFragment extends Fragment implements View.OnClickListener {
    TextInputEditText mTetDescripcion, mTetMonto;
    Button mBtnRegistrar;
    Switch mSwtEstado;
    TextView mTvEstado;
    TextView mTvMovimientoEstado;
    TextView mTvIngresosResultado,mTvSaldoResultado, mTvGastosResultado;
    int movimiento = -1;
    float ingresoTotal;
    float gastoTotal;
    float saldo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTetDescripcion = view.findViewById(R.id.tetdescripcion);
        mTvEstado = view.findViewById(R.id.tvEstado);
        mTvEstado.setText("Gastos");
        mTvSaldoResultado = view.findViewById(R.id.tvSaldoResultado);
        mTvGastosResultado = view.findViewById(R.id.tvGastosResultado);
        mTvIngresosResultado = view.findViewById(R.id.tvIngresosResultado);
        mTetMonto = view.findViewById(R.id.tetmonto);
        mBtnRegistrar = view.findViewById(R.id.btnregistrar);
        mBtnRegistrar.setOnClickListener(this);
        mSwtEstado = view.findViewById(R.id.swtEstado);
        mTvMovimientoEstado = view.findViewById(R.id.tvMovimientoEstado);
        mSwtEstado.setOnClickListener(this);
        mostrarDatos();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnregistrar:
                crearRegistro();
                break;
            case R.id.swtEstado:
                cambiarEstado();
                break;
        }
    }

    private void cambiarEstado() {
        if(mSwtEstado.isChecked()){
            mTvEstado.setText("Ingresos");
            movimiento = 1;
        }
        else{
            mTvEstado.setText("Gastos");
            movimiento = -1;
        }
    }

    public void mostrarDatos() {

        DatosSQLite datosSqlLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSqlLite.sumarIngreso(datosSqlLite);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    float total = Float.parseFloat(cursor.getString(cursor.getColumnIndex("total")));
                    ingresoTotal = total;
                } while(cursor.moveToNext());
            }
        }
        cursor = datosSqlLite.sumarGasto(datosSqlLite);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    float total = Float.parseFloat(cursor.getString(cursor.getColumnIndex("total")));
                    gastoTotal = total;
                } while(cursor.moveToNext());
            }
        }

        saldo = ingresoTotal - gastoTotal;
        mTvIngresosResultado.setText("S/." + ingresoTotal);
        mTvGastosResultado.setText("S/." + gastoTotal);
        mTvSaldoResultado.setText("S/." + saldo);
    }

    private void crearRegistro() {
        String descripcion = mTetDescripcion.getText().toString();
        String monto = mTetMonto.getText().toString();
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        int autonumerico = datosSQLite.registrarMovimiento(datosSQLite,descripcion, Float.parseFloat(monto), movimiento);
        Toast.makeText(getActivity(),String.valueOf(autonumerico), Toast.LENGTH_SHORT).show();
        mTetDescripcion.setText("");
        mTetMonto.setText("");
        mTetDescripcion.requestFocus();
            }
}