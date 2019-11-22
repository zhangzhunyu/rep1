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

@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取的传递的参数eid
         * 2.创建EmpService对象
         * 3.调用他的方法 -=====> count
         * 4.count 会写到回调函数中
         */

        try {
            //1.获取的传递的参数eid
            String eidStr = request.getParameter("eid");
            //将eidStr===> int
            int eid = Integer.parseInt(eidStr);
            //2.创建EmpService对象
            EmpService service = new EmpServiceImpl();
            //3.调用他的方法 -=====> count
            int count = service.deleteEmp(eid);
            // 4.count 会写到回调函数中
            response.getWriter().print(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
