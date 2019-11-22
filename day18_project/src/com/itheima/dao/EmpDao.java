package com.itheima.dao;

import com.itheima.pojo.EmpDept;
import com.itheima.pojo.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmpDao {

    //全查询
    public List<EmpDept>  findAll() throws SQLException;

    //根据id删除
    public int deleteByEid(int eid) throws SQLException;

    //添加员工
    public void addEmp(Employee emp) throws SQLException;

    //根据id查用户
    public Employee findEmpById(int eid) throws SQLException;

    //更新员工信息
    public void updateEmpById(Employee employee) throws SQLException;

    void deleteEmp(Connection connection, int eid) throws SQLException;
}
