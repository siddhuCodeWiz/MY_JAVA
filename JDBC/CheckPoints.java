package JDBC;

import java.sql.*;

public class CheckPoints {
    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/shopping";
        String user="root";
        String password="VerBal#71";
        Connection con=null;
        String name="";
        Savepoint s1=null,s2=null,s3=null;
        
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            con=DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            System.out.println("auto-commit is off");
            Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("connected to database");
            ResultSet rs;

            // creation of the table in the java database
            // st.executeUpdate("create table studentss (rollno INT PRIMARY KEY,name VARCHAR(50))");
            // System.out.println("table created successfully");
            // created only once
            
            // insertion in the table
            // int ins=st.executeUpdate("INSERT INTO studentss values (1,'pranav'),(2,'siddharth'),(3,'sravan'),(4,'uday'),(5,'sanjay')");
            // System.out.println(ins+" rows inserted");
            // con.commit();

            // retreving from the table and stores in the resultset which points to the first colum 
            // which has the column names  so we need to use the rs.next() method to point 
            // the data available row

            // update the particular cell value
            // st.executeUpdate("update student set rollno=20 where name='pranav'");

            //first insertion
            


            rs=st.executeQuery("SELECT * FROM studentss");

            try{
            
            rs.moveToInsertRow();
            rs.updateInt("rollno", 10);
            rs.updateString("name", "pranav111");
            rs.insertRow();
            rs.moveToCurrentRow();
            con.commit();  
            s1 = con.setSavepoint();
            }
            catch(Exception e){
                System.out.println("the exception is:"+e);
                return;

            }

            //secons insertion
            try{
            rs.moveToInsertRow();
            rs.updateInt("rollno", 11);
            rs.updateString("name", "siddharth1");
            rs.insertRow();
            rs.moveToCurrentRow();
            con.commit();
            s2=con.setSavepoint();
            }catch(Exception e){
                System.out.println("exception is:"+e);
                con.rollback(s1);
                return;
            }

            //third insertion
            try{
            rs.moveToInsertRow();
            rs.updateInt("rollno",12);
            rs.updateString("ame","sravan1");
            rs.insertRow();
            rs.moveToCurrentRow();
            con.commit();
            s3=con.setSavepoint();
            }catch(Exception e){
                System.out.println("exception is:"+e);
                con.rollback(s2);
                return;
            }
            con.commit();
            System.out.println("DONEEEE");
            while(rs.next()!=false){
                System.out.println(rs.getInt("rollno")+":"+rs.getString("name"));
            }
        }
            catch(Exception e){
                System.out.println("connection error:"+e);
                return;
            }
            
        }
        catch(Exception e){
            System.out.println("class is not loaded" + e);
            return;
        }
    }
}
