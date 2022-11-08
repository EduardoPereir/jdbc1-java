package application;

import java.sql.*;

public class Main {
    public static void main(String[] args)  {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdatabase", "root", "eduardop$filho");
            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }

        try {
            if( rs != null){
            rs.close();}
            if (st != null){
            st.close();}
            if (conn != null){
            conn.close();}
            
        }catch (SQLException e ){
            throw new RuntimeException(e.getMessage());
        }
    }
}