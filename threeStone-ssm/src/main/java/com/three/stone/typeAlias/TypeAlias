- 类型别名的使用
- 通过`resultMap`解决`javabean`属性和表字段不一致的情况

```
    //mybatis-config.xml
    <typeAliases>
        <typeAlias type="com.three.stone.db.entity.StudentInfo"  alias="studentInfo"/>
    </typeAliases>
    
    //studentInfoMapper.xml
    <resultMap id="rm" type="studentInfo">
        <result property="studentId" column="student_id"/>
    </resultMap>
    
    <select id="selectById" resultMap="rm">
            select * from
            <include refid="tableName"/>
            where student_id = #{studentId}
    </select>

```