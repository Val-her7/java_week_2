public enum Measurements {
    M, CM, MM;

    public double convertToMeter(double value){
        switch(this){
            case M:
             return value;
            case CM:
             return value / 100;
            case MM:
             return value / 1000;
            default:
             return 0;
        }
    }
}
