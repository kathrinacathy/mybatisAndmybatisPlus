package com.mybatisPlus.mapper;

import com.mybatisPlus.entity.Dept;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kathrina
 * @since 2019-08-01
 */
public interface DeptMapper extends BaseMapper<Dept> {

    int deleteAll();

}
