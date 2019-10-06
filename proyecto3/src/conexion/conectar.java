package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author coque
 */
public class conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/proyecto3";
    private static String values ;
    private static String tabla;
    private PreparedStatement ps;
    public conectar(String values,String tabla)
    {
        ps=null;
        conn=null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null){
                System.out.println("conexion exitosa..");
                ps = conn.prepareStatement("INSERT INTO"+" "+tabla+"(temperatura,fecha,id_lote)"+"values"+"(" +values+ ")");
                ps.executeUpdate();
                        }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error en la consulta"+e);
        }
        
            
    }
    
}
