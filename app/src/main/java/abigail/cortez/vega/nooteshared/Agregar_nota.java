package abigail.cortez.vega.nooteshared;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * A simple {@link Fragment} subclass.
 */
public class Agregar_nota extends Fragment {
    EditText etTitulo, etMensaje;
    Button btnAgregar, btnLimpiar;

    public Agregar_nota() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_agregar_nota, container, false);
        etTitulo = (EditText) rootView.findViewById(R.id.etTitulo);
        etMensaje = (EditText) rootView.findViewById(R.id.etNota);
        btnAgregar = (Button) rootView.findViewById(R.id.button);
        btnLimpiar = (Button) rootView.findViewById(R.id.button2);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Agregar_nota(etTitulo.getText().toString(),etMensaje.getText().toString());
            }
        });



        // Inflate the layout for this fragment
        return rootView;

    }


    private void Agregar_nota(String titulo, String mensaje){
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "http://192.168.1.77/usuarios/guardar.php?titulo="+titulo+"&mensaje="+mensaje;

        StringRequest request = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Agregar_nota.this.getActivity(),"respuesta "+response, Toast.LENGTH_LONG).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error","error: "+error.getLocalizedMessage());
                        Toast.makeText(Agregar_nota.this.getActivity(),"error:"+error.getMessage(), Toast.LENGTH_LONG).show();


                    }
                });
        queue.add(request);

    }

}
