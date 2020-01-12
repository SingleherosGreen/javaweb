package com.xiaoyixiong.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ContextParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>读取上下文参数</TITLE></HEAD>");
        out.println("<BODY>");
        ServletContext servletContext = getServletConfig().getServletContext();
        String uploadFolder = servletContext.getInitParameter("upload folder");
        String allowedFileType = servletContext.getInitParameter("allowed file type");
        String message = servletContext.getInitParameter("message");
        String msg = this.getInitParameter("message");
        String m = getServletConfig().getInitParameter("message");

        out.println("上传文件夹：" + uploadFolder + "<br/>");
        out.println("实际磁盘路径：" + servletContext.getRealPath(uploadFolder) + "<br/>");
        out.println("允许上传的类型：" + allowedFileType + "<br/>");
        out.println("servletContext获取init-param：" + message + "<br/>");
        out.println("servlet获取init-param：" + msg + "<br/>");
        out.println("servletConfig获取init-param：" + m + "<br/>");

        out.println("<script>document.write('本页面最后更新时间：' + document.lastModified);</script>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
