package com.ujiuye.servlet;

import com.ujiuye.entity.Student;
import com.ujiuye.service.StudentService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/save")
public class InsertServlet extends HttpServlet {
    StudentService service = new StudentService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();

        Student stu = new Student();
        //66666
        try {
            BeanUtils.populate(stu,map);
            int row = service.insertStu(stu);

            if(row>0){
                resp.getWriter().print(1);
            }else {
                resp.getWriter().print(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
