package railway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyCon {
	private static Connection connection;
	public static Connection startConnection() throws Exception {
		if(connection != null){
			return connection;
		}
		String url="jdbc:mysql://localhost:3306/railway";
		String username="root";
		String password="";
		Class.forName("com.mysql.jdbc.Driver");
		return connection = DriverManager.getConnection(url,username,password);
	}
	public static Connection startConnection (String hostName, String databaseName,
		String userName, String password) throws Exception {
		String url = "jdbc:mysql://localhost:3306/railway";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,password);
		return con;
	}
	public static void main(String []args) throws Exception {
		Connection con = MyCon.startConnection();
		PreparedStatement pstm = con.prepareStatement("select * from train where train_no = ?");
		pstm.setString(1, "12001");
		ResultSet rs = pstm.executeQuery();
		while(rs.next())
			System.out.println(rs.getInt("train_no") + " " + rs.getString("train_name"));
			
	}
}