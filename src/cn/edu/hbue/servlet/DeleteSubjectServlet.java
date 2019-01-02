package cn.edu.hbue.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.dao.VisibleDao;

/**
 * @author czqmike
 * @date 2018年12月25日
 * @description 当管理员点击删除报名时调用此Servlte
 * @note 这个Servlet并不是真正的从数据库中删除所有报名信息，仅仅只是将其【隐藏】了
 */
@WebServlet("/DeleteSubjectServlet")
public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(title);

		if (title != null && !"".equals(title)) {

			// 将visible.is_visible设为false，即可隐藏此报名
			VisibleDao.hideSubject(title);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	}

}
