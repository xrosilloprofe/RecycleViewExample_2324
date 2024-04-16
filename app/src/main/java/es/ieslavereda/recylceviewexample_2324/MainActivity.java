package es.ieslavereda.recylceviewexample_2324;

import android.os.Bundle;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.recylceviewexample_2324.model.Profesion;
import es.ieslavereda.recylceviewexample_2324.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private Switch switchSort;
    private FloatingActionButton addUser;
    private List<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        switchSort = findViewById(R.id.switchSort);
        addUser = findViewById(R.id.addUser);

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ian","Navarro García",
                new Profesion(R.mipmap.ic_actor_foreground,"actor")));
        usuarios.add(new Usuario("Carlos","Navarro García",
                new Profesion(R.mipmap.ic_albanyil_foreground,"albañil")));
        usuarios.add(new Usuario("Salman","Navarro García",
                new Profesion(R.mipmap.ic_politico_activo_foreground,"político activo")));
        usuarios.add(new Usuario("Vicent","Navarro García",
                new Profesion(R.mipmap.ic_politico_retirado_foreground,"político retirado")));
        usuarios.add(new Usuario("Alejandro","Navarro García",
                new Profesion(R.mipmap.ic_youtuber_foreground,"youtuber")));
        usuarios.add(new Usuario("Santi","Navarro García",
                new Profesion(R.mipmap.ic_pintor_foreground,"pintor")));
        usuarios.add(new Usuario("Jesús","Navarro García",
                new Profesion(R.mipmap.ic_instagramer_foreground,"instagramer")));


        AdaptadorRecycleView adaptador = new AdaptadorRecycleView(this,usuarios);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(this));


    }
}