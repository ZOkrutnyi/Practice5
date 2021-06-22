package main.java.com.delphi.app;

import java.lang.reflect.Field;

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
        String[] rows = new String[fields.length];
        createRow(fields, rows);
        return rows;
    }

    @SuppressWarnings("unused")
    public String[] getColumns() {
        Field[] fields = this.getClass().getDeclaredFields();
        String[] columns = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            boolean isAnnotated = fields[i].isAnnotationPresent(Column.class);
            Column c = fields[i].getAnnotation(Column.class);
            columns[i] = (isAnnotated ? c.name() : "null");
        }
        return columns;
    }


    private void createRow(Field[] fields, String[] rows) {
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                boolean isAnnotated = field.isAnnotationPresent(Column.class);
                Column c = field.getAnnotation(Column.class);
                rows[c.order()-1] = (isAnnotated ? field.get(this).toString() : "null");
            }
        } catch (IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}

