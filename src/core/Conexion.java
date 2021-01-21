
package core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class Conexion {
    private final String bd="app_curso_git";
    private final String url="jdbc:postgresql://localhost:5432/"+bd;
    private final String user="postgres";
    private final String pass="439158";
    private Connection cnx=null;
      
    public Conexion(){
        conectar(); 
    }
    
    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            cnx= DriverManager.getConnection(url, user, pass);
        }catch (ClassNotFoundException | SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error en la conexion!\n" + e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return cnx; 
    }
    
    public void ejectarComando(String Comando) {
        try {
            Statement Cmd = cnx.createStatement();
            Cmd.execute(Comando);
        }catch (SQLException err) {
            System.out.println("Error al intentar ejecutar comando: " + err);
        }
    }
    
    public ResultSet ejecutarConsulta(String Consulta){
        ResultSet res = null;
        try {
            Statement stmt = cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            res = stmt.executeQuery(Consulta);  
        }catch (SQLException err) {
            System.out.println("Error al intentar ejecutar consulta: " + err);
        }
        return res;
    }
}
