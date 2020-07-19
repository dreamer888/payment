package com.heyoufu.pay.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.UUID;

/**
 * @author Manni Wood
 */
@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(UUID[].class)
public class UUIDArrayTypeHandler extends BaseTypeHandler<UUID[]> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    UUID[] parameter, JdbcType jdbcType) throws SQLException {
        Connection c = ps.getConnection();
        Array inArray = c.createArrayOf("uuid", parameter);
        ps.setArray(i, inArray);
    }

    @Override
    public UUID[] getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Array outputArray = rs.getArray(columnName);
        if (outputArray == null) {
            return null;
        }
        return (UUID[])outputArray.getArray();
    }

    @Override
    public UUID[] getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Array outputArray = rs.getArray(columnIndex);
        if (outputArray == null) {
            return null;
        }
        return (UUID[])outputArray.getArray();
    }

    @Override
    public UUID[] getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Array outputArray = cs.getArray(columnIndex);
        if (outputArray == null) {
            return null;
        }
        return (UUID[])outputArray.getArray();
    }
}
