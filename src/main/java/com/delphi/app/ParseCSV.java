package main.java.com.delphi.app;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ParseCSV extends AbstractColumnData {
    private static final Object[] OBJECTS = Main.ELEMENTS.toArray();
    String[] rows = new String[OBJECTS.length];
    String[] columns = new String[Main.ELEMENTS.size()];

    @Override
    public String getValue(String key) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        Class<CD> cl = CD.class;
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Column.class)) {
                    Column c = f.getAnnotation(Column.class);
                    for (Object ob : OBJECTS) {
                        if (c.name().equals(key)) {
                            sb.append(f.get(ob).toString()).append(System.lineSeparator());
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String[] getRow() throws IllegalAccessException {

        int itr = 0;
        Class<CD> cl = CD.class;
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Annotation[] annotations = f.getDeclaredAnnotations();
            for (Annotation a : annotations) {
                if (a.annotationType().equals(Column.class)) {
                    Column c = f.getAnnotation(Column.class);
                    for (Object ob : OBJECTS) {
                        if (c.name().equals("ARTIST")) {
                            try (FileWriter csvWriter = new FileWriter("newCSV.csv", true)) {
                                rows[itr] = f.get(ob).toString();
                                csvWriter.append(rows[itr++]).append(System.lineSeparator());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            }
        }
        return rows;
    }

    @Override
    public String[] getColumns() {
        int itr = 0;
                    for (CD cd : Main.ELEMENTS){
                        try (FileWriter csvWriter = new FileWriter("newCSV.csv", true)) {
                            columns[itr] = cd.toString();
                            csvWriter.append(columns[itr++]).append(System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
        }
        return columns;
    }
}

