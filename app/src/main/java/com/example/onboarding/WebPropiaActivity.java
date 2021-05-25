package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class WebPropiaActivity extends AppCompatActivity {

    ArrayList arrayList = new ArrayList<HashMap<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_propia);
        leerDatos();
    }

    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://pagina.great-site.net/hardward.php?i=1";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("DATOS", response);
                        llenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS", error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void llenarLista(String response) {
        try {
            JSONArray jsonArray = new JSONArray(response);

            for(int i = 0 ; i< jsonArray.length(); i++){
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String marca = jsonArray.getJSONObject(i).getString("marca");
                String precio = jsonArray.getJSONObject(i).getString("precio");
                String stock = jsonArray.getJSONObject(i).getString("stock");
                HashMap<String,String> map = new HashMap<>();
                map.put("nombre",nombre);
                map.put("marca",marca);
                map.put("precio",precio);
                map.put("stock",stock);
                arrayList.add(map);
            }
            ListView mlvProductos = findViewById(R.id.lvProductos);

            String[] datos = {"nombre", "marca","precio","stock"};
            int[] ids = {R.id.tvNombre, R.id.tvMarca, R.id.tvPrecio, R.id.tvStock};

            ListAdapter listAdapter = new SimpleAdapter(
                    this,
                    arrayList,
                    R.layout.item_dato_web_propia,
                    datos,
                    ids
            );

            mlvProductos.setAdapter(listAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}