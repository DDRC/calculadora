package com.example.miprimeraaplicacin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText N1;
    private EditText N2;
    private TextView Res;
    private RadioGroup Operacion;
    private RadioButton RadioOp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //enlaza los componentes de la interfaz visual(MainActivity.xml) con variables en java(MainActivity.java)
        N1=(EditText)findViewById(R.id.Numero1);
        N2=(EditText)findViewById(R.id.Numero2);
        Res=(TextView)findViewById(R.id.Resultado);
        Operacion=(RadioGroup) findViewById(R.id.operaciones);
        RadioButton add = (RadioButton) findViewById(R.id.Suma);
        RadioButton dif=(RadioButton) findViewById(R.id.Resta);
        RadioButton mul=(RadioButton) findViewById(R.id.Producto);
        RadioButton div=(RadioButton) findViewById(R.id.Dividir);
        //añade listeners a los radioButtons
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                N1.setText("");
                N2.setText("");
                N1.setHint("Sumando *");
                N2.setHint("Sumando *");
                Res.setText("El Resultado de la operación es...");
            }
        });
        dif.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                N1.setText("");
                N2.setText("");
                N1.setHint("Minuendo *");
                N2.setHint("Sustraendo *");
                Res.setText("El Resultado de la operación es...");
            }
        });
        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                N1.setText("");
                N2.setText("");
                N1.setHint("Factor *");
                N2.setHint("Factor *");
                Res.setText("El Resultado de la operación es...");
            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                N1.setText("");
                N2.setText("");
                N1.setHint("Dividendo *");
                N2.setHint("Divisor *");
                Res.setText("El Resultado de la operación es...");
            }
        });
    }
//El siguiente metodo realizara las operaciones dependiendo de la respuesta
    public void Operar(View view){
        //obtinen los balores de los radiosButtons y los textviews 
        String Valor1=N1.getText().toString();
        String Valor2=N2.getText().toString();
        int Num1=Integer.parseInt(Valor1);
        int Num2=Integer.parseInt(Valor2);
        int RadioId = Operacion.getCheckedRadioButtonId();
        RadioOp=findViewById(RadioId);
        String Resultado;
        CharSequence text = RadioOp.getText();
        //pregunta por valores nulos en los textviews y realiza las operaciones
        if(Valor1.equals("") && Valor2.equals("")) {
            if ("Sumar".equals(text)) {
                int Suma = Num1 + Num2;
                Resultado = String.valueOf(Suma);
                Res.setText(Resultado);
            } else if ("Restar".equals(text)) {
                int Resta = Num1 - Num2;
                Resultado = String.valueOf(Resta);
                Res.setText(Resultado);
            } else if ("Multiplicar".equals(text)) {
                int Producto = Num1 * Num2;
                Resultado = String.valueOf(Producto);
                Res.setText(Resultado);
            } else if ("Dividir".equals(text)) {
                if (Num2 == 0) {
                    Toast.makeText(this, "No se puede realizar una divición para 0", Toast.LENGTH_LONG).show();
                } else {
                    int Divicion = Num1 / Num2;
                    Resultado = String.valueOf(Divicion);
                    Res.setText(Resultado);
                }
            }
        }else{
            Toast.makeText(this, "Ingrese valores en los cuadros de texto", Toast.LENGTH_LONG).show();
        }
    }
}
