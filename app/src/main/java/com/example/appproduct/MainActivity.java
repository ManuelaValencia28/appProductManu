package com.example.appproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    //instanciar elementos conm id
    EditText reference, description, coste;
    Spinner refType;
    ImageButton save, search, edit, delete, list;
    TextView message;

    //Definir el array para llenar el spinner
    //Es un Arreglo global

    String[] arrayTypeRef= {"Cosmestible", "No comestible"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // debemos referenciar estos objetos con los id respectivcamnete
        reference = findViewById(R.id.editReference);
        description = findViewById(R.id.editDescription);
        coste = findViewById(R.id.editPrice);
        refType = findViewById(R.id.spRefType);
        save = findViewById(R.id.idSave);
        search = findViewById(R.id.idSearch);
        edit = findViewById(R.id.idEdit);
        delete = findViewById(R.id.idDelete);
        list = findViewById(R.id.idList);
        message = findViewById(R.id.tvMessage);
        //Definir un array Adapter para llenar el spinner
        ArrayAdapter<String> adpTypeRef = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, arrayTypeRef);
        //Asignar el adaptador al Sppiner
        refType.setAdapter(adpTypeRef);

        //EVENTOS DE CADA BOTON
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mRef = reference.getText().toString(); //tomando el contenido de este objeto referenciado
                String mDesc = description.getText().toString();
                String mPrice = coste.getText().toString();
               if( checkData(mRef, mDesc, mPrice)){
                   searchReference(mRef);

                }
               else{
                   message.setTextColor(Color.RED);
                   message.setText("Debe ingresar todos los datos...");
                }
            }
        });
    }

    private boolean searchReference(String mRef) {
    }

    private boolean checkData(String mRef, String mDesc, String mPrice) {

    return !mRef.isEmpty() && !mDesc.isEmpty() && !mPrice.isEmpty();

    }

}