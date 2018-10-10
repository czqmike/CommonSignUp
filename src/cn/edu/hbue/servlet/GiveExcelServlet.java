package cn.edu.hbue.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.util.*;
import cn.edu.hbue.dao.TitleToIdDao;
import cn.edu.hbue.model.*;

/**
 * Servlet implementation class GiveExcelServlet
 */
@WebServlet("/GiveExcelServlet")
public class GiveExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String title = new String (request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		
		try {
			ArrayList<Report> reports = new ArrayList<Report>();
			ArrayList<Integer> ids = TitleToIdDao.selectIds(title);
			
			for (int i = 0; i < ids.size(); ++i) {
				reports.add(new Report(ids.get(i)));
			}
			
			Report report = reports.get(0);
			int cNum = report.getCommonItem().getPropertyNumber();
			int aNum = report.getAddonItem().size();

			String[] headers = new String[cNum + aNum];  
			headers[0] = "学号";
			headers[1] = "姓名";
			headers[2] = "专业";
			headers[3] = "班级";
			headers[4] = "入学年份";
			for (int i = cNum; i < cNum + report.getAddonItem().size(); ++i) {
				headers[i] = report.getAddonItem().get(i - 5).getAddon_name();
			}

			ExportExcelUtil.export(response, title, headers, reports);

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("<h1>导出失败，请联系管理员！ORZ</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
