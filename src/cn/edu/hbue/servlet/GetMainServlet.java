package cn.edu.hbue.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hbue.dao.AddonItemDao;
import cn.edu.hbue.dao.CommonItemsDao;
import cn.edu.hbue.dao.TitleToIdDao;
import cn.edu.hbue.model.AddonItem;
import cn.edu.hbue.model.CommonItems;
import cn.edu.hbue.util.ResponseUtil;

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
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	   判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return 
     *         true 用户重复提交了表单 
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }
        
        return false;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		if (isRepeatSubmit(request)) {
			ResponseUtil.showError(response, "请不要重复提交表单(　ﾟ 3ﾟ)");
			return ;
		}

		String page_title = new String(request.getParameter("page-title").getBytes("ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String student_no = new String(request.getParameter("student-no").getBytes("ISO-8859-1"), "UTF-8");
		String major = new String(request.getParameter("major").getBytes("ISO-8859-1"), "UTF-8");
		String class_ = new String(request.getParameter("class").getBytes("ISO-8859-1"), "UTF-8");
		String report_year = new String(request.getParameter("report-year").getBytes("ISO-8859-1"), "UTF-8");
		
		// 获取模板的addon_item表的id, 并选出模板的数据，方便复制
		int last_id = TitleToIdDao.selectId(page_title);
		ArrayList<AddonItem> addonItems = AddonItemDao.selectAddonItemsById(last_id);

		// 插入一条新记录到title_to_id，获取id
		TitleToIdDao.insert(page_title);
		int addon_id = TitleToIdDao.selectId(page_title);
		
		CommonItems commonItems = new CommonItems(name, student_no, major, class_, report_year, addon_id);
		
		// 将前4个以及id存入common_items
		CommonItemsDao.insert(commonItems);
		
		// 用此id创建新表addon_item[id]用来存附加项值
		AddonItemDao.CreateTable(addon_id);
		
		// 在addon_item[id]中插入各addon_name & addon_value
		HashMap<String, String> map = new HashMap(); 		// 此map存储获得的(addon_name, addon_value)键值对
		Enumeration<String> paraNames = request.getParameterNames();
		while (paraNames.hasMoreElements()) {
			String paraName = paraNames.nextElement();
			if (paraName.equals("page-title")  || paraName.equals("name") || paraName.equals("student-no") ||
				paraName.equals("major") || paraName.equals("class") || paraName.equals("report-year")) {
				continue ;
			}
			map.put(new String(paraName.getBytes("ISO8859-1"), "UTF-8"), 
					new String(request.getParameter(paraName).getBytes("ISO8859-1"),"UTF-8"));
		}
		
		boolean ok = true;
		for (int i = 0; i < addonItems.size(); ++i) {
			AddonItem temp = new AddonItem(addonItems.get(i));
			temp.setAddon_value(map.get(temp.getAddon_name()));
			
			if (!AddonItemDao.insertById(temp, addon_id)) {
				ok = false;
			}
		}

		PrintWriter out = response.getWriter();
		if (ok) {
			ResponseUtil.showSuccess(response, "报名成功！:)</br>"
											 + "现在你可以关闭这个页面 or 10秒后<a href='index.jsp'>跳转至首页</a>");
			//10秒后跳转到主页面
			response.setHeader("refresh","10;index.jsp"); 
		} else {
			ResponseUtil.showError(response, "出现错误，请与管理员联系(T_T)");
		}

		request.getSession().removeAttribute("token");//移除session中的token
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
