package com.ujiuye.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.entity.PageBean;
import com.ujiuye.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find")
public class StudentServlet extends HttpServlet {
    StudentService service = new StudentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        //222

        PageBean pb = service.findAll(currentPage, pageSize);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(pb);
        resp.getWriter().print(s);
    }
}
