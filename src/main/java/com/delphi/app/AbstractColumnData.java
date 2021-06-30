package main.java.com.delphi.app;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AbstractColumnData {

    @SuppressWarnings("unused")
    public String getValue(String key) throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field: checkFields(fields)) {
            if (key.equals(field.getAnnotation(Column.class).name()))
            {
                return field.get(this).toString();
            }

        }
        return "not found";
    }

    @SuppressWarnings("unused")
    public String[] getRow() {
        Field[] fields = this.getClass().getDeclaredFields();
        ArrayList<String> rows = new ArrayList<>();
        checkFields(fields).forEach(field -> {
            try {
                rows.add(field.get(this).toString());
            } catch (IllegalAccessException e) {
                System.err.println(e.getMessage());
            }
        });
        return rows.toArray(String[]::new);
    }
    private ArrayList<Field> checkFields(Field[] fields)
    {
        return Arrays.stream(fields)
                .peek(field -> field.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @SuppressWarnings("unused")
    public String[] getColumns() {
        Field[] fields = this.getClass().getDeclaredFields();
        return checkFields(fields).stream()
                .map(f -> f.getAnnotation(Column.class).name())
                .toArray(String[]::new);
    }
}

