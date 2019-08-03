package com.mybatisPlus.metaObjectHandler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * Created by admin on 2019/8/3 13:13
 *
 * @Author: created by admin
 * @Date: created in 13:13 2019/8/3
 * @param: bindingResult
 * @param: result
 * @return:
 * @throws:
 * @Description:
 * @version:
 */

public class MyMetaObjectHandler extends MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {

        Object userName = getFieldValByName("userName", metaObject);
        if(userName == null) {
            System.out.println("MyMetaObjectHandler  insertFill() 满足条件");
            MetaObjectHandler metaObjectHandler = setFieldValByName("userName", "aaa", metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object userName = getFieldValByName("userName", metaObject);
        if(userName == null) {
            System.out.println("MyMetaObjectHandler  updateFill() 满足条件");
            MetaObjectHandler metaObjectHandler = setFieldValByName("userName", "bbb", metaObject);
        }

    }
}
