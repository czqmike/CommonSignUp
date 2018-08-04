package cn.edu.hbue.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.dao.AddonItemDao;
import cn.edu.hbue.dao.CommonItemsDao;
import cn.edu.hbue.dao.TitleToIdDao;
import cn.edu.hbue.model.CommonItems;

/**
 * @author czqmike
 * @date 2018年8月4日
 * @description 接收main.jsp传递的表单信息，
				插入一条新记录到title_to_id，获取id
				将前4个以及id存入common_items
				用此id创建新表addon_item[id]用来存附加项值
				在addon_item[id]中插入各addon_name & addon_value
 */
@WebServlet("/GetMainServlet")
public class GetMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_title = new String(request.getParameter("page-title").getBytes("ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String student_no = new String(request.getParameter("student-no").getBytes("ISO-8859-1"), "UTF-8");
		String class_ = new String(request.getParameter("class").getBytes("ISO-8859-1"), "UTF-8");
		String report_year = new String(request.getParameter("report-year").getBytes("ISO-8859-1"), "UTF-8");
		
		// 插入一条新记录到title_to_id，获取id
		TitleToIdDao.insert(page_title);
		int addon_id = TitleToIdDao.selectId(page_title);
		
		CommonItems commonItems = new CommonItems(name, student_no, class_, report_year, addon_id);
		
		// 将前4个以及id存入common_items
		CommonItemsDao.insert(commonItems);
		
		// 用此id创建新表addon_item[id]用来存附加项值
		AddonItemDao.CreateTable(addon_id);
		
		// 在addon_item[id]中插入各addon_name & addon_value
		ArrayList<String> addonNames = new ArrayList<String>();
		ArrayList<String> addonValues = new ArrayList<String>();
		Enumeration<String> paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			String paraName = paraNames.nextElement();
			if (paraName.equals("page-title")  || paraName.equals("name") || 
				paraName.equals("student-no") || paraName.equals("class") || paraName.equals("report-year")) {
				continue ;
			}
			addonNames.add(new String(paraName.getBytes("ISO8859-1"), "UTF-8"));
			addonValues.add(new String(request.getParameter(paraName).getBytes("ISO8859-1"),"UTF-8"));
		}
		for (int i = 0; i < addonNames.size(); ++i) {
			AddonItemDao.insertById(addonNames.get(i), addonValues.get(i), addon_id);
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1> 报名成功！:) </h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
