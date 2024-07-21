package com.codeease.name.genius.enmus;

import com.codeease.name.genius.strategy.ClassNameConvert;
import com.codeease.name.genius.strategy.FieldNameConvert;
import com.codeease.name.genius.strategy.MethodNameConvert;
import com.codeease.name.genius.strategy.NameConvertStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by: ly
 * @ClassName: NameTypeEnum
 * @Description:
 * @Date: 2024/7/18 下午3:56
 */
public enum NameTypeEnum {

    /**
     * 方法名
     */
    METHOD("method", MethodNameConvert.class),
    /**
     * 类名
     */
    CLASS("class", ClassNameConvert.class),
    /**
     * 属性名
     */
    FIELD("field", FieldNameConvert.class)
    ;
    private String typeName;
    private Class<? extends NameConvertStrategy> strategyClass;

    NameTypeEnum(String typeName, Class<? extends NameConvertStrategy> strategyClass) {
        this.typeName = typeName;
        this.strategyClass = strategyClass;
    }

    public String getTypeName() {
        return typeName;
    }

    public Class<? extends NameConvertStrategy> getStrategyClass() {
        return strategyClass;
    }

    /**
     * 获取全部的转换方法
     * @return
     */
    public static List<String> getTypeNameList(){
        List<String> typeNameList = new ArrayList<>();
        for (NameTypeEnum value : NameTypeEnum.values()) {
            typeNameList.add(value.getTypeName());
        }
        return typeNameList;
    }

    public static NameConvertStrategy getStrategyInstance(String typeName) {
        for (NameTypeEnum value : NameTypeEnum.values()) {
            if (value.getTypeName().equals(typeName)){
                try {
                    Class<? extends NameConvertStrategy> strategyClass = value.getStrategyClass();
                    return strategyClass.getDeclaredConstructor().newInstance();
                }catch (Exception exception){
                    exception.printStackTrace();
                }

            }
        }
        return null;
    }
}
