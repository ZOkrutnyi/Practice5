package main.java.com.delphi.app;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractColumnData {

    @SuppressWarnings("unused")
    public String getValue(String key) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields) {
            Column c = f.getAnnotation(Column.class);
            f.setAccessible(true);
            if (c.name().equals(key.toUpperCase())) {
                try {
                    return f.get(this).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unused")
    public String[] getRow() {
        String[] rows = new String[1];
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        addToArray(fields, sb);
        rows[0] = sb.toString();
        return rows;
    }

    @SuppressWarnings("unused")
    public String[] getColumns(List<? extends AbstractColumnData> list) {
        String[] columns = new String[list.size()];
        int itr = 0;
        for (AbstractColumnData acd : list) {
            columns[itr++] = acd.getRow()[0];
        }
        return columns;
    }

    private void addToArray(Field[] fields, StringBuilder sb) {
        for (Field f : fields) {
            f.setAccessible(true);
            boolean isAnnotated = f.isAnnotationPresent(Column.class);
            try {
                sb.append(isAnnotated ? f.get(this) : "null").append(';');
            } catch (IllegalAccessException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}

