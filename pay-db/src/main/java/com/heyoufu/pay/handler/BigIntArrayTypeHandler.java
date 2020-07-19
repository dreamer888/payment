package com.heyoufu.pay.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;

/**
 * @author Manni Wood
 */
@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(Long[].class)
public class BigIntArrayTypeHandler extends BaseTypeHandler<Long[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    Long[] parameter, JdbcType jdbcType) throws SQLException {
        Connection c = ps.getConnection();
        Array inArray = c.createArrayOf("bigint", parameter);
        ps.setArray(i, inArray);
    }

    @Override
    public Long[] getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Array outputArray = rs.getArray(columnName);
        if (outputArray == null) {
            return null;
        }
        return (Long[])outputArray.getArray();
    }

    @Override
    public Long[] getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Array outputArray = rs.getArray(columnIndex);
        if (outputArray == null) {
            return null;
        }
        return (Long[])outputArray.getArray();
    }

    @Override
    public Long[] getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Array outputArray = cs.getArray(columnIndex);
        if (outputArray == null) {
            return null;
        }
        return (Long[])outputArray.getArray();
    }
}
