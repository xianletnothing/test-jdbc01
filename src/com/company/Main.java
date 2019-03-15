package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/demo";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
                //2.创建statement类对象，用来执行SQL语句！！
                Statement statement = con.createStatement();
                //要执行的SQL语句
                String sql = "update tb_area set area_name='beijing' where area_id=1";
                //3.ResultSet类，用来存放获取的结果集！！
//                ResultSet rs = statement.executeQuery(sql);
//                System.out.println("-----------------");
//                System.out.println("执行结果如下所示:");
//                System.out.println("-----------------");
//                System.out.println("地点" + "\t" + "优先级");
//                System.out.println("-----------------");
//
//                String area_name = null;
//                String priority = null;
//                while (rs.next()) {
//                    //获取stuname这列数据
//                    area_name = rs.getString("area_name");
//                    //获取stuid这列数据
//                    priority = rs.getString("priority");
//
//                    //输出结果
//                    System.out.println(area_name + "\t" + priority);
//                }
                int rs = statement.executeUpdate(sql);
                System.out.println(rs);
//                rs.close();
                con.close();
            }

        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }
}
