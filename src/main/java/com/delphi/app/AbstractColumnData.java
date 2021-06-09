package main.java.com.delphi.app;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractColumnData {
    private static final String XML_FILE_PATH = "cd_catalog.xml";
    public static final List<CD> ELEMENTS = AppendElements.append(XML_FILE_PATH);
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
            if (c == null)
                continue;
            for (CD o : ELEMENTS) {
                try {
                    rows[c.order() - 1] = f.get(o).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return rows;
    }

    public String[] getColumns() {
        String[] columns = new String[ELEMENTS.size()];
        Field[] fields = CL.getDeclaredFields();
        int itr = 0;
        StringBuilder sb;
        for (CD cd : ELEMENTS) {
            sb = new StringBuilder();
            for (Field f : fields) {
                f.setAccessible(true);
                Column c = f.getAnnotation(Column.class);
                try {
                    if (c == null)
                        sb.append("null").append(',');
                    else
                        sb.append(c.type().equals("Money") ? f.get(cd) + "$" : f.get(cd)).append(',');
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            columns[itr++] = sb.replace(sb.length() - 1, sb.length(), "").toString();
        }
        return columns;
    }
}

