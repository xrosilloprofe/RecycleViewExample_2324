package es.ieslavereda.recylceviewexample_2324;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.recylceviewexample_2324.model.Profesion;
import es.ieslavereda.recylceviewexample_2324.model.ProfesionRepository;
import es.ieslavereda.recylceviewexample_2324.model.Usuario;
import es.ieslavereda.recylceviewexample_2324.model.UsuarioRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recycler;
    private Switch switchSort;
    private FloatingActionButton addUser;
    private Button listButton;
    private Button gridButton;
    private boolean isLinear;
    AdaptadorRecycleView adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);
        switchSort = findViewById(R.id.switchSort);
        addUser = findViewById(R.id.addUser);
        listButton = findViewById(R.id.listButton);
        gridButton = findViewById(R.id.gridButton);
        isLinear=true;

        adaptador = new AdaptadorRecycleView(this);
        adaptador.setOnClickListener(this);
        recycler.setAdapter(adaptador);
        updateRecycle();

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result->{
                    if(result.getResultCode()==RESULT_CANCELED)
                        Toast.makeText(this,"Alta cancelada",Toast.LENGTH_SHORT).show();
                    else if (result.getResultCode()==RESULT_OK) {
                        Usuario usuario = (Usuario) result.getData().getExtras().get("usuario");
                        UsuarioRepository.getInstance().add(usuario);
                        adaptador.notifyDataSetChanged();
                    }
                }
        );

        addUser.setOnClickListener(view -> {
            Intent intent = new Intent(this, FormularioActivity.class);
            activityResultLauncher.launch(intent);
        });

        switchSort.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked){
                switchSort.setText("Profesión");
                UsuarioRepository.getInstance().sort(Usuario.SORT_BY_JOB);
            } else {
                switchSort.setText("Nombre");
                UsuarioRepository.getInstance().sort(Usuario.SORT_BY_NAME);
            }
            adaptador.notifyDataSetChanged();
        });

        listButton.setOnClickListener(view -> {
            isLinear=true;
            updateRecycle();
        });

        gridButton.setOnClickListener(view -> {
            isLinear=false;
            updateRecycle();
        });


    }

    @Override
    public void onClick(View view) {
        Usuario usuario = UsuarioRepository.getInstance()
                .get(recycler.getChildAdapterPosition(view));
        Toast.makeText(this,"Has seleccionado el usuario " + usuario.getNombre()
        ,Toast.LENGTH_SHORT).show();
    }

    public void updateRecycle(){
        if(isLinear){
            adaptador.setLayout_displayed(R.layout.simple_element_list);
            recycler.setLayoutManager(new LinearLayoutManager(this));
        } else {
            adaptador.setLayout_displayed(R.layout.simple_element_grid);
            recycler.setLayoutManager(new GridLayoutManager(this,2));
        }
        recycler.getRecycledViewPool().clear();
    }
}