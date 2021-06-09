package main.java.com.delphi.app;

import java.lang.reflect.Field;

public abstract class AbstractColumnData {
    private static final Class<CD> CL = CD.class;

    public String getValue(String key) throws IllegalAccessException {

        Field[] fields = CL.getDeclaredFields();
        for (Field f : fields) {
            Column c = f.getAnnotation(Column.class);
            if (c.name().equals(key))
                return f.toString();
        }
        return null;
    }

    public String[] getRow() {
        final int COLUMN_ELEMENTS = 6;
        String[] rows = new String[COLUMN_ELEMENTS];
        Field[] fields = CL.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Column c = f.getAnnotation(Column.class);
            if(c==null)
                continue;
            for (CD o : Main.ELEMENTS) {
                    try {
                        rows[c.order()-1] = f.get(o).toString();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                }
            }
        }
        return rows;
    }

    public String[] getColumns() {
        String[] columns = new String[Main.ELEMENTS.size()];
        Field[] fields = CL.getDeclaredFields();
        int itr = 0;
        StringBuilder sb;
        for (CD cd : Main.ELEMENTS) {
            sb = new StringBuilder();
            for (Field f: fields)
            {
                f.setAccessible(true);
                Column c = f.getAnnotation(Column.class);
                try {
                    if(c == null)
                        sb.append("null").append(',');
                    else if(c.type().equals("Money"))
                    sb.append(f.get(cd)).append('$').append(',');
                    else
                    sb.append(f.get(cd)).append(',');
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            columns[itr++] = sb.replace(sb.length()-1,sb.length(),"").toString();
        }
        return columns;
    }
    }

