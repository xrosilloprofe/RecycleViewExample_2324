package es.ieslavereda.recylceviewexample_2324;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.recylceviewexample_2324.model.Usuario;

public class AdaptadorRecycleView
        extends RecyclerView.Adapter<AdaptadorRecycleView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Usuario> usuarios;
    public AdaptadorRecycleView(Context context, List<Usuario> usuarios){
        layoutInflater =
        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.usuarios=usuarios;
    }

    // Creamos el ViewHolder con la vista de un elemento sin personalizar
    @NonNull
    @Override
    public AdaptadorRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.simple_element,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecycleView.ViewHolder holder, int position) {
        Usuario usuario= usuarios.get(position);
        holder.profesion.setText(usuario.getProfesion().getNombre());
        holder.nombre.setText(usuario.getApellidos() + ", " +
                usuario.getNombre());
        holder.imagen.setImageResource(usuario.getProfesion().getImage());
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView nombre, profesion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imageView);
            nombre = itemView.findViewById(R.id.textViewNombre);
            profesion = itemView.findViewById(R.id.textViewOficio);
        }
    }
}
