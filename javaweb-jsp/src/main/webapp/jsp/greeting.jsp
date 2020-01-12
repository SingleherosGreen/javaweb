<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/12
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%
    Locale locale = request.getLocale(); // 获取用户的本地化信息
    Calendar calendar = Calendar.getInstance(locale); // 获取用户所在地的时间
    int hour = calendar.get(Calendar.HOUR_OF_DAY); // 获取小时
    System.out.println(locale);
    System.out.println(hour);
    String greeting = "";
    if (hour <= 6) {
        greeting = "凌晨好，您该睡觉了。良好的睡眠是美好一天的开始。";
    } else if (hour <= 9) {
        greeting = "早上好。早餐应该注意营养";
    } else if (hour <= 12) {
        greeting = "time <= 12";
    } else if (hour <= 18) {
        greeting = "time <= 18";
    }else if (hour <= 24) {
        greeting = "time <= 24";
    }
%>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
    <table>
        <tr>
            <td><%= greeting %></td>
        </tr>
    </table>
</body>
</html>
