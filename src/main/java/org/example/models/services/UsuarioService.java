package org.example.models.services;

import org.example.models.DAO.UsuarioDAOImpl;
import org.example.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioDAOImpl usuarioDAO;

    public UsuarioService(){}

    public void create(Usuario usuario){
        usuarioDAO.create(usuario);
    }

    public List<Usuario> readAll(){
        return usuarioDAO.readAllUsers();
    }

    public Usuario readOne(Long idUsuario){
        return usuarioDAO.readOne(idUsuario);
    }

    public void update(Usuario usuario){
        usuarioDAO.update(usuario);
    }

    public void delete(Long idUsuario){
        usuarioDAO.delete(idUsuario);
    }
}
