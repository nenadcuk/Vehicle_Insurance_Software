package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable {

    int plateNo;
    int modelYear;
    String manufacturer;
    int estimatedValue;
    int carDamage;

    public Vehicle(int plateNo, int modelYear, String manufacturer, int estimatedValue, int carDamage) {
        this.plateNo = plateNo;
        this.modelYear = modelYear;
        this.manufacturer = manufacturer;
        this.estimatedValue = estimatedValue;
        this.carDamage = carDamage;
    }

    public int getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(int plateNo) {
        this.plateNo = plateNo;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public int getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    @Override
    public String toString() {
        return  "Plate No: " + plateNo +
                "\nModel Year: " + modelYear +
                "\nManufacturer: " + manufacturer +
                "\nEstimated Value: " + estimatedValue +
                "\nCar Damage Level: " + carDamage;
    }
}
