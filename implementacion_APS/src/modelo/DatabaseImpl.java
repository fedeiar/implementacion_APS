
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl{

    public static void createDatabase(){
        Statement statement = null;
        try {
            statement = connectToDB();

            TableCreator.createTables(statement);
            
            closeConnection(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static ArrayList<Carrera> getCarreras() throws Exception{
        ArrayList<Carrera> carreras = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connectToDB();
            if(statement != null){
                ResultSet resultSet = statement.executeQuery("select * from carrera");
                while (resultSet.next()){
                    carreras.add(new Carrera(resultSet.getString("nombre"), resultSet.getInt("codigo")));
                }
            }
        } catch(SQLException e){
            throw new Exception("An error occurred while recovering carreers.");
        } finally{
            closeConnection(statement);
        }
        return carreras;
    }

    public static int getCodigoCarrera(String nombreCarrera) throws Exception{
        int codigoCarrera = -1;
        try{
            Statement statement = connectToDB();

            ResultSet resultSet = statement.executeQuery("select * from carrera WHERE nombre = '" + nombreCarrera + "'");
            if(resultSet.next()){
                codigoCarrera = resultSet.getInt("codigo");
            }

            closeConnection(statement);
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred while recovering admin.");
        } 
        return codigoCarrera;
    }

    public static String getNombreCarrera(int codigoCarrera) throws Exception{
        String nombreCarrera = "";
        try{
            Statement statement = connectToDB();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM carrera WHERE codigo = '" + codigoCarrera + "'");
            if(resultSet.next()){
                nombreCarrera = resultSet.getString("nombre");
            }

            closeConnection(statement);
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred while recovering admin.");
        } 
        return nombreCarrera;
    }

    public static void saveCarrera(Carrera carrera) throws Exception {
        Statement statement = null;
        try{
            statement = connectToDB();
            if (statement != null) {
                statement.executeUpdate("replace into carrera values('" + carrera.codigo + "', '" + fixIncompatibleSyntax(carrera.nombre) + "')");
            }
        } catch(SQLException e){
            throw new Exception("An error occurred during saving.");
        } finally {
            closeConnection(statement);
        }
    }


    public static Administrador getAdmin(int legajo_administrador) throws Exception{
        Administrador admin = null;
        try{
            Statement statement = connectToDB();

            ResultSet resultSet = statement.executeQuery("select * from administrador WHERE legajo = '" + legajo_administrador + "'");
            if(resultSet.next()){
                admin = new Administrador(resultSet.getString("email"), resultSet.getString("contrasenia"), resultSet.getString("nombre"), resultSet.getString("apellido"), legajo_administrador);
            }

            closeConnection(statement);
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred while recovering admin.");
        } 
        return admin;
    }

    public static boolean checkAdminPassword(int legajo_administrador, String password) throws Exception{
        boolean password_matches = false;
        try{
            Statement statement = connectToDB();
            
            ResultSet resultSet = statement.executeQuery("select * from administrador WHERE legajo = '" + legajo_administrador + "' AND contrasenia = '"+ password +"'");
            if(resultSet.next()){ // Ya que es una sola fila, si hubo match es porque coincide la contraseña, sino devuelve false
                password_matches = true;
            }

            closeConnection(statement);
        } catch(SQLException e){
            throw new Exception("An error occurred while checking password");
        }
        return password_matches;
    }

    public static void saveAdmin(Administrador admin) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            if (statement != null) {
                statement.executeUpdate("replace into administrador values('" + fixIncompatibleSyntax(admin.email)
                        + "', '" + fixIncompatibleSyntax(admin.password) + "', '"
                        + fixIncompatibleSyntax(admin.nombre) + "', '" + fixIncompatibleSyntax(admin.apellido)
                        + "', '" + admin.legajo_administrador + "')");
            }
        } catch (SQLException e) {
            throw new Exception("An error occurred during saving.");
        } finally {
            closeConnection(statement);
        }
    }

    public static Alumno getAlumno(int legajo_alumno) throws Exception{
        Alumno alumno = null;
        Statement statement = null;
        try{
            statement = connectToDB();
            
            ResultSet resultSet = statement.executeQuery("select * from alumno WHERE legajo = '" + legajo_alumno + "'");
            if(resultSet.next()){
                alumno = new Alumno(resultSet.getString("email"), resultSet.getString("contrasenia"), resultSet.getString("nombre"), resultSet.getString("apellido"), legajo_alumno);
            }
        } catch(SQLException e){
            throw new Exception("An error occurred while recovering student.");
        } finally{
            closeConnection(statement);
        }
        return alumno;
    }

    public static boolean checkAlumnoPassword(int legajo_alumno, String password) throws Exception{
        boolean password_matches = false;
        try{
            Statement statement = connectToDB();
            
            ResultSet resultSet = statement.executeQuery("select * from alumno WHERE legajo = '" + legajo_alumno + "' AND contrasenia = '"+ password +"'");
            if(resultSet.next()){ // Ya que es una sola fila, si hubo match es porque coincide la contraseña, sino devuelve false
                password_matches = true;
            }

            closeConnection(statement);
        } catch(SQLException e){
            throw new Exception("An error occurred while checking password");
        }
        return password_matches;
    }

    public static void saveAlumno(Alumno alumno) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("REPLACE INTO alumno VALUES('" + fixIncompatibleSyntax(alumno.email)
                    + "', '" + fixIncompatibleSyntax(alumno.password) + "', '"
                    + fixIncompatibleSyntax(alumno.nombre) + "', '" + fixIncompatibleSyntax(alumno.apellido)
                    + "', '" + alumno.legajo_alumno + "')");
            
        } catch(SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred during saving a student.");
        } finally {
            closeConnection(statement);
        }
    }

    public static ArrayList<Profesor> getProfesores() throws Exception{
        ArrayList<Profesor> profesores = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connectToDB();
            if(statement != null){
                ResultSet resultSet = statement.executeQuery("select * from profesor");
                while (resultSet.next()){
                    profesores.add(new Profesor(resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("legajo")));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
            throw new Exception("Sucedio un error al recuperar los profesores.");
        } finally{
            closeConnection(statement);
        }
        return profesores;
    }

    public static void saveProfesor(Profesor profesor) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("REPLACE INTO profesor VALUES('" + fixIncompatibleSyntax(profesor.email)
                    + "', '" + fixIncompatibleSyntax(profesor.password) + "', '"
                    + fixIncompatibleSyntax(profesor.nombre) + "', '" + fixIncompatibleSyntax(profesor.apellido)
                    + "', '" + profesor.legajo_docente + "')");
            
        } catch(SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred during saving a student.");
        } finally {
            closeConnection(statement);
        }
    }

    public static List<Plan> getPlanesDeCarreras() throws Exception{
        List<Plan> plans = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connectToDB();
            ResultSet resultSet = statement.executeQuery("select * from plan");
            while(resultSet.next()) {
                plans.add(new Plan(resultSet.getInt("anio"), resultSet.getInt("codigo_carrera")));
            }
        } catch(SQLException e){
            throw new Exception("An error occurred while recovering plans.");
        } finally{
            closeConnection(statement);
        }
        return plans;
    }

    public static Plan getPlanMasRecienteDeCarrera(int codigoCarrera) throws Exception{
        Plan plan = null;
        try{
            Statement statement = connectToDB();

            ResultSet resultSet = statement.executeQuery("SELECT MAX(anio) AS anio FROM plan WHERE codigo_carrera = '" + codigoCarrera + "'");
            if(resultSet.next()){
                int anio = resultSet.getInt("anio");
                plan = new Plan(anio, codigoCarrera);
            }

            closeConnection(statement);
        } catch (SQLException e){
            e.printStackTrace();
            throw new Exception("Ocurrio un error al obtener el plan mas reciente.");
        } 
        return plan;
    }

    public static void savePlan(Plan plan) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("INSERT INTO plan VALUES('" + plan.anio + "', '" + plan.codCarrera + "')");
            
        } catch(SQLException e){
            throw new Exception("No puede crearse mas de un plan para la misma carrera en el mismo año.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void saveMateria(String nombreMateria) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("INSERT INTO materia(nombre) VALUES('" + nombreMateria + "')");
            
        } catch(SQLException e){
            e.printStackTrace();
            throw new Exception("No puede crearse mas de una materia con el mismo codigo.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void savePlanMateria(Plan plan, Materia materia) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("INSERT INTO plan_materia VALUES('" + plan.anio + "', '" + plan.codCarrera + "', '"+ materia.codigo +"')");
            
        } catch(SQLException e){
            throw new Exception("No puede crearse mas de un plan para la misma carrera en el mismo año.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void deletePlanMateria(Plan plan, Materia materia) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("DELETE FROM plan_materia WHERE anio_plan = "+ plan.anio +" AND codigo_carrera = "+ plan.codCarrera +" AND codigo_materia = "+ materia.codigo +"  ");
            
        } catch(SQLException e){
            throw new Exception("No puede crearse mas de un plan para la misma carrera en el mismo año.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void deletePlan(Plan plan) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("DELETE FROM plan WHERE anio_plan = "+ plan.anio +" AND codigo_carrera = "+ plan.codCarrera +" ");
            
        } catch(SQLException e){
            throw new Exception("No puede crearse mas de un plan para la misma carrera en el mismo año.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void saveInscripcion(int legajo_alumno, Plan plan) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("INSERT INTO inscripcion VALUES('" + legajo_alumno + "', '" + plan.anio + "', '"+ plan.codCarrera +"')");
            
        } catch(SQLException e){
            throw new Exception("No puede crearse mas de un plan para la misma carrera en el mismo año.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void saveCursada(Cursada cursada) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            
            statement.executeUpdate("INSERT INTO cursada VALUES('" + cursada.codigoMateria + "', '" + cursada.legajoProfesor + "', '"+ cursada.anio +"', '"+ cursada.cuatrimestre +"' )");
            
        } catch(SQLException e){
            throw new Exception("No puede crearse mas de un plan para la misma carrera en el mismo año.");
        } finally {
            closeConnection(statement);
        }
    }


    // Methods for connection and disconnection from db

    private static Statement connectToDB() throws SQLException {
        String urlDB = "jdbc:sqlite:./dictionary.db";
        Connection connection = DriverManager.getConnection(urlDB);
        Statement statement = connection.createStatement();
        statement.execute("PRAGMA foreign_keys = ON");
        statement.setQueryTimeout(30);

        return statement;
    }

    private static void closeConnection(Statement statement) throws Exception {
        try{
            if(statement != null){
                statement.getConnection().close();
            }
        } catch (SQLException e) {
            throw new Exception("An error occurred during database disconnection.");
        }
    }

    private static String fixIncompatibleSyntax(String name) {
        return name.replace("'", "`");
    }

}
