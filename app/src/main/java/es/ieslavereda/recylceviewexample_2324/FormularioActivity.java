package es.ieslavereda.recylceviewexample_2324;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import es.ieslavereda.recylceviewexample_2324.model.Profesion;
import es.ieslavereda.recylceviewexample_2324.model.ProfesionRepository;
import es.ieslavereda.recylceviewexample_2324.model.Usuario;

public class FormularioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        EditText nombre = findViewById(R.id.editTextNombre);
        EditText apellido = findViewById(R.id.editTextApellidos);
        Spinner spinner = findViewById(R.id.spinner);
        Button aceptar = findViewById(R.id.buttonAceptar);
        Button cancelar = findViewById(R.id.buttonCancelar);

        ArrayAdapter<Profesion> adaptadorSpinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ProfesionRepository.getInstance().getAll());
        spinner.setAdapter(adaptadorSpinner);

        cancelar.setOnClickListener(view -> {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED);
            finish();
        });

        aceptar.setOnClickListener(view -> {
            Intent intent = new Intent();
            String name = nombre.getText().toString();
            String surname = apellido.getText().toString();
            Profesion profesion = (Profesion) spinner.getSelectedItem();
            intent.putExtra("usuario",new Usuario(name,surname,profesion));
            setResult(RESULT_OK,intent);
            finish();
        });

    }
}
