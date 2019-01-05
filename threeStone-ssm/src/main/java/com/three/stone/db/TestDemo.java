package com.three.stone.db;


import com.three.stone.db.entity.StudentInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        Configuration configuration = sqlSession1.getConfiguration();
        Map<String, Object> param = new HashMap<>();
        param.put("studentId", 1);

        StudentInfo studentInfo1 = sqlSession1.selectOne("haha.selectById", param);
        System.out.println(studentInfo1);

        //为什么加这行代码，则StudentInfo必须要实现Serializable？
        sqlSession1.commit();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentInfo studentInfo2 = sqlSession2.selectOne("haha.selectById", param);
        System.out.println(studentInfo2);


    }
}
