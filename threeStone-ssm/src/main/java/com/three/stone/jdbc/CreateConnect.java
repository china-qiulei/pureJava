package com.three.stone.jdbc;

import java.sql.*;
import java.util.Date;

public class CreateConnect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sql = "select * from t_student_info where student_id = ?";
        PreparedStatement st = null;
        ResultSet rs = null;

        long beforeTimeOffset = -1L; //创建Connection对象前时间
        long afterTimeOffset = -1L; //创建Connection对象后时间
        long executeTimeOffset = -1L; //创建Connection对象后时间

        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");

        beforeTimeOffset = new Date().getTime();
        System.out.println("before:\t" + beforeTimeOffset);
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course", "root", "qllq20101127");

        afterTimeOffset = new Date().getTime();
        System.out.println("after:\t\t" + afterTimeOffset);
        System.out.println("Create Costs:\t\t" + (afterTimeOffset - beforeTimeOffset) + " ms");

        st = con.prepareStatement(sql);
        //设置参数
        st.setInt(1, 1);
        //查询，得出结果集
        rs = st.executeQuery();
        executeTimeOffset = new Date().getTime();
        System.out.println("Exec Costs:\t\t" + (executeTimeOffset - afterTimeOffset) + " ms");
    }
}
