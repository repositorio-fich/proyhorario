package main;
/** @author alfreding0 */
import core.Conexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import presentacion.FormDocente;
//import presentacion.FormEstudiante;

public class Main {
    
    static void buscarEstudiante(Conexion cnx) {
        try {   
            String cadena= "";
            ResultSet rs=cnx.ejecutarConsulta("SELECT * from estudiante");
            ResultSetMetaData datos = rs.getMetaData();
            int nc=datos.getColumnCount();
            while (rs.next()) {
                for(int i=0;i<nc;i++)cadena= cadena+rs.getObject(i+1)+" ";
                cadena= cadena+"\n";
            }
            System.out.println(cadena);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar clientes!\n"+ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
          Conexion cnx = new Conexion();
          cnx.ejectarComando("INSERT INTO estudiante (nombre, apellido, ci, sexo, telefono) VALUES ('Cecilio','Riojas Aguillera','83424','M','6984165')");
          buscarEstudiante(cnx);
        //FormEstudiante e = new FormEstudiante();
        //e.setVisible(true);
        
        //FormDocente d = new FormDocente();
        //d.setVisible(true);
    }
}
