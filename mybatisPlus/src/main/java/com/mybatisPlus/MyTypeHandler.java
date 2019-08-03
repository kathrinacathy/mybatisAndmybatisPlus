package com.mybatisPlus;

import com.mybatisPlus.entity.EmpStatus;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 2019/7/30 21:28
 *
 * @Author: created by admin
 * @Date: created in 21:28 2019/7/30
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

@MappedTypes(value = {com.mybatisPlus.entity.EmpStatus.class})
public class MyTypeHandler implements TypeHandler<EmpStatus> {
    @Override
    public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCode());
    }

    @Override
    public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
        String string = rs.getString(columnName);
        EmpStatus status = EmpStatus.getEmpStatusByCode(string);
        return status;
    }

    @Override
    public EmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);
        EmpStatus status = EmpStatus.getEmpStatusByCode(string);
        return status;
    }

    @Override
    public EmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);
        EmpStatus status = EmpStatus.getEmpStatusByCode(string);
        return status;
    }
}
