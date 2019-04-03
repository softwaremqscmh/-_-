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
 * Servlet implementation class WXServlet
 */
@WebServlet("/WXServlet")
public class WXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WXServlet() {
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
		//�����������
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* ������Ӧͷ����ajax������� */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        
        
        Method user = new Method(request.getParameter("openid"),request.getParameter("cname"),request.getParameter("grade"),request.getParameter("credit"),request.getParameter("category"));
        user.InsertGpa();
        //ת��json����
        
        String dburl = "jdbc:mysql://localhost/mydb?user=root&password=123456&serverTimezone=GMT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dburl);
			PreparedStatement ps=conn.prepareStatement("select * from mydb.stu where openid=?;",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getOpenid());
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
		
		float gpa = user.CaculateGpa(user.getOpenid());
        String g = String.valueOf(gpa);
        
        data = new String[i][];
        for(;i>0;i--) {
			data[i-1] = params[i-1].split("\\*");
		}
		
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", data);
        result.put("gpa",g);
        result.put("msg", "��̨���յ�");
        
        //ʹ��Gson����Ҫ����gson-2.8.0.jar
        
        Gson gson = new Gson();
        String json = gson.toJson(result);
        
        
        
        //����ֵ��΢��С����
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
