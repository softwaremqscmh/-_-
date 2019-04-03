

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Sports.CalSports;

/**
 * Servlet implementation class Exercise
 */
@WebServlet("/Exercise")
public class Exercise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /* ������Ӧͷ����ajax������� */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        
        CalSports e = new CalSports(request.getParameter("gender"),request.getParameter("grade"),request.getParameter("height"),request.getParameter("weight"),request.getParameter("capacity"),request.getParameter("run"),request.getParameter("reach"),request.getParameter("jump"),request.getParameter("pull"),request.getParameter("dash"));
		
        
        String score = e.Resr();
        String remain = e.Resm();
        String b = e.Resb();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("score", score);
        result.put("remain",remain);
        result.put("bmi",b);
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
