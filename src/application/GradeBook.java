package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class GradeBook extends Application {
	
	private Label firstNameLabel = new Label("First Name");
	private Label lastNameLabel = new Label("Last Name");
	private Label idLabel = new Label("Assignment ID");
	private Label gradeLabel = new Label("Grade");
	private Label assignmentNameLabel = new Label ("New Assignment Name");
	private TextField tfFirstName = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfID = new TextField();
	private TextField tfGrade = new TextField();
	private TextField tfAssignmentName = new TextField();
	private TextArea taReportCard = new TextArea();
	private Button addButton = new Button("Add Grade");
	private Button displayButton = new Button("Display All Grades");
	private Button modifyButton = new Button("Modify Grade");

	
	@Override
	public void start(Stage primaryStage) throws SQLException {
		try {
			String url = "jdbc:mysql://localhost/GradeBook";
		  	String user = "scott";
		  	String password = "tiger";
		    Connection myConn = DriverManager.getConnection(url, user, password);
		    Statement myStmt = myConn.createStatement();
		    
		    // GradeBook DB //////////////////////////////////////////////////////////////////
		    String sql1 = "drop database if exists GradeBook;";
		    String sql2 = "create database GradeBook;";
		    //String sql3 = "GRANT ALL PRIVILEGES ON GradeBook.* TO 'scott'@'localhost' IDENTIFIED BY 'tiger';";
		    //String sql3 = "grant all on GradeBook.* to 'scott'@'localhost';";
		    String sql4 = "use GradeBook;";
		    String sql5 = "create table Students(studentID int not null auto_increment, firstName varchar(25), lastName varchar(25), constraint pkStudents primary key (studentID));";
		    String sql6 = "create table Assignments(assignmentID int not null auto_increment, assignmentName varchar(40), constraint pkAssignments primary key (assignmentID));";
		    String sql7 = "create table Scores(studentID int not null, assignmentID int not null, score varchar(5), primary key (studentID, assignmentID));";
		    String sql8 = "insert into Students (firstName, lastName) values ('Jerry', 'Rice');";
		    String sql9 = "insert into Students (firstName, lastName) values ('Emmit', 'Smith');";
			String sql10 = "insert into Students (firstName, lastName) values ('Joe', 'Montanta');";
			String sql11 = "insert into Students (firstName, lastName) values ('Joe', 'Green');";
			String sql12 = "insert into Students (firstName, lastName) values ('Dick', 'Butkus');";
			String sql13 = "insert into Assignments (assignmentName) values ('HW1');";
			String sql14 = "insert into Assignments (assignmentName) values ('Midterm');";
			String sql15 = "insert into Assignments (assignmentName) values ('HW2');";
			String sql16 = "insert into Assignments (assignmentName) values ('Final');";
			String sql16b = "insert into GradeBook.Assignments (assignmentName) values ('Super Final');";
			String sql17 = "insert into Scores (studentID, assignmentID, score) values (1, 1, '89');";
			String sql18 = "insert into Scores (studentID, assignmentID, score) values (1, 2, '45');";
			String sql19 = "insert into Scores (studentID, assignmentID, score) values (1, 3, '67');";
			String sql20 = "insert into Scores (studentID, assignmentID, score) values (1, 4, '98');";
			String sql21 = "insert into Scores (studentID, assignmentID, score) values (2, 1, '74');";
			String sql22 = "insert into Scores (studentID, assignmentID, score) values (2, 2, '76');";
			//String sql23 = "insert into Scores (studentID, assignmentID, score) values (2, 2, '76');";
			String sql24 = "insert into Scores (studentID, assignmentID, score) values (2, 3, '89');";
			String sql25 = "insert into Scores (studentID, assignmentID, score) values (2, 4, '62');";
			String sql26 = "insert into Scores (studentID, assignmentID, score) values (3, 1, '98');";
			String sql27 = "insert into Scores (studentID, assignmentID, score) values (3, 2, '89');";
			String sql28 = "insert into Scores (studentID, assignmentID, score) values (3, 3, '67');";
			String sql29 = "insert into Scores (studentID, assignmentID, score) values (3, 4, '81');";
			String sql30 = "insert into Scores (studentID, assignmentID, score) values (4, 1, '44');";
			String sql31 = "insert into Scores (studentID, assignmentID, score) values (4, 2, '53');";
			String sql32 = "insert into Scores (studentID, assignmentID, score) values (4, 3, '75');";
			String sql33 = "insert into Scores (studentID, assignmentID, score) values (4, 4, '34');";
			String sql34 = "insert into Scores (studentID, assignmentID, score) values (5, 1, '76');";
			String sql35 = "insert into Scores (studentID, assignmentID, score) values (5, 2, '44');";
			String sql36 = "insert into Scores (studentID, assignmentID, score) values (5, 3, '87');";
			String sql37 = "insert into Scores (studentID, assignmentID, score) values (5, 4, '66');";

		    myStmt.addBatch(sql1);
		    myStmt.addBatch(sql2);
		    //myStmt.addBatch(sql3);
		    myStmt.addBatch(sql4);
		    myStmt.addBatch(sql5);
		    myStmt.addBatch(sql6);
		    myStmt.addBatch(sql7);  
		    myStmt.addBatch(sql8);
		    myStmt.addBatch(sql9);
		    myStmt.addBatch(sql10);
		    myStmt.addBatch(sql11);
		    myStmt.addBatch(sql12);  
		    myStmt.addBatch(sql13);
		    myStmt.addBatch(sql14);
		    myStmt.addBatch(sql15);
		    myStmt.addBatch(sql16);
		    myStmt.addBatch(sql16b);
		    myStmt.addBatch(sql17);  
		    myStmt.addBatch(sql18);
		    myStmt.addBatch(sql19);
		    myStmt.addBatch(sql20);
		    myStmt.addBatch(sql21);
		    myStmt.addBatch(sql22);  
		    //myStmt.addBatch(sql23);
		    myStmt.addBatch(sql24);
		    myStmt.addBatch(sql25);
		    myStmt.addBatch(sql26);
		    myStmt.addBatch(sql27);  
		    myStmt.addBatch(sql28);
		    myStmt.addBatch(sql29);
		    myStmt.addBatch(sql30);
		    myStmt.addBatch(sql31);
		    myStmt.addBatch(sql32);  
		    myStmt.addBatch(sql33);
		    myStmt.addBatch(sql34);
		    myStmt.addBatch(sql35);
		    myStmt.addBatch(sql36);
		    myStmt.addBatch(sql37);  

		    int count[] = myStmt.executeBatch();

		    ///////////////////////////////////////////////////
		    
		    String sqlGetStudents = "select * from Students";
		    //myStmt.executeUpdate(sqlGetStudents);
		    ResultSet rs = myStmt.executeQuery(sqlGetStudents);
		    taReportCard.setText("Students:\n\n");
		    while(rs.next()){
		    	taReportCard.appendText(rs.getString(2) + " ");
		    	taReportCard.appendText(rs.getString(3) + " \n");
		    }

		    
		    // GUI Construction //////////////////////////////
			VBox mainBox = new VBox(5);
			HBox topFieldBox = new HBox(5);
			HBox bottomFieldBox = new HBox(5);
			HBox newAssignmentBox = new HBox(5);
			HBox buttonBox = new HBox(5);
			
			topFieldBox.getChildren().addAll(firstNameLabel, tfFirstName, lastNameLabel, tfLastName);
			topFieldBox.setAlignment(Pos.CENTER);
			bottomFieldBox.getChildren().addAll(idLabel, tfID, gradeLabel, tfGrade);
			bottomFieldBox.setAlignment(Pos.CENTER);
			buttonBox.getChildren().addAll(addButton, displayButton, modifyButton);
			buttonBox.setAlignment(Pos.CENTER);
			newAssignmentBox.setAlignment(Pos.CENTER);
			
			newAssignmentBox.getChildren().addAll(assignmentNameLabel, tfAssignmentName);
			
			mainBox.getChildren().addAll(topFieldBox, bottomFieldBox, newAssignmentBox, taReportCard, buttonBox);
			mainBox.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(mainBox,500,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			addButton.setOnAction(e -> addGrade());
			displayButton.setOnAction(e -> displayGrade());
			modifyButton.setOnAction(e -> modifyGrade());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addGrade() {
		try{
		
		String url = "jdbc:mysql://localhost/GradeBook";
	  	String user = "scott";
	  	String password = "tiger";
	    Connection myConn = DriverManager.getConnection(url, user, password);
	    
	    String sqlCheckIfAssignmentExists = "SELECT GradeBook.Assignments.assignmentName FROM GradeBook.Assignments";
	    PreparedStatement findAssignmentName = myConn.prepareStatement(sqlCheckIfAssignmentExists);
	    ResultSet rsfind = findAssignmentName.executeQuery();
	    Boolean found = false;
	    while(rsfind.next()){
	    	System.out.println(found);
	    	if(tfAssignmentName.getText().trim().equals(rsfind.getString(1).trim())){
	    		found = true;
	    		System.out.println("Assignment already exists in database");
	    	}else{
	    		found = false;
	    		System.out.println(tfAssignmentName.getText().trim());
	    		System.out.println(rsfind.getString(1).trim());
	    		System.out.println("This is a new assignment");
	    	}
	    }
	    if(found == false){
	    	String sqlNewAssignment = "INSERT into GradeBook.Assignments (assignmentName) values(?)";
	    	PreparedStatement insertNewAssignment = myConn.prepareStatement(sqlNewAssignment);
	    	insertNewAssignment.setString(1, tfAssignmentName.getText().trim());
	    	insertNewAssignment.executeUpdate();
	    }
	    
	    String idString = null;
	    int idInt = 0;
	    String sqlSearchForID = "SELECT GradeBook.Students.studentID FROM GradeBook.Students WHERE firstName = '" + tfFirstName.getText() + "' AND lastName = '" + tfLastName.getText() + "';";
        PreparedStatement findStmt = myConn.prepareStatement(sqlSearchForID);   
	    ResultSet rs = findStmt.executeQuery(sqlSearchForID);
	    while(rs.next()){
	    	idInt = rs.getInt(1);
	    }
	    
	    idString = Integer.toString(idInt);
	    
	    String sqlGetAssignmentID = "SELECT GradeBook.Assignments.assignmentID FROM GradeBook.Assignments";
	    PreparedStatement findAssignmentID = myConn.prepareStatement(sqlGetAssignmentID);
	    ResultSet rsID = findAssignmentID.executeQuery();
	    int idAssignment = 0;
	    while(rsID.next()){
	    	idAssignment = rsID.getInt(1);
	    }
	    
	    //String sqlInsertAssignment = "INSERT into GradeBook.Assignments
	    String sqlInsertScores = "insert into Scores "
	  					+ "(studentID, assignmentID, score)"
	  					+ "values(?,?,?)";
	    PreparedStatement myStmt = myConn.prepareStatement(sqlInsertScores);
	    myStmt.setInt(1, idInt);
	    //myStmt.setString(2, tfID.getText());
	    myStmt.setInt(2, idAssignment);
	    myStmt.setString(3, tfGrade.getText());
	    myStmt.executeUpdate();
	    System.out.println("Insert Complete");
	    
		}catch(Exception e){
		}
	}
	
	public void displayGrade() {
		try{
		String url = "jdbc:mysql://localhost/GradeBook";
	  	String user = "scott";
	  	String password = "tiger";
	    Connection myConn = DriverManager.getConnection(url, user, password);
	    Statement myStmt = myConn.createStatement();
	    
	    String sql ="SELECT Assignments.assignmentID, Assignments.assignmentName, Scores.score FROM Students JOIN Scores ON Students.studentID = Scores.studentID JOIN Assignments ON Assignments.assignmentID = Scores.assignmentID WHERE firstName = '" + tfFirstName.getText() +"' AND lastName = '"+ tfLastName.getText() +"';";          

        PreparedStatement findStmt = myConn.prepareStatement(sql);   
        ResultSet rs = findStmt.executeQuery(sql);
        taReportCard.clear();
        while(rs.next()){
        	//Retrieve by column name
        	taReportCard.appendText(rs.getString(1) + " ");
        	taReportCard.appendText(rs.getString(2) + " ");
        	taReportCard.appendText(rs.getString(3) + " ");
        	//taReportCard.appendText(rs.getString(4) + " ");
        	taReportCard.appendText("\n");
        }
	    System.out.println("Display Complete");
	    System.out.println(rs.getString(4));
		}catch(Exception e){
		}
	}
	
	public void modifyGrade() {
		try{
		String url = "jdbc:mysql://localhost/GradeBook";
	  	String user = "scott";
	  	String password = "tiger";
	    Connection myConn = DriverManager.getConnection(url, user, password);
	    
	    String idString = null;
	    int idInt = 0;
	    String sqlSearchForID = "SELECT GradeBook.Students.studentID FROM GradeBook.Students WHERE firstName = '" + tfFirstName.getText() + "' AND lastName = '" + tfLastName.getText() + "';";
        PreparedStatement findStmt = myConn.prepareStatement(sqlSearchForID);   
	    ResultSet rs = findStmt.executeQuery(sqlSearchForID);
	    while(rs.next()){
	    	idInt = rs.getInt(1);
	    }
	    
	    idString = Integer.toString(idInt);
	    //System.out.println(rs.getInt(1));
	    System.out.println(idString);
	    
		String sqlStudentUpdate = "UPDATE GradeBook.Scores SET score = "+ tfGrade.getText() +" WHERE studentID = "+ idInt +" AND assignmentID = "+ tfID.getText() +"";
		PreparedStatement myStmt2 = myConn.prepareStatement(sqlStudentUpdate);
	    //myStmt2.setString(1, tfID.getText());
	    //myStmt2.setString(2, tfGrade.getText());
	    myStmt2.executeUpdate();
		
		//String sqlScoreUpdate = "UPDATE Scores SET studentID = ?, assignmentID = ? WHERE Scores.assignmentID = '" + tfID.getText() + "';";

	    
	    System.out.println("Update complete");
	    myConn.close();
		}catch(Exception e){
			
		}
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
