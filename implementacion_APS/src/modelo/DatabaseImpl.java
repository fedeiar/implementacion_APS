
package modelo;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseImpl {

    public static void createDatabase() {
        Statement statement = null;
        try {
            statement = connectToDB();

            if(statement != null){
                statement.executeUpdate(
                        "create table if not exists carrera(codigo integer PRIMARY KEY, nombre string)");
                statement.executeUpdate(
                        "create table if not exists plan(anio integer, codigo integer, foreign key(codigo) references carrera(codigo))");
                statement.executeUpdate(
                        "create table if not exists administrador(email string, contrasenia char(32), apellido string, nombre string, legajo_administrador integer PRIMARY KEY)");
                statement.executeUpdate(
                        "create table if not exists alumno(email string, contrasenia char(32), apellido string, nombre string, legajo_alumno integer PRIMARY KEY)");
            }
            addInfoToDB();

            closeConnection(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addInfoToDB() throws Exception {
        //TODO: si fernando nos dice algo, agregarle lo de md5 a las contraseñas.
        saveAdmin(new Administrador("fulano1@gmail.com", "1234", "Suarez", "Pablo", 1));
        saveAdmin(new Administrador("fulano2@gmail.com", "5678", "Perez", "Juan", 2));
        saveStudent(new Alumno("fulano3@hotmail.com", "4321", "Gonzalez", "Rodrigo", 3));
        saveStudent(new Alumno("fulano4@hotmail.com", "8765", "Rodriguez", "Patricio", 4));
        saveCarreer(1, "Licenciatura en Aprender a Leer");
        saveCarreer(2, "Licenciatura en Sumar Enteros");
    }

    public static ArrayList<String> getNamesOfCarreers() throws Exception {
        ArrayList<String> careers = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connectToDB();
            if(statement != null){
                ResultSet resultSet = statement.executeQuery("select * from carrera");
                while (resultSet.next()){
                    careers.add(resultSet.getString("nombre"));
                }
            }
        } catch(SQLException e){
            throw new Exception("An error occurred while recovering carreers.");
        } finally{
            closeConnection(statement);
        }
        return careers;
    }

    public static Administrador getAdmin(int legajo_administrador) throws Exception {
        Administrador admin = null;
        try{
            Statement statement = connectToDB();

            ResultSet resultSet = statement.executeQuery("select * from administrador WHERE legajo_administrador = '" + legajo_administrador + "'");
            if(resultSet.next()){
                admin = new Administrador(resultSet.getString("email"), resultSet.getString("contrasenia"), resultSet.getString("apellido"), resultSet.getString("nombre"), legajo_administrador);
            }

            closeConnection(statement);
        } catch (SQLException e){
            System.out.println("entre 1");
            e.printStackTrace();
            throw new Exception("An error occurred while recovering admin.");
        } 
        return admin;
    }

    public static boolean checkAdminPassword(int legajo_administrador, String password) throws Exception{
        boolean password_matches = false;
        try{
            Statement statement = connectToDB();
            
            ResultSet resultSet = statement.executeQuery("select * from administrador WHERE legajo_administrador = '" + legajo_administrador + "' AND contrasenia = '"+ password +"'");
            if(resultSet.next()){ // Ya que es una sola fila, si hubo match es porque coincide la contraseña, sino devuelve false
                password_matches = true;
            }

        } catch(SQLException e){
            e.printStackTrace();
            throw new Exception("An error occurred while checking password");
        }
        return password_matches;
    }

    public static Alumno getStudent(int legajo_alumno) throws Exception{
        Alumno alumno = null;
        Statement statement = null;
        try{
            statement = connectToDB();
            if(statement != null){
                ResultSet resultSet = statement.executeQuery("select * from alumno WHERE legajo_alumno = '" + legajo_alumno + "'");
                resultSet.next();
                alumno = new Alumno(resultSet.getString("email"), resultSet.getString("contrasenia"), resultSet.getString("apellido"), resultSet.getString("nombre"), legajo_alumno);
            }
        } catch(SQLException e){
            throw new Exception("An error occurred while recovering student.");
        } finally{
            closeConnection(statement);
        }
        return alumno;
    }

    public static void saveCarreer(int code, String name) throws Exception {
        Statement statement = null;
        try{
            statement = connectToDB();
            if (statement != null) {
                statement.executeUpdate("replace into carrera values('" + code + "', '" + fixIncompatibleSyntax(name) + "')");
            }
        } catch(SQLException e){
            throw new Exception("An error occurred during saving.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void saveAdmin(Administrador admin) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            if (statement != null) {
                statement.executeUpdate("replace into administrador values('" + fixIncompatibleSyntax(admin.getEmail())
                        + "', '" + fixIncompatibleSyntax(admin.getPassword()) + "', '"
                        + fixIncompatibleSyntax(admin.getSurname()) + "', '" + fixIncompatibleSyntax(admin.getName())
                        + "', '" + admin.getLegajo_administrador() + "')");
            }
        } catch (SQLException e) {
            throw new Exception("An error occurred during saving.");
        } finally {
            closeConnection(statement);
        }
    }

    public static void saveStudent(Alumno alumno) throws Exception {
        Statement statement = null;
        try {
            statement = connectToDB();
            if (statement != null) {
                statement.executeUpdate("replace into alumno values('" + fixIncompatibleSyntax(alumno.getEmail())
                        + "', '" + fixIncompatibleSyntax(alumno.getPassword()) + "', '"
                        + fixIncompatibleSyntax(alumno.getSurname()) + "', '" + fixIncompatibleSyntax(alumno.getName())
                        + "', '" + alumno.getLegajo_alumno() + "')");
            }
        } catch(SQLException e){
            throw new Exception("An error occurred during saving.");
        } finally {
            closeConnection(statement);
        }
    }

    // Methods for connection and disconnection from db

    private static Statement connectToDB() throws SQLException {
        String urlDB = "jdbc:sqlite:./dictionary.db";
        Connection connection = DriverManager.getConnection(urlDB);
        Statement statement = connection.createStatement();
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
