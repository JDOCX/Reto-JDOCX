import java.util.Date;

public class Socios {
    public int id;
    public String dni, nombre, primerApellido, segundoApellido, correo, fechaNacimiento, telefono;


    public Socios(int id, String dni, String nombre, String primerApellido, String segundoApellido, String correo, String fechaNacimiento, String telefono ){
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }
}
