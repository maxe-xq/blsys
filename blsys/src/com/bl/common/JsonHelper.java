package com.bl.common;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.JavaIdentifierTransformer;
import net.sf.json.util.PropertySetStrategy;
import net.sf.json.processors.JsonValueProcessor;

public final class JsonHelper {

	private static final JsonConfig jsonConfig;
	private static final PropertySetStrategy propertySetStrategy = new CustomPropertySetStrategy();

	static {
		jsonConfig = new JsonConfig();
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpher(new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd" }));
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(java.sql.Date.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor());

		// jsonConfig.registerJsonValueProcessor(Integer.class,
		// new NumberJsonValueProcessor());
		// jsonConfig.registerJsonValueProcessor(Long.class,
		// new NumberJsonValueProcessor());
		// jsonConfig.registerJsonValueProcessor(Float.class,
		// new NumberJsonValueProcessor());
		// jsonConfig.registerJsonValueProcessor(Double.class,
		// new NumberJsonValueProcessor());
	}

	private JsonHelper() {
	}

	public static JsonConfig getJsonConfig() {
		return jsonConfig;
	}

	public static String toJson(Object src) {
		if (src == null)
			return "null";
		if (JSONUtils.isArray(src))
			return JSONArray.fromObject(src, jsonConfig).toString();
		else
			return JSONObject.fromObject(src, jsonConfig).toString();
	}

	public static Map toMap(String json) {
		if (StringUtils.isBlank(json))
			return null;
		else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setRootClass(java.util.HashMap.class);
			return (Map) JSONObject.toBean(JSONObject.fromObject(json), jsonConfig);
		}
	}

	public static Object toBean(String json, Class beanClass) {
	//	System.out.println(json);
		if (StringUtils.isBlank(json))
			return null;
		else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setRootClass(beanClass);			 
			return JSONObject.toBean(JSONObject.fromObject(json), jsonConfig);
		}
	}
	//.net对象属性首字母大写需要转成java形式
	public static Object toBean4DotNet(String json, Class beanClass) {
	//	System.out.println(json);
		if (StringUtils.isBlank(json))
			return null;
		else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
				@Override
				public String transformToJavaIdentifier(String str) {
				     char[] chars = str.toCharArray();
				        chars[0] = Character.toLowerCase(chars[0]);
				        return new String(chars);
				}
			});
			jsonConfig.setRootClass(beanClass);			 
			return JSONObject.toBean(JSONObject.fromObject(json), jsonConfig);
		}
	}
	//.net对象属性首字母大写需要转成java形式
		public static Object toBean4DotNet(String json, Class beanClass, Map map) {
		//	System.out.println(json);
			if (StringUtils.isBlank(json))
				return null;
			else {
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setPropertySetStrategy(propertySetStrategy);
				jsonConfig.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
					@Override
					public String transformToJavaIdentifier(String str) {
					     char[] chars = str.toCharArray();
					        chars[0] = Character.toLowerCase(chars[0]);
					        return new String(chars);
					}
				});
				jsonConfig.setRootClass(beanClass);		
				jsonConfig.setClassMap(map);
				return JSONObject.toBean(JSONObject.fromObject(json), jsonConfig);
			}
		}
	public static Object toBean(String json, Class beanClass,Map aMap) {
		if (StringUtils.isBlank(json))
			return null;
		else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setRootClass(beanClass);	
			jsonConfig.setClassMap(aMap);
			return JSONObject.toBean(JSONObject.fromObject(json), jsonConfig);
		}
	}

	public static List toList(String json) {
		if (StringUtils.isBlank(json))
			return null;
		else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setRootClass(java.util.HashMap.class);
			return (List) JSONArray.toCollection(JSONArray.fromObject(json), jsonConfig);
		}
	}

	public static List toList(String json, Class objectClass) {
		if (StringUtils.isBlank(json))
			return null;
		else {
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setRootClass(objectClass);
			return (List) JSONArray.toCollection(JSONArray.fromObject(json), jsonConfig);
		}
	}
	//.net对象属性首字母大写需要转成java形式
			public static Object toList4DotNet(String json, Class beanClass, Map map) {
			//	System.out.println(json);
				if (StringUtils.isBlank(json))
					return null;
				else {
					JsonConfig jsonConfig = new JsonConfig();
					jsonConfig.setPropertySetStrategy(propertySetStrategy);
					jsonConfig.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
						@Override
						public String transformToJavaIdentifier(String str) {
						     char[] chars = str.toCharArray();
						        chars[0] = Character.toLowerCase(chars[0]);
						        return new String(chars);
						}
					});
					jsonConfig.setRootClass(beanClass);		
					jsonConfig.setClassMap(map);
					return (List)JSONArray.toCollection(JSONArray.fromObject(json), jsonConfig);
				}
			}
	public static List toList(String json,Class objectClass,Map classMap){
		if(StringUtils.isBlank(json))
			return null;
		else{
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setPropertySetStrategy(propertySetStrategy);
			jsonConfig.setRootClass(objectClass);
			jsonConfig.setClassMap(classMap);
			return (List)JSONArray.toCollection(JSONArray.fromObject(json), jsonConfig);
		}
		
	}

}

