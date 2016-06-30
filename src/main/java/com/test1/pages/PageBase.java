package com.test1.pages;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase 
{
	//change to protected so it can be inherited by other class
    //private WebDriver driver;
	protected WebDriver driver;
	
	public PageBase (WebDriver driver)
	{
		this.driver = driver;
	}
	

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isFileDownLoadSuccessful (String downloadPath, String filename) throws InterruptedException
	{
		
		boolean testresults = false;
		
		
		File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	    //System.out.println("The value of dir_contents.length is " + dir_contents.length);
	    
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	    	    	
	    	//System.out.println("The value of i is " + i);
	    	
	        if (dir_contents[i].getName().equals(filename))
	            return testresults=true;
	            }

		
		return testresults;
	}
	
	
	public boolean isCreateUserSuccessfulCheckDB (String nusername, String email) throws InterruptedException, ClassNotFoundException, SQLException
	{
		
		boolean testresults;
		
		String query1 = "";
		
		// Connection url
		String dbUrl = "jdbc:sqlserver://dts.cfm3qnzohy8k.us-east-1.rds.amazonaws.com:1433;databaseName=DTS_QA";
											
		// DB username
		String username = "dtsapp";
								
		// DB password
		String password = "WfL65GrBVZYjGgXI8AQ8";
		
		//String ColName = "FileTitle";
		
		// SQL query
		//String query = "SELECT * FROM ccDaily.ScheduledTests WHERE RequestedOn LIKE \"2016-03-22%\";"; //for mysql		
		//String query = "SELECT UserName FROM ccDemo.Users WHERE UserFirstName = \"Rick\";  // for mysql
		String query = "SELECT UserName FROM DTS_QA.dbo.AspNetUsers WHERE Email = '" + email + "';";  //for sqlserver
		
		//Local SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
		// get connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		// to show if DB connection is successful
		System.out.println("Connection Successfull");
        System.out.println(con); 
		
		// Create statement object
		Statement stmt = con.createStatement();
		
		// Send SQL query to DB
		ResultSet rs = stmt.executeQuery(query);
				
		// While loop to get ResultSet all rows of data
		while(rs.next())
		{			
			query1 = rs.getString(1);
		}
						
		// Close DB connection
		con.close();
		
		System.out.println("The value for UserName is " + query1);
			
		
		testresults = query1.equals(nusername);;
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
				
		return testresults;
	}
	
	
	public boolean isAddAttachmentSuccessfulCheckDB (String filetitle, String filename) throws InterruptedException, ClassNotFoundException, SQLException
	{
		
		boolean testresults;
		
		String query1 = "";
		
		// Connection url
		String dbUrl = "jdbc:sqlserver://dts.cfm3qnzohy8k.us-east-1.rds.amazonaws.com:1433;databaseName=DTS_QA";
											
		// DB username
		String username = "dtsapp";
								
		// DB password
		String password = "WfL65GrBVZYjGgXI8AQ8";
		
		//String ColName = "FileTitle";
		
		// SQL query
		//String query = "SELECT * FROM ccDaily.ScheduledTests WHERE RequestedOn LIKE \"2016-03-22%\";"; //for mysql		
		//String query = "SELECT UserName FROM ccDemo.Users WHERE UserFirstName = \"Rick\";  // for mysql
		String query = "SELECT FileName FROM DTS_QA.dbo.Attachment WHERE FileTitle = '" + filetitle + "';";  //for sqlserver
		
		//Local SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
		// get connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		// to show if DB connection is successful
		System.out.println("Connection Successfull");
        System.out.println(con); 
		
		// Create statement object
		Statement stmt = con.createStatement();
		
		// Send SQL query to DB
		ResultSet rs = stmt.executeQuery(query);
				
		// While loop to get ResultSet all rows of data
		while(rs.next())
		{			
			query1 = rs.getString(1);
		}
						
		// Close DB connection
		con.close();
		
		System.out.println("The value for UserName is " + query1);
			
		
		testresults = query1.equals(filename);;
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
				
		return testresults;
	}
	
	
	public ManageClientsPage ClickMangeClientsButton() throws InterruptedException
	{
				
		//find the Add Client Button and click
		driver.findElement(By.cssSelector("[ui-sref='client-manager']")).click();
		Thread.sleep(2000);
			
		return new ManageClientsPage(driver);
	}
	
	
	public boolean isCreateClientSuccessfulCheckDB (String clientname, String clientaddress) throws InterruptedException, ClassNotFoundException, SQLException
	{
		
		boolean testresults;
		
		String query1 = "";
		
		// Connection url
		String dbUrl = "jdbc:sqlserver://dts.cfm3qnzohy8k.us-east-1.rds.amazonaws.com:1433;databaseName=DTS_QA";
											
		// DB username
		String username = "dtsapp";
								
		// DB password
		String password = "WfL65GrBVZYjGgXI8AQ8";
		
		
		// SQL query
		//String query = "SELECT * FROM ccDaily.ScheduledTests WHERE RequestedOn LIKE \"2016-03-22%\";"; //for mysql		
		//String query = "SELECT UserName FROM ccDemo.Users WHERE UserFirstName = \"Rick\";  // for mysql
		String query = "SELECT Name FROM DTS_QA.dbo.Client WHERE Address = '" + clientaddress + "';";  //for sqlserver
		
		//Local SQL Server JDBC driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
		// get connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		// to show if DB connection is successful
		System.out.println("Connection Successfull");
        System.out.println(con); 
        
        Thread.sleep(1000);
		// Create statement object
		Statement stmt = con.createStatement();
		
		Thread.sleep(1000);
		
		// Send SQL query to DB
		ResultSet rs = stmt.executeQuery(query);
				
		// While loop to get ResultSet all rows of data
		while(rs.next())
		{			
			query1 = rs.getString(1);
		}
						
		// Close DB connection
		con.close();
		
		System.out.println("The value for ClientName is " + query1);
			
		
		testresults = query1.equals(clientname);;
		
        Thread.sleep(1000);
		
		System.out.println(testresults);
				
		return testresults;
	}
	

}
