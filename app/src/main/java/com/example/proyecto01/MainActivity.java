package com.example.proyecto01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09, btn00, btnBorrar;
    RadioButton rbt01, rbt02, rbt03, rbt04, rbt05, rbt06;
    StringBuilder clave;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        clave = new StringBuilder();
        contador = 0;

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);
        btn04 = findViewById(R.id.btn04);
        btn05 = findViewById(R.id.btn05);
        btn06 = findViewById(R.id.btn06);
        btn07 = findViewById(R.id.btn07);
        btn08 = findViewById(R.id.btn08);
        btn09 = findViewById(R.id.btn09);
        btn00 = findViewById(R.id.btn00);
        btnBorrar = findViewById(R.id.btnBorrar);

        // Asignar un OnClickListener para cada botón
        btn01.setOnClickListener(onClickListener);
        btn02.setOnClickListener(onClickListener);
        btn03.setOnClickListener(onClickListener);
        btn04.setOnClickListener(onClickListener);
        btn05.setOnClickListener(onClickListener);
        btn06.setOnClickListener(onClickListener);
        btn07.setOnClickListener(onClickListener);
        btn08.setOnClickListener(onClickListener);
        btn09.setOnClickListener(onClickListener);
        btn00.setOnClickListener(onClickListener);

    }

    // OnClickListener común para todos los botones
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String numero = btn.getText().toString();
            clave.append(numero); // Agregar el número pulsado a la variable
            contador++;
            if (contador == 6) { // Si se han pulsado seis números
                mostrarClave();
                clave.setLength(0); // Limpiar la clave
                contador = 0; // Reiniciar contador
            }
        }
    };

    // Método para mostrar la clave con un Toast
    private void mostrarClave() {
        Toast.makeText(getApplicationContext(), "La clave es: " + clave.toString(), Toast.LENGTH_LONG).show();
    }
}