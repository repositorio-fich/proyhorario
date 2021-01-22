
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
    private final String bd="b3ivhvjithvyjyj0jsup";
    private final String url="jdbc:postgresql://b3ivhvjithvyjyj0jsup-postgresql.services.clever-cloud.com:5432/"+bd;
    private final String user="uo48ex6kt9ythf2r0aae";
    private final String pass="cIFPCq9Uabr6SfnPwfh4";
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
