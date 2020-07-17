package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/yzm")
public class CaptchaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置浏览器不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //设置响应类型
        response.setContentType("image/jpeg");
        //定义图片宽高
        int width = 60;
        int height = 20;
        //创建一个缓冲区图片
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //使用缓冲区图片创建 图形对象以用于绘制验证码
        Graphics g = img.getGraphics();
        //设置画笔颜色为黄色，后续画矩阵，相当于设置图形背景颜色为黄色
        g.setColor(new Color(255, 255, 0));
        g.fillRect(0, 0, width, height);
        //设置字体
        g.setFont(new Font("微软雅黑", Font.ITALIC, 18));
        //定义空字符串，以便后续连接
        String srand = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            srand += rand;
            //随机更换颜色，以便验证码数字颜色多样
            g.setColor(new Color(30 + random.nextInt(160), 50 + random.nextInt(100), 80 + random.nextInt(140)));
            //将随机数画入图形
            g.drawString(rand, i*16, 18);
        }
        //随机生成30条线条
        for (int i = 0; i < 30; i++) {
            int x=random.nextInt(width);
            int y=random.nextInt(height);
            int x1=random.nextInt(10);
            int y1=random.nextInt(10);
            g.drawLine(x, y, x+x1, y+y1);
        }
        //在session中设置连接好的验证码字符串
        request.getSession().setAttribute("yzm", srand);
        //释放 图形资源
        g.dispose();
        //将图片写入到response输出流
        ImageIO.write(img, "jpeg", response.getOutputStream());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}