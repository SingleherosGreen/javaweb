package com.xiaoyixiong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class InitParamServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>请登录查看Notice文件</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<form action='"+ request.getRequestURI() +"' method='post'>");
        out.println("帐号：<input type='text' name='username'/><br/>");
        out.println("密码：<input type='password' name='password'/><br/>");
        out.println("<input type='submit' value='登录' />");
        out.println("</form>");
        out.println("<script>document.write('本页面最后更新时间：' + document.lastModified);</script>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Enumeration params = this.getInitParameterNames(); // 所有的初始化参数名称
        while(params.hasMoreElements()) { // 遍历所有初始化参数
            String usernameParam = (String) params.nextElement();

            String passwordParam = this.getInitParameter(usernameParam);
            if (usernameParam.equalsIgnoreCase(username) && passwordParam.equalsIgnoreCase(password)) {
                request.getRequestDispatcher("/WEB-INF/notice.html").forward(request, response);
            }
        }
        this.doGet(request, response);
    }
}
