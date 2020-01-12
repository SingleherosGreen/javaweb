package com.xiaoyixiong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.log("执行doGet方法...");
        this.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.log("执行doPost方法...");
        this.execute(req, resp);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        this.log("执行getLastModified方法...");
        return -1;
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String requestURI = request.getRequestURI(); // 访问该Servlet的URI
        String method = request.getMethod(); // 访问Servlet的方式
        String param = request.getParameter("param"); // 客户端提交的参数param值

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("以" + method + "方式访问页面，取到的param参数为：" + param + "<br/>");

        out.println("<form action='"+ requestURI +"' method='get'><input type='text' name='param'/><input type='submit' value='以Get方式查询页面" + requestURI + "'/></form>");
        out.println("<form action='"+ requestURI +"' method='post'><input type='text' name='param'/><input type='submit' value='以Post方式查询页面" + requestURI + "'/></form>");
        out.println("<script>document.write('本页面最后更新时间：' + document.lastModified);</script>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
