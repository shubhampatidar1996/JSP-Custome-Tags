package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EmptyTagWithAttribute extends SimpleTagSupport {
String status;
 public void setStatus(String status) {
	this.status = status;
}
 
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();
		int count=0,z=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappyfood", "root", "root");
            
			if(status.equals("dispatch"))
			{
				 z=1;
			}
			else if(status.equals("NA"))
			{
				 z=2;
			}
			
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(status) FROM ordertable where status=?");
			ps.setInt(1,z);	
			ResultSet rs = ps.executeQuery();
		     if(rs.next())
		     {
		    	 count=rs.getInt("COUNT(status)");
		    	 out.println(count);
		     }
		     else  if(rs.next())
		     {
		    	 count=rs.getInt("COUNT(status)");
		    	 out.println(count);
		     }
		    
		     
		 }catch(Exception e)
		 {
			 System.out.println(e);
		 }
			
		
	}

}