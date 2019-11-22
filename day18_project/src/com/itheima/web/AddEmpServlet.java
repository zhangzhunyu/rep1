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

@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取参数  requeset.getParameMap(); ===> Map<String,String[]>
         * 2.创建emp对象
         * 3.调用BeanUtil.populate(emp,map)  // emp就有数据了..
         * 4.创建Service
         * 5.调用service的AddEmp方法,emp传递过去
         * 6.页面重定向到show.html
         */
        try {
            //1.获取参数  requeset.getParameMap(); ===> Map<String,String[]>
            Map<String, String[]> parameterMap = request.getParameterMap();
            //2.创建emp对象
            Employee employee = new Employee();
            //3.调用BeanUtil.populate(emp,map)  // emp就有数据了..
            BeanUtils.populate(employee,parameterMap);
            //4.创建Service
            EmpService service = new EmpServiceImpl();
            //5.调用service的AddEmp方法,emp传递过去
            service.add(employee);
            //6.页面重定向到show.html
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
