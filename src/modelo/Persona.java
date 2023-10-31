package modelo;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String apellidos;
    private String empresa;
    private String telefono;
    private String correo;
    private String genero;
    public static ArrayList <Persona> personaArray = new ArrayList<>();


    public Persona(String nombre, String apellidos, String empresa, String telefono, String correo, String genero){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.empresa = empresa;
        this.telefono = telefono;
        this.correo = correo;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nApellidos: " + apellidos + "\nEmpresa: " + empresa + "\nTelefono: "+ telefono +
                "\nCorreo: " + correo + "\nGenero: " + genero;
    }
}
