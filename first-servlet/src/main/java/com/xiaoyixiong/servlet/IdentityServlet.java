package com.xiaoyixiong.servlet;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

public class IdentityServlet extends HttpServlet {
    /*
     * 随机字符字典
     * 不包括0、O、1、I等难辨认的字符
     */
    public static final char[] CHARS = {'2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static Random random = new Random(); // 随机数

    public static String getRandomString() { // 获取6位随机数
        StringBuffer buffer = new StringBuffer(); // 字符串缓存
        for (int i = 0; i < 6; i++) { // 循环6次
            buffer.append(CHARS[random.nextInt(CHARS.length)]); // 每次取一个随机字符
        }
        return buffer.toString();
    }

    public static Color getRandomColor() { // 获取随机的颜色
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public static Color getReverseColor(Color c) { // 返回某颜色的反色
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg"); // 设置输出类型

        String randomString = getRandomString();
        request.getSession(true).setAttribute("randomString", randomString); // 放到Session中

        int width = 100;
        int height = 30;

        Color color = getRandomColor(); // 随即颜色，用于背景色
        Color reverse = getReverseColor(color); // 反色，用于前景色

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // 创建一个彩色图片

        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16)); // 设置字体
        g.setColor(color); // 设置颜色
        g.fillRect(0, 0, width, height); // 绘制背景
        g.setColor(reverse); // 设置颜色
        g.drawString(randomString, 18, 20); // 绘制随机字符
        for (int i = 0, n = random.nextInt(100); i < n; i++) { // 画最多100个噪音点
            g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1); // 随机噪音点
        }

        ServletOutputStream out = response.getOutputStream(); // 转成JPEG格式
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

        encoder.encode(bi);
        out.flush();
    }
}
