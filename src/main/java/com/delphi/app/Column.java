package main.java.com.delphi.app;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    String name() default "Hide your heart";
    int order() default 1;
    String type() default "TITLE";
}
