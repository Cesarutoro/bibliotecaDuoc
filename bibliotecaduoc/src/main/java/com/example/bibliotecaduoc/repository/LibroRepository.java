package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {

    // Arreglo que guardará todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    //Arreglo que retorna todos los libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    //Metodo que retorna libro por su id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    //Metodo que retorna libro por su ibn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    //Metodo que guarda libro en arreglo y retorna libro
    public Libro guardar(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }

    //Metodo que actualiza el libro por el id, retorna libro actualizado
    public Libro actualizar(Libro nuevoLibro){
        for (Libro libro : listaLibros) {
            if(libro.getId() == nuevoLibro.getId()){
                libro.setId(nuevoLibro.getId());
                libro.setTitulo(nuevoLibro.getTitulo());
                libro.setAutor(nuevoLibro.getAutor());
                libro.setFechaPublicacion(nuevoLibro.getFechaPublicacion());
                libro.setEditorial(nuevoLibro.getEditorial());
                libro.setIsbn(nuevoLibro.getIsbn());
                return libro;
            }
        }
        System.out.println("El libro no existe!, usar guardar libro!");
        return null;
    }

    //Metodo que borra el libro por su id
    public Libro eliminar(int id) {
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
            return libro; // Retorna el libro eliminado
        }
        return null; // Si no se encontró el libro
    }

}
