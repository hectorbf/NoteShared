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
public class RegistrarUsuario extends Fragment {
    EditText etNombre, etUsuario, etPassword;
    Button btnRegistrar;


    public RegistrarUsuario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_registrar_usuario, container, false);
        etNombre = (EditText) rootView.findViewById(R.id.etNombre);
        etUsuario = (EditText) rootView.findViewById(R.id.etUsuario);
        etPassword = (EditText) rootView.findViewById(R.id.etPassword);
        btnRegistrar = (Button) rootView.findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarUsuario(etNombre.getText().toString(),etUsuario.getText().toString(),etPassword.getText().toString());

            }


        });

        // Inflate the layout for this fragment
        return rootView;

    }




    private void RegistrarUsuario(String nombre, String usuario, String contrasena){
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "http://192.168.1.77/usuarios/registrar_usu.php?nombre="+nombre+"&usuario="+usuario+"&contrasena="+contrasena;

        StringRequest request = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegistrarUsuario.this.getActivity(),"respuesta "+response, Toast.LENGTH_LONG).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error","error: "+error.getLocalizedMessage());
                        Toast.makeText(RegistrarUsuario.this.getActivity(),"error:"+error.getMessage(), Toast.LENGTH_LONG).show();


                    }
                });
        queue.add(request);

    }

}
