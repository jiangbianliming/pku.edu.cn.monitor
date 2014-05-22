package com.edu.cn.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
/*@WebServlet("/AjaxServlet")*/
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 remote(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 remote(request, response);
	}
	
	 protected void remote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = request.getParameter("class");
	        String method = request.getParameter("method");
	        String args = request.getParameter("args");
	        if(name != null && method != null){
	            try{
	                Class cls = Class.forName(name);
	                Object[] parames = !args.equals("") ? args.split(";") : null;
	                Object obj = cls.newInstance();
	                Method[] methods = cls.getMethods(); 
	                System.out.println("!!!!!!!!!!!!!!!!"+parames+"\n");
	                
	                for(Method m:methods){
	                    System.out.println(m.getName());
	                    if(m.getName().equals(method)){
	                        Object result = parames != null ? m.invoke(obj,parames) : m.invoke(obj); 
	                        response.setCharacterEncoding("UTF-8");
	                        response.getWriter().println(result.toString());
	                        break;
	                    }
	                }    
	            }
	            catch(Exception e){
	                e.printStackTrace();
	            }
	            
	        }
	    }

}
