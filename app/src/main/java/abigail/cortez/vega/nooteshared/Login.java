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
public class Login extends Fragment {
    EditText etUsuario, etPassword;
    Button btnEntrar, btnRegistrarse;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        etUsuario = (EditText) rootView.findViewById(R.id.etNombre);
        etPassword = (EditText) rootView.findViewById(R.id.etPassword);
        btnEntrar = (Button) rootView.findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(etUsuario.getText().toString(),etPassword.getText().toString());
            }
        });



        btnRegistrarse = rootView.findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new RegistrarUsuario()).commit();
            }
        });


        return rootView;


    }






        // Inflate the layout for this fragment


    private void Login(String usuario, String contra){
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url = "http://192.168.1.77/usuarios/verifica_usuario.php?usuario="+usuario+"&contrasena="+contra;


        StringRequest request = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Login.this.getActivity(),"respuesta "+response, Toast.LENGTH_LONG).show();


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error","error: "+error.getLocalizedMessage());
                        Toast.makeText(Login.this.getActivity(),"error:"+error.getMessage(), Toast.LENGTH_LONG).show();


                    }
                });
        queue.add(request);


    }


}
