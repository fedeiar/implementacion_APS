package modelo;

import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    

    public static void createTables(Statement statement) throws Exception{
        // TODO: probar si anda el borrado y actualizado en cascada con lo de modificar plan.
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS carrera(" +
                "codigo INTEGER PRIMARY KEY," +
                "nombre STRING UNIQUE )" 
        );
        
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS plan(" +
                "anio INTEGER," + 
                "codigo_carrera INTEGER," +
                "PRIMARY KEY (anio, codigo_carrera)," +
                "FOREIGN KEY(codigo_carrera) REFERENCES carrera(codigo) ON DELETE CASCADE ON UPDATE CASCADE )"
        );
        
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS materia(" +
                "codigo INTEGER," +
                "nombre STRING," + 
                "PRIMARY KEY (codigo) )"
        );
        
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS plan_materia(" +
                "anio_plan INTEGER," +
                "codigo_carrera INTEGER," +
                "codigo_materia INTEGER," + 
                "PRIMARY KEY (anio_plan, codigo_carrera, codigo_materia)," +
                "FOREIGN KEY(anio_plan, codigo_carrera) REFERENCES plan(anio, codigo_carrera) ON DELETE CASCADE ON UPDATE CASCADE," +
                "FOREIGN KEY(codigo_materia) REFERENCES materia(codigo) ON DELETE CASCADE ON UPDATE CASCADE )"
        );
        
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS administrador(" +
                "email STRING," +
                "contrasenia CHAR(32)," +
                "nombre STRING," +
                "apellido STRING," +
                "legajo INTEGER AUTO_INCREMENT PRIMARY KEY )"
        );

        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS profesor(" +
                "email STRING," +
                "contrasenia CHAR(32)," +
                "nombre STRING," +
                "apellido STRING," +
                "legajo INTEGER AUTO_INCREMENT PRIMARY KEY )"
        );
        
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS alumno(" +
                "email STRING," +
                "contrasenia CHAR(32)," +
                "nombre STRING," +
                "apellido STRING," +
                "legajo INTEGER AUTO_INCREMENT PRIMARY KEY )"
        );
        
        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS inscripcion(" +
            "legajo_alumno INTEGER," +
            "anio_plan INTEGER," +
            "codigo_carrera INTEGER," +
            "PRIMARY KEY (legajo_alumno, anio_plan, codigo_carrera)," + 
            "FOREIGN KEY(legajo_alumno) REFERENCES alumno(legajo) ON DELETE CASCADE ON UPDATE CASCADE," +
            "FOREIGN KEY(anio_plan, codigo_carrera) REFERENCES plan(anio, codigo_carrera) ON DELETE CASCADE ON UPDATE CASCADE )"
        );

        statement.executeUpdate(
            "CREATE TABLE IF NOT EXISTS cursada(" +
            "codigo_materia INTEGER," +
            "legajo_profesor INTEGER," +
            "anio INTEGER," +
            "cuatrimestre INTEGER," +
            "PRIMARY KEY (legajo_profesor, anio, cuatrimestre)," + 
            "FOREIGN KEY(codigo_materia) REFERENCES materia(codigo) ON DELETE CASCADE ON UPDATE CASCADE," +
            "FOREIGN KEY(legajo_profesor) REFERENCES profesor(legajo) ON DELETE CASCADE ON UPDATE CASCADE )"
        );
    
        addInfoToDB();
    }

    private static void addInfoToDB() throws Exception {
        //TODO: si fernando nos dice algo, agregarle lo de md5 a las contraseñas.
        DatabaseImpl.saveAdmin(new Administrador("fulano1@gmail.com", "1234", "Pablo", "Suarez", 1));
        DatabaseImpl.saveAdmin(new Administrador("fulano2@gmail.com", "5678", "Juan", "Perez", 2));
        DatabaseImpl.saveStudent(new Alumno("fulano3@hotmail.com", "4321", "Rodrigo", "Gonzalez", 1));
        DatabaseImpl.saveStudent(new Alumno("fulano4@hotmail.com", "8765", "Patricio", "Rodriguez", 2));
        DatabaseImpl.saveCarrera(new Carrera("Licenciatura en Aprender a Leer",1));
        DatabaseImpl.saveCarrera(new Carrera("Licenciatura en Sumar Enteros", 2));
        DatabaseImpl.savePlan(new Plan(2012, 1));
        DatabaseImpl.savePlan(new Plan(2010, 2));
        DatabaseImpl.savePlan(new Plan(2022, 1));
    }

}
