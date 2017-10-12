package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Refrigerator extends Appliance{
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private int height;
    private int widht;

    public Refrigerator(){
    }


    public Refrigerator(String[] components) {
        for(int i=1;i<components.length;i++) {
            String[] word = components[i].split("=");
            switch (word[0]) {
                case "POWER_CONSUMPTION":
                    this.setPowerConsumption(Integer.parseInt(word[1]));
                    break;
                case "WEIGHT":
                    this.setWeight(Integer.parseInt(word[1]));
                    break;
                case "FREEZER_CAPACITY":
                    this.setFreezerCapacity(Integer.parseInt(word[1]));
                    break;
                case "WIDTH":
                    this.setWidht(Integer.parseInt(word[1]));
                    break;
                case "HEIGHT":
                    this.setHeight(Integer.parseInt(word[1]));
                    break;
                case "OVERALL_CAPACITY":
                    this.setOverallCapacity(Double.parseDouble(word[1]));
                    break;
            }
        }

    }

    public int  getPowerConsumption() {
        return powerConsumption;
    }

    public void  setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int  getWeight() {
        return weight;
    }

    public void  setWeight(int weight) {
        this.weight = weight;
    }

    public int  getFreezerCapacity() {
        return freezerCapacity;
    }

    public void  setFreezerCapacity(int freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public double  getOverallCapacity() {
        return overallCapacity;
    }

    public void  setOverallCapacity(double depth) {
        this.overallCapacity = overallCapacity;
    }

    public int  getHeight() {
        return height;
    }

    public void  setHeight(int height) {
        this.height = height;
    }

    public int  getWidht() {
        return widht;
    }

    public void  setWidht(int widht) {
        this.widht = widht;
    }

    public String toString()
    {
        String c = this.getClass().getSimpleName()+" : "+
                SearchCriteria.Refrigerator.POWER_CONSUMPTION+"="+getPowerConsumption()+", "+
                SearchCriteria.Refrigerator.WEIGHT+"="+getWeight()+", "+
                SearchCriteria.Refrigerator.FREEZER_CAPACITY+"="+getFreezerCapacity()+", "+
                SearchCriteria.Refrigerator.OVERALL_CAPACITY+"="+getOverallCapacity()+", "+
                SearchCriteria.Refrigerator.HEIGHT+"="+getHeight()+", "+
                SearchCriteria.Refrigerator.WIDTH+"="+getWidht();
        return c+";";
    }
}
