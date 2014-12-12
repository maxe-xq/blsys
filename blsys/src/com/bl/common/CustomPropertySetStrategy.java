package com.bl.common;

import java.lang.reflect.Field;
import java.util.Map;

import net.sf.json.JSONNull;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;
import org.apache.commons.beanutils.PropertyUtils;
/**
 * simple
 */
public class CustomPropertySetStrategy extends PropertySetStrategy
{

    public CustomPropertySetStrategy()
    {
    }

    public void setProperty(Object bean, String key, Object value)
    {
        setProperty(bean, key, value, new JsonConfig());
    }

    public void setProperty(Object bean, String key, Object value, JsonConfig jsonConfig)
    {
        Object val = (value instanceof JSONNull) ? null : value;
        if(bean instanceof Map)
            ((Map)bean).put(key, val);
        else
        if(!jsonConfig.isIgnorePublicFields())
            try
            {
                Field field = bean.getClass().getField(key);
                if(field != null)
                    field.set(bean, val);
            }
            catch(Exception e)
            {
                _setProperty(bean, key, val);
            }
        else
            _setProperty(bean, key, val);
    }

    private void _setProperty(Object bean, String key, Object value)
    {
        try
        {	
            PropertyUtils.setSimpleProperty(bean, key, value);
        }
        catch(Exception e)
        	
        {	
        	e.printStackTrace();
            throw new BlException(e);
        }
    }
}
