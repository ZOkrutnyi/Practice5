package main.java.com.delphi.app;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractColumnData {
    private static final String XML_FILE_PATH = "cd_catalog.xml";
    private static final List<CD> ELEMENTS = AppendElements.append(XML_FILE_PATH);
    private static final Class<CD> CD_CLASS = CD.class;
    private final Logger logger = Logger.getLogger(getClass().getName());
    private static int nextIndex = 0;

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
        nextIndex = ELEMENTS.size() > nextIndex ? nextIndex++ : 0;
        CD cd = ELEMENTS.get(nextIndex);
        StringBuilder sb = new StringBuilder();
        addToArray(fields, sb, cd);
        rows[0] = sb.toString();
        return rows;
    }

    @SuppressWarnings("unused")
    public String[] getColumns() {
        String[] columns = new String[ELEMENTS.size()];
        Field[] fields = CD_CLASS.getDeclaredFields();
        int itr = 0;

        for (CD cd : ELEMENTS) {
            StringBuilder sb = new StringBuilder();
            addToArray(fields, sb, cd);
            columns[itr++] = sb.toString();
        }
        return columns;
    }

    private void addToArray(Field[] fields, StringBuilder sb, CD cd) {
        for (Field f : fields) {
            f.setAccessible(true);
            boolean isAnnotated = f.isAnnotationPresent(Column.class);
            try {
                sb.append(isAnnotated ? f.get(cd) : "null").append(';');
            } catch (IllegalAccessException | NullPointerException e) {
                logger.severe("Exception at " + e.getStackTrace()[0]);
            }
        }
    }
}

