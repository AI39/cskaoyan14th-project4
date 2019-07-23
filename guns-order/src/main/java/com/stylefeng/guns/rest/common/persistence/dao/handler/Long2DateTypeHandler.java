package com.stylefeng.guns.rest.common.persistence.dao.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class Long2DateTypeHandler extends BaseTypeHandler<Long> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Long aLong, JdbcType jdbcType) throws SQLException {
        Timestamp timestamp = new Timestamp(aLong);
        preparedStatement.setTimestamp(i, timestamp);
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(s);
        long time = timestamp.getTime();
        return time;
    }

    @Override
    public Long getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(i);
        long time = timestamp.getTime();
        return time;
    }

    @Override
    public Long getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Timestamp timestamp = callableStatement.getTimestamp(i);
        long time = timestamp.getTime();
        return time;
    }
}

