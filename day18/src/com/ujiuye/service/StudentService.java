package com.ujiuye.service;

import com.ujiuye.dao.StudentDao;
import com.ujiuye.entity.PageBean;
import com.ujiuye.entity.Student;

import java.util.List;

public class StudentService {
    StudentDao dao  = new StudentDao();
    public PageBean findAll(String currentPage, String pageSize) {
        PageBean pb = new PageBean();

        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);

        pb.setCurrentPage(cpage);
        pb.setPageSize(size);

        List<Student> list= dao.findByLimit(cpage,size);
        pb.setList(list);

        int totalCount = dao.findByCount();
        pb.setTotalCount(totalCount);

        return pb;
    }
    public int insertStu(Student stu){
        return dao.saveStudent(stu);
    }
}
