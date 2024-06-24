package com.challenge.forohub.domain.perfil;

import com.challenge.forohub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Perfil")
@Table(name = "perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "perfiles")
    private List<Usuario> usuarios;

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Perfil [nombre=" + nombre + ", usuarios=" + usuarios + "]";
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        for (Usuario usuario : usuarios) {
            usuario.getPerfiles().add(this);
        }
    }


}
