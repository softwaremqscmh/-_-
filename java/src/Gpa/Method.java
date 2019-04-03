package Gpa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Method {
	private String openid;
	private String cname;
	private float grade;
	private int credit;
	private int category;
	
	public Method() {
		
	}
	
	public Method(String openid, String cname, String grade,String credit, String category) {
		this.openid = openid;
		this.cname = cname;
		
		if(grade==null) {
			this.grade = 0;
		}else {
			this.grade = Float.parseFloat(grade);
		}
		
		if(credit==null) {
			this.credit=0;
		}else {
			this.credit = Integer.parseInt(credit);
		}
		
		if(category==null) {
			this.category=1;
		}
		else {
			this.category = Integer.parseInt(category);
		}
		
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public void setName(String courseName) {
		this.cname = courseName;
	}
	
	public void setGrade(float courseGpa) {
		this.grade = courseGpa;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String getOpenid() {
		return this.openid;
	}
	
	public float CaculateGpa(String openid) {
		float Gpa=0;
		int creditTotal=0;
		String dburl = "jdbc:mysql://localhost/mydb?user=root&password=123456&serverTimezone=GMT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dburl);
			PreparedStatement ps=conn.prepareStatement("select * from mydb.stu where openid=?;",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, openid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				creditTotal += rs.getInt("credit");
			}
			rs.beforeFirst();
			while(rs.next()) {
				Gpa += rs.getFloat("grade")*rs.getInt("credit")/creditTotal;
			}
			

			ps.close();
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Gpa;
	}
	
	public void InsertGpa() {
		String dburl = "jdbc:mysql://localhost/mydb?user=root&password=123456&serverTimezone=GMT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dburl);
			PreparedStatement ps=conn.prepareStatement("insert into mydb.stu(openid,cname,grade,credit,category) values(?,?,?,?,?)");
			ps.setString(1,this.openid);
			ps.setString(2, this.cname);
			ps.setFloat(3, this.grade);
			ps.setInt(4, this.credit);
			ps.setInt(5, this.category);
			ps.execute();
			ps.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public float GetRes(String openid, String tg) {
		int creditTotal = 0;
		float target = 0;
		float creditStillNeed = 0;
		float gpa = 0;
		
		if(tg!=null) {
			target = Float.parseFloat(tg);
		}
		
		String dburl = "jdbc:mysql://localhost/mydb?user=root&password=123456&serverTimezone=GMT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dburl);
			PreparedStatement ps=conn.prepareStatement("select * from mydb.stu where openid = ?");
			ps.setString(1,openid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				creditTotal += rs.getInt("credit");
			}
			System.out.println(creditTotal);
			ps.close();
			conn.close();
		gpa = this.CaculateGpa(openid);
		creditStillNeed = (float) (creditTotal*(target-gpa)/(4.0001-target));
		System.out.println(creditStillNeed);
		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(target-gpa<0) {
			return -1;//这里应该有两种情况要排除 一种是目标和设置相等时 一种是已有绩点大于目标时  此处暂时只排除了后一种
		}else {
			return creditStillNeed;
		}
	}
	
	
}


