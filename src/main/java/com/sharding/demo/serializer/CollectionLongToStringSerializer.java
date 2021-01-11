package com.sharding.demo.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * @Author: jianmin.li
 * @Description: 集合内长整型转字符串序列化工具
 * @Date: 2020/6/8 13:57
 * @Version: 1.0
 */
public class CollectionLongToStringSerializer implements ObjectSerializer {

    /**
     * fastjson invokes this call-back method during serialization when it encounters a field of the
     * specified type.
     *
     * @param serializer
     * @param object     src the object that needs to be converted to Json.
     * @param fieldName  parent object field name
     * @param fieldType  parent object field type
     * @param features   parent object field serializer features
     */
    @Override
    public void write(JSONSerializer serializer,Object object,Object fieldName,Type fieldType,int features) {
        if (object instanceof Collection) {
            List<String> list = JSON.parseArray(JSON.toJSONString(object),String.class);
            serializer.write(list);
        } else {
            serializer.write(object);
        }
    }
}
