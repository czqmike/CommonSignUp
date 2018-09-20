package cn.edu.hbue.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.dao.*;
import cn.edu.hbue.model.AddonItem;

import org.json.*;

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
		String report_title = request.getParameter("report_title");
		String itemsstr = request.getParameter("items");
		
		JSONArray items = null;
		ArrayList<AddonItem> items_al = null;

		// 将字符传转换为JSON数组
		try { 
			items = new JSONArray(itemsstr);
//			for (int i = 0; i < items.length(); ++i) {
//				System.out.println(items.get(i));
//			}

			// 把JSONArray items 转为 ArrayList<AddonItem> items_al
			items_al = new ArrayList<AddonItem>();
			for (int i = 0; i < items.length(); ++i) {
				items_al.add(new AddonItem(items.getJSONObject(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 插入报名标题，id为自增
		TitleToIdDao.insert(report_title);
	
		// 取出最大的id，（也是最后插入的），然后以这个id创建附加表
		AddonItemDao.CreateTable(items_al, TitleToIdDao.selectId(report_title));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
