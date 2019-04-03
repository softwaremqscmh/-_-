

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Gpa.Method;

/**
 * Servlet implementation class ResServlet
 */
@WebServlet("/ResServlet")
public class ResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer datas = new StringBuffer();
		String[] params = null;
		String[][] data =null;
		int i=0;
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String openid = request.getParameter("openid");
        
        System.out.println(openid);
        
        String dburl = "jdbc:mysql://localhost/mydb?user=root&password=123456&serverTimezone=GMT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dburl);
			PreparedStatement ps=conn.prepareStatement("select * from mydb.stu where openid=?;",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, request.getParameter("openid"));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				datas.append(rs.getString("cname"));
				datas.append("*");
				datas.append(rs.getInt("credit"));
				datas.append("*");
				datas.append(rs.getFloat("grade"));
				datas.append("*");
				datas.append(rs.getInt("category"));
				datas.append(",");
				i++;
			}
			ps.close();
			conn.close();
			String str = datas.toString(); 
			params = str.split(",");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Method user = new Method();
		float gpa = user.CaculateGpa(request.getParameter("openid"));
        String g = String.valueOf(gpa);
        System.out.println(g);
        
        data = new String[i][];
        for(;i>0;i--) {
			data[i-1] = params[i-1].split("\\*");
		}
		
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", data);
        result.put("gpa",g);
        result.put("msg", "后台已收到");
        
        //使用Gson类需要导入gson-2.8.0.jar
        
        Gson gson = new Gson();
        String json = gson.toJson(result);
        
        
        
        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write(json);
        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
