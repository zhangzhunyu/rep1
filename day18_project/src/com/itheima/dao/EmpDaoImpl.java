package com.itheima.dao;

import com.itheima.pojo.EmpDept;
import com.itheima.pojo.Employee;
import com.itheima.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //1.获取连接池
    private DataSource dataSource = JDBCUtils.getDataSource();
    private QueryRunner qr = new QueryRunner(dataSource);

    @Override
    public List<EmpDept> findAll() throws SQLException {
        //2.查询
        List<EmpDept> list = qr.query("SELECT eid,ename,sex,tel,email,address,d.dname  FROM emp e, dept d  WHERE e.did = d.did order by eid asc",
                new BeanListHandler<EmpDept>(EmpDept.class));
        return list;
    }

    //根据id删除员工
    @Override
    public int deleteByEid(int eid) throws SQLException {
        return  qr.update("delete from emp where eid = ? ", eid);
    }

    //添加员工
    @Override
    public void addEmp(Employee emp) throws SQLException {
        qr.update("insert into emp values (null,?,?,?,?,?,?)",
                emp.getEname(),emp.getSex(),emp.getTel(),emp.getEmail(),emp.getAddress(),emp.getDid());
    }

    /**
     * 根据id查员工
     * @param eid
     * @return
     */
    @Override
    public Employee findEmpById(int eid) throws SQLException {
        Employee employee = qr.query("select eid,ename,sex,tel,email,address,did from emp where eid = ? ",
                new BeanHandler<Employee>(Employee.class),eid);
        return employee;
    }

    //更新
    @Override
    public void updateEmpById(Employee employee) throws SQLException {
        qr.update("update emp set ename = ? , sex = ? ,tel=?,email=? ,address=? ,did = ? where eid =?  ",
                employee.getEname(),employee.getSex(),employee.getTel(),employee.getEmail(),employee.getAddress(),employee.getDid(),employee.getEid());
    }

    @Override
    public void deleteEmp(Connection connection, int eid) throws SQLException {
        qr.update(connection ,"delete from emp where eid = ? ", eid);
    }
}
