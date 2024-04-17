package es.ieslavereda.recylceviewexample_2324.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.ieslavereda.recylceviewexample_2324.R;

public class UsuarioRepository {
    private List<Usuario> usuarios;
    private static UsuarioRepository instance;

    private UsuarioRepository(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ian","Navarro García",
                ProfesionRepository.getInstance().get(0)));
        usuarios.add(new Usuario("Carlos","Navarro García",
                ProfesionRepository.getInstance().get(1)));
        usuarios.add(new Usuario("Salman","Navarro García",
                ProfesionRepository.getInstance().get(2)));
        usuarios.add(new Usuario("Vicent","Navarro García",
                ProfesionRepository.getInstance().get(3)));
        usuarios.add(new Usuario("Alejandro","Navarro García",
                ProfesionRepository.getInstance().get(4)));
        usuarios.add(new Usuario("Santi","Navarro García",
                ProfesionRepository.getInstance().get(5)));
        usuarios.add(new Usuario("Jesús","Navarro García",
                ProfesionRepository.getInstance().get(6)));
    }

    public static UsuarioRepository getInstance(){
        if(instance==null)
            instance=new UsuarioRepository();
        return instance;
    }

    public Usuario get(int index){
        return usuarios.get(index);
    }
    public List<Usuario> getAll(){ return usuarios;}

    public int size(){return usuarios.size();}

    public void remove(Usuario usuario){ usuarios.remove(usuario);}
    public void add(Usuario usuario){usuarios.add(usuario);}
    public void add(Usuario usuario, int index){
        usuarios.add(index,usuario);
    }

    public void sort(Comparator comparator){
        Collections.sort(usuarios,comparator);
    }



}
