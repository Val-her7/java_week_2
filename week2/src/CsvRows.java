public class CsvRows {

    String direction;
    String year;
    String country;
    String value;

    static int numberOfRows = 0;

    CsvRows(String direction, String year, String country, String value){
        this.direction = direction;
        this.year = year;
        this.country = country;
        this.value = value;
        numberOfRows ++;
    }

    String getDirection(){
        return this.direction;
    }

    String getYear(){
        return this.year;
    }

    String getCountry(){
        return this.country;
    }

    String getValue(){
        return this.value;
    }
}