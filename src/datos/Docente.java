
package datos;
public class Docente {
    private int id;
    private int codigo;
    private String nombre;
    private String apellido;
    private String profesion;
    private String ci;
    private String sexo;
    private String telefono;

    public Docente() {
        this.id = 0;
        this.codigo = 0;
        this.nombre = "";
        this.apellido = "";
        this.profesion = "";
        this.ci = "";
        this.sexo = "";
        this.telefono = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    
    public String insertar()
    {
        return "INSERT INTO docente (codigo,nombre, apellido, profesion, ci, sexo, telefono) VALUES ("+codigo+",'"+nombre+"','"+apellido+"','"+profesion+"','"+ci+"','"+sexo+"','"+telefono+"');";
    }
    public String actualizar()
    {
        return "UPDATE docente SET codigo="+codigo+",nombre='"+nombre+"', apellido='"+apellido+"',"+profesion+", ci='"+ci+"', sexo='"+sexo+"', telefono='"+telefono+"' WHERE id="+id+";";
    }        
    public String eliminar()
    {
        return "DELETE from docente WHERE id="+id+";";
    }        
    public String buscar()
    {
        return "SELECT * FROM docente;";
    }
    
}
