package fr.dawan.database.dao;

import fr.dawan.database.beans.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
	
	public static Student findById(long id, Connection cnx, boolean closeCnx) throws Exception {
		Student student = new Student();
        String sql = "SELECT * FROM student WHERE id=?";
        PreparedStatement st = cnx.prepareStatement(sql);
        st.setLong(1, id);
        ResultSet resultSet = st.executeQuery();
        
        if (resultSet.next()) {
            student.setName( resultSet.getString("name") );
            student.setAge( resultSet.getLong( "age" ) );
            student.setFaculty( resultSet.getString( "faculty" ) );
        }
        
        resultSet.close();

        if (closeCnx)
            cnx.close();

        return student;
		
	}
	
	
	public static Student findByName(String name, Connection cnx, boolean closeCnx) throws Exception {
		
		// requête préparée (contre les injections SQL)
		
		String sql = "SELECT * FROM Student WHERE name = ?"; 
		sql = "SELECT * FROM Student WHERE name LIKE ?";
		
		Student student = null;
		
		PreparedStatement stmt = cnx.prepareStatement(sql);
			
		// Première requête
		stmt.setString(1, name);
			
		// Deuxième requête
		stmt.setString(1, "%" + name + "%");
			
		ResultSet resultSet = stmt.executeQuery();
		student = new Student();
		if (resultSet.next()) {
			student.setAge( resultSet.getInt("age"));
			student.setName( resultSet.getString("name") );
			student.setFaculty( resultSet.getString( "faculty" ));
		}
		resultSet.close();
			
		if( closeCnx ) {
			cnx.close();
		}	
		
		return student;
		
	}
	
	
	public static int update(Student student, Connection cnx, boolean closeCnx) throws Exception {
		System.setProperty( "file.encoding", "UTF-8" );
		
		
		PreparedStatement ps = cnx.prepareStatement( ""
				+ "UPDATE student SET age = ? , name= ?, faculty = ? WHERE ID = ?" );
		
		
		System.out.println("Dans la méthode update : ");
		System.out.println(student.getId());
		
		ps.setLong(1, student.getAge());
		ps.setString(2, student.getName());
		ps.setString(3, student.getFaculty());
		ps.setLong(4,  student.getId());
		return ps.executeUpdate();
	}
	
	public static int insert(Student student, Connection cnx, boolean closeCnx) throws Exception {
		
		// ajoutons un champ auto-incrément ID.
		
		System.setProperty( "file.encoding", "UTF-8" );
		int lastInsertId = -1;
		PreparedStatement ps = cnx.prepareStatement(
                "INSERT INTO student (name, age, faculty) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, student.getName());
		ps.setLong(2, student.getAge());
		ps.setString(3, student.getFaculty());
		
		int resultInsert = ps.executeUpdate();
		
		if (resultInsert != 0) {
            System.out.println("ok");

        } else {
            System.out.println("Problème d'insertion");
        }
		
		if( closeCnx ) {
			cnx.close();
		}
		
		return resultInsert;
		
	}
	
	public static List<Student> findAll(int start, int length, Connection cnx, boolean willBeClosed ) throws Exception {
		List<Student> studentsList = new ArrayList();
		
		String mySql = "SELECT * FROM Student LIMIT ?, ?";
		PreparedStatement stmt = cnx.prepareStatement(mySql);
        stmt.setInt(1, start);
        stmt.setInt(2, length);
        ResultSet resultSet = stmt.executeQuery();
            
        while(resultSet.next() ) {
        	Student student = new Student();
            student.setId( resultSet.getLong( "id" ));
            student.setName( resultSet.getString( "name"));
            student.setFaculty( resultSet.getString( "faculty" ));
            student.setAge( resultSet.getLong( "age" ));
            studentsList.add( student );
        }
            

		if (willBeClosed)
            cnx.close();
		
		return studentsList;
		
	}
	
	
	public static long count (Connection cnx, boolean closeCnx) throws Exception {
		long nb = 0;
		
		String sql = "SELECT COUNT(id) FROM `student`";
        PreparedStatement st = cnx.prepareStatement(sql);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            nb = rs.getInt(1);
        }
        rs.close();

        if (closeCnx)
            cnx.close();

        return nb;
	}
	
	
	
	
	public static int delete(long id, Connection connection, Boolean willBeClosed) throws Exception {
		 PreparedStatement ps = connection.prepareStatement("DELETE FROM student WHERE id=?");
	        ps.setLong(1, id );
	        int resultSet = ps.executeUpdate();
	        if (willBeClosed)
	            connection.close();
	        return resultSet;
	}
	
	
}
