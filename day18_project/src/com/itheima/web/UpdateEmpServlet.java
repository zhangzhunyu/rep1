package com.itheima.web;

import com.itheima.pojo.Employee;
import com.itheima.service.EmpService;
import com.itheima.service.EmpServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取参数
         * 2.创建Emp对象
         * 3.BeanUtils.populate(emp,map)
         * 4.创建Service
         * 5.调用更新方法
         * 6.重定向
         */

        try {
            //1.获取参数
            Map<String, String[]> map = request.getParameterMap();
            //2.创建Emp对象
            Employee employee = new Employee();
            //3.BeanUtils.populate(emp,map)
            BeanUtils.populate(employee,map);
            // 4.创建Service
            EmpService service = new EmpServiceImpl();
            //5.调用更新方法
            service.updateEmp(employee);
            //6.重定向
            response.sendRedirect(this.getServletContext().getContextPath()+"/show.html");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
