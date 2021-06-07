package main.java.com.delphi.app;

@interface Column {
    String name() default "unknown";
    String order() default "order";
    String type() default "type";
}
