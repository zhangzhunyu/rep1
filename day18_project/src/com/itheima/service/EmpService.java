package com.itheima.service;

import com.itheima.pojo.EmpDept;
import com.itheima.pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {

    //全查询方法
    public List<EmpDept> queryEmpDept() throws SQLException;

    //根据id删除员工
    public int deleteEmp(int eid) throws SQLException;

    //添加用户
    public void add(Employee emp) throws SQLException;

    //获取员工对象
    public Employee queryById(int eid) throws SQLException;

    //更新员工
    public void updateEmp(Employee emp) throws SQLException;

    //批量删除
    public int batchDeleteEmps(String ids) throws SQLException;
}
