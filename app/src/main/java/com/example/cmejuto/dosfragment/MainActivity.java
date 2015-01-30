package com.example.cmejuto.dosfragment;

import android.app.Activity;

import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //desde el oncreate tenemos que cargar el fragment

            getFragmentManager().beginTransaction()
                    //container es el id del activity que contiene el fragment. OJO! hay que ponerle el id, no tiene por defecto en activity_main.xml.
                    //android:id="@+id/container"
                    .add(R.id.container, new FragmentA()) //añadimos el fragmentA al container
                    .commit();
        }

    }


