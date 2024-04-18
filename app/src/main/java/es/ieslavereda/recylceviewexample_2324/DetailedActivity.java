package es.ieslavereda.recylceviewexample_2324;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ieslavereda.recylceviewexample_2324.model.Profesion;
import es.ieslavereda.recylceviewexample_2324.model.Usuario;

public class DetailedActivity extends AppCompatActivity {
    private ImageView imagen;
    private TextView nombre, profesion;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        imagen = findViewById(R.id.imageView_detailed);
        nombre = findViewById(R.id.textViewNombre_detailed);
        profesion = findViewById(R.id.textViewOficio_detailed);
        back = findViewById(R.id.buttonBack);

        Bundle extras = getIntent().getExtras();
        Usuario usuario = (Usuario) extras.get("usuari");
        if (usuario==null)
            usuario = new Usuario("Sin nombre","Sin apellido", new Profesion("actor",1));

        imagen.setImageResource(usuario.getProfesion().getImage());
        nombre.setText(usuario.getNombre() + " " + usuario.getApellidos());
        profesion.setText(usuario.getProfesion().getNombre());

        back.setOnClickListener(view -> finish());

    }
}
