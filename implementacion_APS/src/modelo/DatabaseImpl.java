
package modelo;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class DataBaseImpl {

  public static final String urlDB = "jdbc:sqlite:./dictionary.db";

  public static void createDatabase() throws Exception{
    Statement statement = null;
    try {
      statement = connectToDB();
      if (statement != null) {
        statement.executeUpdate("create table if not exists carrera (codigo integer PRIMARY KEY, nombre string)");
        statement.executeUpdate("create table if not exists plan(anio integer, codigo integer, foreign key(codigo) references carrera(codigo))");
      }
    } catch (SQLException e) {
      throw new Exception("An error occurred during DB creation.");
    } finally {
      closeConnection(statement);
    }
  }
/*
  public static ArrayList<String> getTitlesOfAllSavedPages() throws Exception{
    ArrayList<String> titles = new ArrayList<>();
    Statement statement = null;
    try {
      statement = connectToDB();
      if (statement != null) {
        ResultSet resultSet = statement.executeQuery("select * from catalog");
        while (resultSet.next())
          titles.add(resultSet.getString("title"));
      }
    } catch (SQLException e) {
      throw new Exception("An error occurred while recovering saved page's titles.");
    } finally {
      closeConnection(statement);
    }
    return titles;
  }

  public static void saveInfoOfPage(String pageTitle, String pageContent) throws Exception{
    Statement statement = null;
    try {
      statement = connectToDB();
      if (statement != null) {
        statement.executeUpdate("replace into catalog values(null, '" + fixIncompatibleSyntax(pageTitle) + "', '" + fixIncompatibleSyntax(pageContent) + "', 1)");
      }
    } catch (SQLException e) {
      throw new Exception("An error occurred during saving.");
    } finally {
      closeConnection(statement);
    }
  }

  public static String getPageContent(String title) throws Exception{
    String pageContent = null;
    Statement statement = null;
    try {
      statement = connectToDB();
      if (statement != null) {
        ResultSet resultSet = statement.executeQuery("select * from catalog WHERE title = '" + title + "'");
        resultSet.next();
        pageContent = resultSet.getString("content");
      }
    } catch (SQLException e) {
      throw new Exception("An error occurred while recovering page content.");
    } finally {
      closeConnection(statement);
    }
    return pageContent;
  }

  public static void deleteEntryFromDB(String pageTitle) throws Exception {
    Statement statement = null;
    try {
      statement = connectToDB();
      if (statement != null) {
        statement.executeUpdate("DELETE FROM catalog WHERE title = '" + fixIncompatibleSyntax(pageTitle) + "'");
      }
    } catch (SQLException e) {
      throw new Exception("An error occurred during deletion.");
    } finally {
      closeConnection(statement);
    }
  }

  public static void deleteAllEntries() throws Exception{
    Statement statement = null;
    try {
      statement = connectToDB();
      if (statement != null) {
        statement.executeUpdate("DELETE FROM catalog");
      }
    } catch (SQLException e) {
      throw new Exception("An error occurred during deletion of DB.");
    } finally {
      closeConnection(statement);
    }
  }
*/
  //Methods for connection and disconnection from db

  private static Statement connectToDB() throws SQLException {
    Connection connection = DriverManager.getConnection(urlDB);
    Statement statement = connection.createStatement();
    statement.setQueryTimeout(30);

    return statement;
  }

  private static void closeConnection(Statement statement) throws Exception {
    try{
      if(statement != null)
        statement.getConnection().close();
    }catch(SQLException e){
      throw new Exception("An error occurred during database disconnection.");
    }
  }

  private static String fixIncompatibleSyntax(String originalText){
    return originalText.replace("'", "`");
  }
}
