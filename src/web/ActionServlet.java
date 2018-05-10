package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpDAO;
import dao.UserDAO;
import entiy.Emp;
import entiy.User;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
		if("login".equals(action)){
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			UserDAO dao=new UserDAO();
			String code1=request.getParameter("checkcode");
			String code2=(String)session.getAttribute("number");
			if(!code1.equals(code2)){
				request.setAttribute("error_checkcode","验证码不正确");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			try {
				User user=dao.findByUsername(username);
				if(user!=null&&pwd.equals(user.getPwd())){
					session.setAttribute("user", user);
					response.sendRedirect("homepage.jsp");
				}else{
					request.setAttribute("error","用户名或密码不正确");
				    request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("regist".equals(action)){
			UserDAO dao=new UserDAO();
			User user=new User();
			String username=request.getParameter("username");
			String code1=request.getParameter("checkcode");
			String code2=(String)session.getAttribute("number");
			if(!code1.equals(code2)){
				request.setAttribute("error_checkcode","验证码不正确");
				request.getRequestDispatcher("regist.jsp").forward(request, response);
				return;
			}
			try {
				if(dao.findByUsername(username)!=null){
					request.setAttribute("error_username","用户名已存在");
					request.getRequestDispatcher("regist.jsp").forward(request, response);
				}else{
				   user.setUsername(username);
				   user.setPwd(request.getParameter("pwd"));
				   user.setName(request.getParameter("name"));
				   user.setTel(request.getParameter("tel"));
				   user.setGender(request.getParameter("gender"));
				   dao.save(user);
				   response.sendRedirect("login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("check_code".equals(action)){
			String code1=request.getParameter("checkcode");
			String code2=(String)session.getAttribute("number");
			if(code1.equals(code2)){
				out.print("验证码正确");
			}else{
				out.print("验证码不正确,请重新输入");
			}
		}else if("check_uname".equals(action)){
			UserDAO dao=new UserDAO();
			String username=request.getParameter("username");
				try {
					if(username==""){
						out.print("用户名不能为空");
					}else if(dao.findByUsername(username)==null){
						out.print("用户名可使用");
					}else{
						out.print("用户名已存在");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else if("check_pwd".equals(action)){
			String pwd1=request.getParameter("pwd");
			String pwd2=request.getParameter("pwd1");
			if(!pwd1.equals(pwd2)){
				out.print("输入的密码不相同,请重新输入");
			}
		}else if("addEmplist".equals(action)){
			EmpDAO dao=new EmpDAO();
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String gender=request.getParameter("gender");
			String age=request.getParameter("age");
			String tel=request.getParameter("tel");
			String id_card=request.getParameter("id_card");
			String address=request.getParameter("address");
			String other=request.getParameter("other");
			Emp emp=new Emp();
			emp.setId(id);
			emp.setName(name);
			emp.setGender(gender);
			emp.setAge(age);
			emp.setTel(tel);
			emp.setId_card(id_card);
			emp.setAddress(address);
			emp.setOther(other);
			try {
				dao.save(emp);
				response.sendRedirect("homepage.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
