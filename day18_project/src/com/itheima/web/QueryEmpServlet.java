package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Employee;
import com.itheima.service.EmpService;
import com.itheima.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取参数eid
         * 2.调用service的查询方法===> Employee对象
         * 3.Employee对象 转成json
         * 4.写回到回调函数
         */

        try {
            String eidStr = request.getParameter("eid");
            int eid = Integer.parseInt(eidStr);
            EmpService service = new EmpServiceImpl();
            Employee employee = service.queryById(eid);
            ObjectMapper om = new ObjectMapper();
            String jsonObj = om.writeValueAsString(employee);
            response.getWriter().print(jsonObj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
