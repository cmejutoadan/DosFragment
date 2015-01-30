package com.example.cmejuto.dosfragment;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    View view;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            // Inflate the layout for this fragment

            //guardo el inflater en un objeto de tipo view
            //en el código original no viene instanciado el objeto vista, sino que sólo lo devuelve
            view = inflater.inflate(R.layout.fragment_a, container, false);


        //retorno la vista
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button b = (Button) getView().findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast toast= Toast.makeText(getView().getContext(), "me has pulsado", Toast.LENGTH_LONG);
                //toast.show();

                
                //pregunto la orientación
                //seleccionamos según la orientación
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    //intent para pasar a la activity 2
                    // al lanzarlo desde un fragment se pone getActivity en vez de clase.this
                    Intent intent = new Intent(getActivity(), Activity2.class);
                    startActivity(intent);

                    Log.d("Pulsar boton", "ok");
                } else {
                    //Cargamos el layout activity_main
                    getFragmentManager().beginTransaction()
                            //container es el id del activity que contiene el fragment. OJO! hay que ponerle el id, no tiene por defecto en activity_main.xml.
                            //android:id="@+id/container"
                            .add(R.id.container2, new FragmentB()) //añadimos el fragmentb al container
                            .commit();

                }
            }
        });

    }
}






