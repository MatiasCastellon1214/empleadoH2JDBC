package com.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Empleado {
    public static void main(String[] args) throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/my","root","myPassword");
        Statement stmt = con.createStatement();

        // Creamos tabla, eliminamos en caso de existir y volvemos a cargar

        String createSql = "DROP TABLE IF EXISTS EMPLEADO;\n"+
                "CREATE TABLE EMPLEADO(ID INT PRIMARY KEY, NAME VARCHAR(255), EMPRESA VARCHAR(255), FECHAINICIO VARCHAR(255));\n"+
                "INSERT INTO EMPLEADO VALUES(1, 'Jaimito Pérez', 'Digital', '2005-05-08');\n"+
                "INSERT INTO EMPLEADO VALUES(2, 'Cuis Maceiro', 'Google', '1993-03-16');\n"+
                "INSERT INTO EMPLEADO VALUES(3, 'Jorge Nitales', 'Facebook', '2022-01-01');\n";
        stmt.execute(createSql);

        String sql = "SELECT * FROM EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        while (rd.next()){
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3) + rd.getString(4));
        }
    }
}
