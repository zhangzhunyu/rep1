package com.itheima.web;

import com.itheima.service.EmpService;
import com.itheima.service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/BatchDeleteServlet")
public class BatchDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取参数
         * 2.创建Service
         * 3.调用serivce的方法 ==  int count
         * 4.count返回给回调函数
         */
        try {
        String ids = request.getParameter("ids");
        EmpService service = new EmpServiceImpl();
        int count  = 0;
        count = service.batchDeleteEmps(ids);
        response.getWriter().print(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
