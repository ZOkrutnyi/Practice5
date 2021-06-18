package main.java.com.delphi.app;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractColumnData {

    @SuppressWarnings("unused")
    public String getValue(String key) {
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                Column c = f.getAnnotation(Column.class);
                if (c.name().equals(key.toUpperCase()))
                    return f.get(this).toString();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unused")
    public String[] getRow() {
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        createRow(fields, sb);
        return sb.toString();
    }

    @SuppressWarnings("unused")
    public String[] getColumns() {
        return list.stream().map(AbstractColumnData::getRow).toArray(String[]::new);
    }

    private void createRow(Field[] fields, StringBuilder sb) {
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                boolean isAnnotated = f.isAnnotationPresent(Column.class);
                sb.append(isAnnotated ? f.get(this) : "null").append(';');
            }
        } catch (IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}

