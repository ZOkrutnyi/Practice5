package com.delphi.app.column_data;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class AbstractColumnData {

    @SuppressWarnings("unused")
    public String getValue(String key) {
        for (Field f : getCheckedFields()) {
            if (key.equalsIgnoreCase(f.getName())) {
                return getFieldValue(f);
            }
        }
        return "value not found";
    }

    @SuppressWarnings("unused")
    public String[] getRow() {
        return getCheckedFields()
                .stream()
                .map(this::getFieldValue)
                .toArray(String[]::new);
    }

    private ArrayList<Field> getCheckedFields() {
        return Arrays.stream(this.getClass().getDeclaredFields())
                .peek(field -> field.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String getFieldValue(Field field) {
        try {
            return field.get(this).toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Illegal access");
        }
    }

    @SuppressWarnings("unused")
    public String[] getColumns() {
        return getCheckedFields()
                .stream()
                .map(f -> f.getAnnotation(Column.class).name())
                .toArray(String[]::new);
    }
}

