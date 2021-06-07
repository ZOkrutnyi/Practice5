#Task 5
###1.	Create tool which can read input XML file with metadata and convert it to CSV file. Use provided DTO abstract class to map data from one format to another. 
      
    public abstract class AbstractColumnData {

        public String getValue(String key){
            //Implement functionality using reflection
            throw new UnsupportedOperationException();
        }

        public String[] getRow(){
            //Implement functionality using reflection
            throw new UnsupportedOperationException();
        }

        public String[] getColumns(){
            //Implement functionality using reflection
            throw new UnsupportedOperationException();
        }
    }
###Abstract class has to read all fields of inheritor class which has annotation @Column. Annotation column contains information about column name, column order and column type for expected CSV file.
###Don’t use maven or other project build automation frameworks
