package cn.edu.hbue.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * @author czqmike
 * @date 2018年9月12日
 * @description 控制CreateAddItems页面的访问
 */
@WebFilter("/CreateAddItemsFilter")
public class CreateAddItemsFilter implements Filter {
	private String username = "admin";
	private String password = "admin";

    /**
     * Default constructor. 
     */
    public CreateAddItemsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
//		System.out.println("doing filter");
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		if (un == null && pw == null) {
			HttpServletResponse hsres = (HttpServletResponse)response;
			hsres.sendRedirect("/CommonSignUp/AdminLogIn.html");
			return ;
		}
		
		if (username.equals(request.getParameter("username")) && password.equals(request.getParameter("password")) ) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().print("<h1>管理员用户名或密码错误！</h1>");
		}

		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
