public class Car {
    private String plateNo;
    private String color;
    private int year;
    private String make;
    private String model;

    public Car(String plateNo, String color, int year, String make, String model) {
        this.plateNo = plateNo;
        this.color = color;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNo='" + plateNo + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
