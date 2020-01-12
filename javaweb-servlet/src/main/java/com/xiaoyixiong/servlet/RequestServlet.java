package com.xiaoyixiong.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        response.setContentType("text/html");

        String authType = request.getAuthType();
        String localAddr = request.getLocalAddr(); // 本地IP，即服务器IP
        String localName = request.getLocalName(); // 本地名称，即服务器名称
        int localPort = request.getLocalPort(); // 本地端口号，即tomcat端口号

        Locale locale = request.getLocale(); // 用户的语言环境
        String contextPath = request.getContextPath(); // context路径
        String method = request.getMethod(); // GET or POST
        String pathInfo = request.getPathInfo();
        String pathTranslated = request.getPathTranslated();
        String protocol = request.getProtocol(); // 协议，这里为HTTP协议
        String queryString = request.getQueryString(); // 查询字符串，即?后面的字符串
        String remoteAddr = request.getRemoteAddr(); // 远程IP，即客户端IP
        int port = request.getRemotePort(); // 远程端口，即客户端端口
        String remoteUser = request.getRemoteUser(); // 远程用户
        String requestedSeeeionId = request.getRequestedSessionId(); // 客户端的Session的ID
        String reuestURI = request.getRequestURI(); // 用户请求的URI
        String scheme = request.getScheme(); // 协议头，这里为http
        String serverName = request.getServerName(); // 服务器名称
        int serverPort = request.getServerPort(); // 服务器端口
        String servletPath = request.getServletPath(); // Servlet的路径
        Principal userPrincipal = request.getUserPrincipal();

        String accept = request.getHeader("accept"); // 浏览器支持的格式
        String referer = request.getHeader("referer"); // 从哪个页面单击链接到了本页
        String userAgent = request.getHeader("user-agent"); //




        // User Agent信息，包括操作系统类型及版本号、浏览器类型及版本号等
        String serverInfo = this.getServletContext().getServerInfo();

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<script>document.write('本页面最后更新时间：' + document.lastModified);</script>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
