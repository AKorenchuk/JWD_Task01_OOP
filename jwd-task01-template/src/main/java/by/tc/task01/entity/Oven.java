package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Oven extends Appliance{

    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double widht;

    public Oven(){    }

    public Oven(String[] components) {
        for(int i=1;i<components.length;i++){
            String[] word = components[i].split("=");
            if(word[0].equals("POWER_CONSUMPTION") ){
                this.setPowerConsumption(Integer.parseInt(word[1]));
            }
            if(word[0].equals( "WEIGHT")){
                this.setWeight(Integer.parseInt(word[1]));
            }
            if(word[0].equals("CAPACITY")){
                this.setCapacity(Integer.parseInt(word[1]));
            }
            if(word[0].equals("DEPTH")){
                this.setDepth(Integer.parseInt(word[1]));
            }
            if(word[0].equals("HEIGHT")){
                this.setHeight(Double.parseDouble(word[1]));
            }
            if(word[0].equals("WIDTH")) {
                this.setWidht(Double.parseDouble(word[1]));
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

    public int  getCapacity() {
        return capacity;
    }

    public void  setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int  getDepth() {
        return depth;
    }

    public void  setDepth(int depth) {
        this.depth = depth;
    }

    public double  getHeight() {
        return height;
    }

    public void  setHeight(double height) {
        this.height = height;
    }

    public double  getWidht() {
        return widht;
    }

    public void  setWidht(double widht) {
        this.widht = widht;
    }

    public String toString()
    {
        String c = this.getClass().getSimpleName()+" : "+
                SearchCriteria.Oven.POWER_CONSUMPTION+"="+getPowerConsumption()+", "+
                SearchCriteria.Oven.WIDTH+"="+getWidht()+", "+
                SearchCriteria.Oven.CAPACITY+"="+getCapacity()+", "+
                SearchCriteria.Oven.DEPTH+"="+getDepth()+", "+
                SearchCriteria.Oven.HEIGHT+"="+getHeight()+", "+
                SearchCriteria.Oven.WEIGHT+"="+getWeight();
        return c+";";
    }

}