class DateJsonValueProcessor implements JsonValueProcessor {

	DateJsonValueProcessor() {
	}

	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		String obj[] = new String[0];
		if (value instanceof Date[]) {
			Date dates[] = (Date[]) value;
			obj = new String[dates.length];
			for (int i = 0; i < dates.length; i++)
				obj[i] = FormatUtil.DateToStr(dates[i], "yyyy-MM-dd");

		}
		return obj;
	}

	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		return process(value);
	}

	private Object process(Object value) {
		if (value == null)
			return null;
		if (value instanceof Date)
			return FormatUtil.DateToStr((Date)value, "yyyy-MM-dd");
		if (value instanceof java.sql.Date)
			return FormatUtil.DateToStr(new Date(((java.sql.Date)value).getTime()), "yyyy-MM-dd");
		if (value instanceof Timestamp)
			return FormatUtil.DateToStr(new Date(((Timestamp)value).getTime()), "yyyy-MM-dd");
		else
			return null;
	}
}

class NumberJsonValueProcessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(Object value, JsonConfig jsonconfig) {
		String obj[] = new String[0];
		if (value instanceof Byte[]) {
			Byte inputs[] = (Byte[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]);
			return obj;
		}
		if (value instanceof Character[]) {
			Character inputs[] = (Character[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]);
			return obj;
		}
		if (value instanceof Short[]) {
			Short inputs[] = (Short[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]);
			return obj;
		}
		if (value instanceof Integer[]) {
			Integer inputs[] = (Integer[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]);
			return obj;
		}
		if (value instanceof Long[]) {
			Long inputs[] = (Long[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]) + "l";
			return obj;
		}
		if (value instanceof Float[]) {
			Float inputs[] = (Float[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]) + "f";
			return obj;
		}
		if (value instanceof Double[]) {
			Double inputs[] = (Double[]) value;
			obj = new String[inputs.length];
			for (int i = 0; i < inputs.length; i++)
				obj[i] = String.valueOf(inputs[i]) + "d";
			return obj;
		}
		return obj;
	}

	@Override
	public Object processObjectValue(String s, Object obj, JsonConfig jsonconfig) {
		return process(obj);
	}

	private Object process(Object value) {
		if (value == null)
			return null;
		if (value instanceof Byte)
			return String.valueOf(value);
		if (value instanceof Character)
			return String.valueOf(value);
		if (value instanceof Short)
			return String.valueOf(value);
		if (value instanceof Integer)
			return String.valueOf(value);
		if (value instanceof Long)
			return String.valueOf(value) + "l";
		if (value instanceof Float)
			return String.valueOf(value) + "f";
		if (value instanceof Double)
			return String.valueOf(value) + "d";
		else
			return null;
	}

}
