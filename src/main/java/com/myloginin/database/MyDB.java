package com.myloginin.database;

import com.myloginin.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mydb")
public class MyDB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String passWord = req.getParameter("password");
        System.out.println(userName+passWord);
        boolean charge = Login(userName,passWord);
        req.setAttribute("charge",charge);
        req.setAttribute("userName",userName);
        if(charge==false) {
            //设置登录session
            System.out.println("登录失败");
            HttpSession session = req.getSession();
            session.setAttribute("userName",userName);
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }
        //跳转主页
        else {
            req.getRequestDispatcher("Hello.jsp").forward(req,resp);

        }




    }
    public boolean Login(String userName,String pwd) {
        boolean charge = false;
        List<User> userList = GetUsersList();
        for(int i = 0; i< userList.size(); i++) {
            if(userList.get(i).getUserName().equals(userName)) {
                if(userList.get(i).getUserPwd().equals(pwd)) {
                    System.out.println("登陆成功");
                    charge = true;

                }
            }

        }

        return charge;
    }
    protected void ShowTables() {
        try {


            Connection conn = LinkDB();
            String sql = "select * from tb_user";
            //sql语句运输到数据库执行
            //创建预处理命令对象 写sql语句
            PreparedStatement psmt = conn.prepareStatement(sql);
            //填充参数
            //执行更新 返回影响行数
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){

                int userId = rs.getInt(1);
                String username = rs.getString(2);
                String psw = rs.getString(3);
                int userage = rs.getInt(4);
                System.out.println(userId);
                System.out.println(psw);
                System.out.println(username);
                System.out.println(userage);


            }
            psmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public Connection LinkDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.myloginin.database.MyDB");
        String url = "jdbc:mysql://localhost:3306/login";
        String userName = "root";
        String passWord = "123456";
        Connection conn = DriverManager.getConnection(url, userName, passWord);
        return conn;
    }
    public List<User> GetUsersList(){
        List<User>  list= new ArrayList<>();
        try {


            Connection conn = LinkDB();
            String sql = "select * from tb_user";
            //sql语句运输到数据库执行
            //创建预处理命令对象 写sql语句
            PreparedStatement psmt = conn.prepareStatement(sql);
            //填充参数
            //执行更新 返回影响行数
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){

                int userId = rs.getInt(1);
                String username = rs.getString(2);
                String psw = rs.getString(3);
                int userage = rs.getInt(4);
                list.add(new User(userId,username,psw,userage));

            }
            psmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
