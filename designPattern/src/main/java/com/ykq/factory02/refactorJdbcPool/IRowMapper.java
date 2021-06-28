package com.ykq.factory02.refactorJdbcPool;

import java.sql.ResultSet;

/**
 * @ClassName IRowMapper
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/19
 * @Version v1.0.0
 */
public interface IRowMapper<T> {
    // 处理结果集
    T mapping(ResultSet rs) throws Exception;
}
