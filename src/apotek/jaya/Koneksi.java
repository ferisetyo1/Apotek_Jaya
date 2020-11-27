/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.jaya;

/**
 *
 * @author dbss134
 */
  import java.sql.Connection;   
  import java.sql.DriverManager;   
  import java.sql.SQLException;   
  /**   
  * @author Wahidin-Alambiyah   
  */   
  public class Koneksi {   
   private static Connection connect;   
   private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   static private String AlamatKoneksi = "jdbc:sqlserver://localhost:1433;"  + "database=ApotekJaya;";
   static private String username = "sa";
   static private String password = "feri";   
   public static Connection getKoneksi(){   
    if (connect == null) {   
     try {   
      Class.forName(driverName);   
      System.out.println("Class Driver Ditemukan");   
      try {   
       connect = DriverManager.getConnection(AlamatKoneksi, username, password);   
       System.out.println("Koneksi Database Sukses");   
      } catch (SQLException se) {   
       System.out.println("Koneksi Database Gagal : " + se);   
       System.exit(0);   
      }   
     } catch (ClassNotFoundException cnfe) {   
      System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);   
      System.exit(0);   
     }   
    }   
    return connect;   
   }   
  }   
