package com.weather.basic.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {
    /**
     *
     * 将XML转为指定的POJO对象
     * */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception{
        Object xmlObject=null;
        JAXBContext context=JAXBContext.newInstance(clazz);
        Reader reader=null;
        // xml 转为对象的接口
        Unmarshaller unmarshaller= context.createUnmarshaller();
        reader=new StringReader(xmlStr);
        xmlObject=unmarshaller.unmarshal(reader);
        if(null!=reader){
            reader.close();
        }
        return xmlObject;
    }
}
