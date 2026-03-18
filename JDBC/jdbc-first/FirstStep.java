package com.first;
public class FirstStep {
	public static void main(String[] args) {
		//step 1: 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//"com.mysql.cj.jdbc.Driver" is the fully qualified class name of the MySQL JDBC Driver class used by Java to connect to a MySQL database.
			//Class is a Java class from java.lang package used for runtime class loading.
			//Loading Driver class--It loads the MySQL JDBC driver into JVM memory.
			//When this class loads, the static block inside the driver class executes automatically.
			//driver translates Java commands into database-understandable commands.
			System.out.println("Loading of Driver Class is Done...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//Why this exception?--If the MySQL JDBC driver jar is not added to the project, Java cannot find the class.
		}
	}
}