package cn.edu.hbue.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.dao.*;

/**
 * Servlet implementation class GetAddItemsServlet
 */
/**
 * @author czqmike
 * @date 2018年8月3日
 **接收用户传回的附加项字符串（以【`】为分隔符）
 */
@WebServlet("/GetAddItemsServlet")
public class GetAddItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAddItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String items = new String(request.getParameter("data").getBytes("ISO8859-1"),"UTF-8");
		String items = new String(request.getParameter("data"));
		String[] item_arr = items.split("`");
		String title = request.getParameter("title");
	
		// 插入标题，id为自增
		TitleToIdDao.insert(title);
	
		// 取出最大的id，（也是最后插入的），然后以这个id创建附加表
		AddonItemDao.CreateTable(item_arr, TitleToIdDao.select(title));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
