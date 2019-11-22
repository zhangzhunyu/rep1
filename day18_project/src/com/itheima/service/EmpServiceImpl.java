package com.itheima.service;

import com.itheima.dao.EmpDao;
import com.itheima.dao.EmpDaoImpl;
import com.itheima.pojo.EmpDept;
import com.itheima.pojo.Employee;
import com.itheima.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao dao = new EmpDaoImpl();
    @Override
    public List<EmpDept> queryEmpDept() throws SQLException {

        List<EmpDept> list = dao.findAll();
        return list;
    }

    //删除员工方法
    @Override
    public int deleteEmp(int eid) throws SQLException {

        return dao.deleteByEid(eid);
    }

    @Override
    public void add(Employee emp) throws SQLException {
        dao.addEmp(emp);
    }

    @Override
    public Employee queryById(int eid) throws SQLException {

       return  dao.findEmpById(eid);
    }

    @Override
    public void updateEmp(Employee emp) throws SQLException {
        dao.updateEmpById(emp);
    }

    @Override
    //ids ="11,12,29,"
    public int batchDeleteEmps(String ids)  {
        /**
         * 1.切割字符串 ====>String[]
         * 2.int count = 0;
         * 3.遍历String[] 数组
         *      ids字符进行转型int
         *      调用deleteEmp (事务 connection)
         *      count++
         * 4.判断count == ids.length
         *      返回1
         *   不等于返回0
         *
         */
        Connection connection = null;
        int count = 0;
        String[] arr = null;
        try {
        EmpDao dao = new EmpDaoImpl();
        arr = ids.split(",");
        connection= JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        for (String idStr : arr) {
            int eid = Integer.parseInt(idStr);
            //调用删除方法
            dao.deleteEmp(connection, eid);
            count++;
        }
        connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        if(count==arr.length){
            return  1;
        }else{
            return 0;
        }
    }


}
