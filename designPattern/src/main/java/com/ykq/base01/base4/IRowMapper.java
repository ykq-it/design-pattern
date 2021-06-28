package com.ykq.base01.base4;

import java.sql.ResultSet;
import java.util.List;

/**
 * @ClassName IRowMapper
 * @Description TODO
 * @Author ykq
 * @Date 2020/8/19
 * @Version v1.0.0
 */
public interface IRowMapper {
    // 处理结果集
    List mapping(ResultSet rs) throws Exception;
}
