package sei.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 权限控制注解
 * ouc.sei.lab.annotation
 * Permission.java
 * @author xiaohan_Li
 * 2017-5-19 下午20:41:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
	String permissionName();
}
