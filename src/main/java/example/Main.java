package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException {

    Connection conn = DriverManager.getConnection("jdbc:duckdb:");
    PreparedStatement stmt = conn
        .prepareStatement("select * from read_parquet('/home/rickoes/personal_code/github/mocking/data/*parquet')");

    ResultSet resultset = stmt.executeQuery();
    ResultSetMetaData metadata = resultset.getMetaData();
    int count = metadata.getColumnCount();

    while (resultset.next()) {
      for (int i = 1; i <= count; i++) {
        if (i > 1) {
          System.out.print(", ");
        }
        String columnValue = resultset.getString(i);
        System.out.print(columnValue);
      }
      System.out.println("");
    }

  }
}