package main.java.com.delphi.app;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractColumnData {
    private static final String XML_FILE_PATH = "cd_catalog.xml";
    public static final List<CD> ELEMENTS = AppendElements.append(XML_FILE_PATH);
    private static final Class<CD> CD_CLASS = CD.class;
    Logger logger = Logger.getLogger(getClass().getName());
    @SuppressWarnings("unused")
    public String getValue(String key) {

        Field[] fields = CD_CLASS.getDeclaredFields();
        for (Field f : fields) {
            Column c = f.getAnnotation(Column.class);
            f.setAccessible(true);
            if (c.name().equals(key.toUpperCase())) {
                try {
                    return f.get(ELEMENTS.get(0)).toString();
                } catch (IllegalAccessException e) {
                    logger.severe("Exception at " + e);
                }
            }
        }
        return null;
    }
    @SuppressWarnings("unused")
    public String[] getRow() {
        String[] rows = new String[1];
        Field[] fields = CD_CLASS.getDeclaredFields();
        CD cd = ELEMENTS.get(0);
        StringBuilder sb = new StringBuilder();
        for (Field f : fields) {
            f.setAccessible(true);
            Column c = f.getAnnotation(Column.class);
            try {
                sb.append(c!=null ? f.get(cd) : "null").append(';');
            } catch (IllegalAccessException | NullPointerException e) {
                logger.severe("Exception at " + e.getStackTrace()[0]);
            }
        }
        rows[0] = sb.toString();
        return rows;
    }
    @SuppressWarnings("unused")
    public String[] getColumns() {
        String[] columns = new String[ELEMENTS.size()];
        Field[] fields = CD_CLASS.getDeclaredFields();
        int itr = 0;
        StringBuilder sb;
        for (CD cd : ELEMENTS) {
            sb = new StringBuilder();
            for (Field f : fields) {
                f.setAccessible(true);
                Column c = f.getAnnotation(Column.class);
                try {
                    sb.append(c!=null ? f.get(cd) : "null").append(';');
                } catch (IllegalAccessException | NullPointerException e) {
                    logger.severe("Exception at " + e.getStackTrace()[0]);
                }
            }
            columns[itr++] = sb.toString();
        }
        return columns;
    }
}

