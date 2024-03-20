package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {

    // String path = "/home/rickoes/personal_code/github/mocking/data/*parquet";
    String path = "/app/data/*parquet";

    Connection conn = DriverManager.getConnection("jdbc:duckdb:");

    runQuery(conn, "select * from read_parquet('" + path + "')");

  }

  private static void runQuery(Connection conn, String command) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement(command);

    ResultSet resultset = stmt.executeQuery();
    printResults(resultset);
  }

  private static void printResults(ResultSet result) throws SQLException {
    ResultSetMetaData metadata = result.getMetaData();
    int count = metadata.getColumnCount();

    while (result.next()) {
      for (int i = 1; i <= count; i++) {
        if (i > 1) {
          System.out.print(", ");
        }
        String columnValue = result.getString(i);
        System.out.print(columnValue);
      }
      System.out.println("");
    }
  }
}