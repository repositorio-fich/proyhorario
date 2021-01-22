
package negocio;
import core.Conexion;
import datos.Docente;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NDocente {
    Docente doc =new Docente();
    private final Conexion cnx;
    DefaultTableModel model;
    
    public NDocente() {
        cnx=new Conexion();
    }
    
    public void desconectar(){
        cnx.desconectar();
    }
    
    public void insertarDocente(int codigo, String nombre, String apellido,String profesion, String ci, String sexo, String telefono) {
        
        doc.setCodigo(codigo);
        doc.setNombre(nombre);
        doc.setApellido(apellido);
        doc.setProfesion(profesion);
        doc.setCi(ci);
        doc.setSexo(sexo);
        doc.setTelefono(telefono);
        cnx.ejectarComando(doc.insertar());
    }
    
    public void buscarDocente(JTable tablaEstudiante) {
        try {
            String [] titulos = {"ID","COD","NOMBRES","APELLIDOS","PROFESION","CI","SEXO","TELEFONO"};
            model = new DefaultTableModel(null, titulos);
            
            ResultSet rs=cnx.ejecutarConsulta(doc.buscar());
            ResultSetMetaData datos = rs.getMetaData();
            
            int nc=datos.getColumnCount();
            
            while (rs.next()) {
                Object f []= new Object [nc];
                for(int i=0;i<nc;i++){
                    f[i]=rs.getObject(i+1);
                }
                model.addRow(f);
            }
            tablaEstudiante.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar clientes!\n"+ex.getMessage());
        }
    }
    
    public  void actualizarDocente(int id,int codigo, String nombre, String apellido,String profesion, String ci, String sexo, String telefono) {
        doc.setId(id);
        doc.setCodigo(codigo);
        doc.setNombre(nombre);
        doc.setApellido(apellido);
        doc.setProfesion(profesion);
        doc.setCi(ci);
        doc.setSexo(sexo);
        doc.setTelefono(telefono);
        
        cnx.ejectarComando(doc.actualizar() );
    }
    
    public void eliminarDocente(int id) {
        doc.setId(id);
        cnx.ejectarComando(doc.eliminar());
    }
    
}
