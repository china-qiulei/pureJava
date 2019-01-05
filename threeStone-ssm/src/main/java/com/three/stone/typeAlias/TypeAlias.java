package com.three.stone.typeAlias;

import com.three.stone.SqlSessionBase;

import java.util.HashMap;
import java.util.Map;

public class TypeAlias {
    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>();
        param.put("studentId", 1);
        Object studentInfo = SqlSessionBase.sqlSession.selectOne("com.three.stone.db.mappers.StudentInfoMapper.selectById", param);
        System.out.println(studentInfo);
    }
}
