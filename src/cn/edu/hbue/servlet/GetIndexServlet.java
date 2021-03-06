package cn.edu.hbue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.util.TokenUtil;

/**
 * @author czqmike
 * @date 2018年8月4日
 * @description 获取index页面传送的project_title，并且重定向至main.jsp
 * 				创建token并保存在服务器端的Session
 */
@WebServlet("/GetIndexServlet")
public class GetIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = TokenUtil.getInstance().makeToken();	// 创建token，以备后续防止重复提交表单使用
		request.getSession().setAttribute("token", token);	// 在服务器端保存token

		String selected = request.getParameter("subject_title");
		
		response.sendRedirect("main.jsp?subject_title=" + selected);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
