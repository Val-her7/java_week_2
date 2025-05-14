public class CsvRows {

    String direction;
    String year;
    String country;
    String commodity;
    String transportMode;
    String value;
    String measure;

    static int numberOfRows = 0;

    CsvRows(String direction, String year, String country, String value){
        this.direction = direction;
        this.year = year;
        this.country = country;
        this.value = value;
        numberOfRows ++;
    }

    //OVERLOADED CONSTRUCTOR
    CsvRows(String direction, String year, String country, String measure, String value){
        this.direction = direction;
        this.year = year;
        this.country = country;
        this.measure = measure;
        this.value = value;
        numberOfRows ++;
    }

    //OVERLOADED CONSTRUCTOR
    CsvRows(String direction, String year, String country,String commodity, String transportMode, String value){
        this.direction = direction;
        this.year = year;
        this.country = country;
        this.commodity = commodity;
        this.transportMode = transportMode;
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

    String getCommodity(){
        return this.commodity;
    }

    String getTransportMode(){
        return this.transportMode;
    }

    String getValue(){
        return this.value;
    }

    String getMeasure(){
        return this.measure;
    }

    @Override
    public String toString(){
        return "Direction: " + this.direction + " Country: " + this.country + " Commodity: " + this.commodity + " Transport_Mode: " + this.transportMode + " Value: " + this.value;
    }
}