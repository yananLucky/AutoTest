package com.course.cases;

import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class AddUserTest {
    public void addUser() throws IOException {
        SqlSession session= DatabaseUtil.getSqlSession();
        AddUserCase addUserCase=session.selectOne("addUserCase","")
    }
}
