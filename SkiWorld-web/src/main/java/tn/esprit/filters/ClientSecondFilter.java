package tn.esprit.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.esprit.beans.LoginBean;
import tn.esprit.beans.SubscriptionBean;

/**
 * Servlet Filter implementation class ClientSecondFilter
 */
public class ClientSecondFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ClientSecondFilter() {
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
		LoginBean loginBean = (LoginBean)((HttpServletRequest)request).getSession().getAttribute("loginBean");
		SubscriptionBean subscriptionBean = (SubscriptionBean)((HttpServletRequest)request).getSession().getAttribute("subscriptionBean");

		if ((loginBean != null || subscriptionBean != null) && (loginBean.isLoggedIn() || subscriptionBean.isLoggedIn())) {
			String contextPath = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).setStatus(404);
		}
		chain.doFilter(request, response);
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
