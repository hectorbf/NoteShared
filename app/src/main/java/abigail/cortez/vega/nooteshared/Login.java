package abigail.cortez.vega.nooteshared;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
        View vista= inflater.inflate(R.layout.fragment_login, container, false);

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        etUsuario = (EditText) rootView.findViewById(R.id.etNombre);
        etPassword = (EditText) rootView.findViewById(R.id.etPassword);

        btnRegistrarse = vista.findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new RegistrarUsuario()).commit();
            }
        });


        return vista;
    }


}
