package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.EmpDept;
import com.itheima.service.EmpService;
import com.itheima.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/QueryAllServlet")
public class QueryAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.创建EmpService对象
            EmpService service = new EmpServiceImpl();
            //2.调用方法
            List<EmpDept> list = service.queryEmpDept();
            //3.获取ObjectMapper
            ObjectMapper om = new ObjectMapper();
            String jsonObj = om.writeValueAsString(list);
            //4.写到前台
            response.getWriter().print(jsonObj);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
