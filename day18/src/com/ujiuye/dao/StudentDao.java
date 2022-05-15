package com.ujiuye.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.ujiuye.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    ComboPooledDataSource ds = new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(ds);
    public List<Student> findAll() {
        String sql = "select * from student";

        try {
            return qr.query(sql,new BeanListHandler<Student>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> findByLimit(int cpage, int size) {
        String sql = "select * from student limit ?,?";

        int start = (cpage-1)*size;

        try {
            return qr.query(sql,new BeanListHandler<Student>(Student.class),start,size);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int findByCount() {

        String sql = "select * from student";

        try {
            return qr.query(sql,new BeanListHandler<Student>(Student.class)).size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int saveStudent(Student stu) {
        String sql = "insert into student values(null,?,?,?,?,?,?)";

        try {
            return  qr.update(sql, stu.getName(), stu.getSex(), stu.getHobby(), stu.getBirthday(), stu.getSdesc(), stu.getPhoto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
