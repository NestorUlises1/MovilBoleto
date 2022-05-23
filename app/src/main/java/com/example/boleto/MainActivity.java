package com.example.boleto;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Spinner spnPaises;
    private EditText etnombre;
    private Button btnresivo;
    private RadioButton radioButton1, radioButton2;
    private DatePicker dpfecha;
    private String destino;
    private TextView lblBoletoDatos;
    private EditText txtedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnPaises =(Spinner) findViewById(R.id.spnPaises);
        etnombre=(EditText) findViewById(R.id.txtNombre);
        btnresivo=(Button) findViewById(R.id.btnResivo);
        dpfecha=(DatePicker) findViewById(R.id.dpFecha);
        radioButton1=(RadioButton) findViewById(R.id.rbSencillo);
        radioButton2=(RadioButton) findViewById(R.id.rbDoble);
        lblBoletoDatos=(TextView) findViewById(R.id.lblBoletoDatos);
        txtedad=(EditText) findViewById(R.id.txtEdad);
        ArrayAdapter<String> Adaptador=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,getResources().getStringArray(R.array.paises));
        spnPaises.setAdapter(Adaptador);
        spnPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Selecciono el pais " + adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                destino=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }});
        btnresivo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nombre=etnombre.getText().toString();
                int edad= Integer.parseInt(txtedad.getText().toString());
                int year=dpfecha.getYear();
                int mes=dpfecha.getMonth()-1;
                int dia=dpfecha.getDayOfMonth();
                Date fecha=new Date(year,mes,dia);
                int tipoViaje;
                if(radioButton1.isChecked()==true){
                    tipoViaje=1;
                }
                else{
                    tipoViaje=2;
                }
                Boleto boleto=new Boleto(nombre,destino,tipoViaje,fecha);
                lblBoletoDatos.setText(boleto.toString()+"\nSubtotal: " +boleto.calcularSubtotal()
                        +"\nImpuesto: "+boleto.calcularImpuesto()+
                        "\nDescuento: "+boleto.calcularDescuento(edad));
            }
        });
    }
}