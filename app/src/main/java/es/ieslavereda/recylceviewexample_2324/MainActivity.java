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
import es.ieslavereda.recylceviewexample_2324.model.ProfesionRepository;
import es.ieslavereda.recylceviewexample_2324.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private Switch switchSort;
    private FloatingActionButton addUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        switchSort = findViewById(R.id.switchSort);
        addUser = findViewById(R.id.addUser);

        ProfesionRepository profesiones = ProfesionRepository.getInstance();




        AdaptadorRecycleView adaptador = new AdaptadorRecycleView(this);
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(this));


    }
}