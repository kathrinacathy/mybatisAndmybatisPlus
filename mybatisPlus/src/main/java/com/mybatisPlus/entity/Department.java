package com.mybatisPlus.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2019/7/17 15:30
 *
 * @Author: created by admin
 * @Date: created in 15:30 2019/7/17
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class Department implements Serializable {
    private static final long serialVersionUID = 1028220536082242735L;

    private Integer id;
    private String departmentName;
    private List<Employee> emps;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
