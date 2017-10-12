package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public class VacuumCleaner extends Appliance{

    private int powerConsumption;
    private char filterType;
    private String bagType;
    private String wandType;
    private int motorSpeed;
    private int cleaningWidth;

    public VacuumCleaner(){}

    VacuumCleaner(int powerConsumption,char filterType,String bagType,String wandType, int motorSpeed, int cleaningWidth){
        this.powerConsumption=powerConsumption;
        this.filterType=filterType;
        this.bagType=bagType;
        this.wandType=wandType;
        this.motorSpeed=motorSpeed;
        this.cleaningWidth=cleaningWidth;
    }

    public VacuumCleaner(String[] components) {
        for(int i=1;i<components.length;i++) {
            String[] word = components[i].split("=");
            switch (word[0]) {
                case "POWER_CONSUMPTION":
                    this.setPowerConsumption(Integer.parseInt(word[1]));
                    break;
                case "FILTER_TYPE":
                    this.setFilterType(word[1].charAt(0));
                    break;
                case "BAG_TYPE":
                    this.setBagType(word[1]);
                    break;
                case "WAND_TYPE":
                    this.setWandType(word[1]);
                    break;
                case "MOTOR_SPEED_REGULATION":
                    this.setMotorSpeed(Integer.parseInt(word[1]));
                    break;
                case "CLEANING_WIDTH":
                    this.setCleaningWidth(Integer.parseInt(word[1]));
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

    public char  getFilterType() {
        return filterType;
    }

    public void  setFilterType(char filterType) {
        this.filterType = filterType;
    }

    public String  getBagType() {
        return bagType;
    }

    public void  setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String  getWandType() {
        return wandType;
    }

    public void  setWandType(String wandType) {
        this.wandType = wandType;
    }

    public int  getMotorSpeed() {
        return motorSpeed;
    }

    public void  setMotorSpeed(int motorSpeed) {
        this.motorSpeed = motorSpeed;
    }

    public int  getCleaningWidth() {
        return cleaningWidth;
    }

    public void  setCleaningWidth(int cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    public String toString()
    {
        String c = this.getClass().getSimpleName()+" : "+
                SearchCriteria.VacuumCleaner.POWER_CONSUMPTION+"="+getPowerConsumption()+", "+
                SearchCriteria.VacuumCleaner.FILTER_TYPE+"="+getFilterType()+", "+
                SearchCriteria.VacuumCleaner.BAG_TYPE+"="+getBagType()+", "+
                SearchCriteria.VacuumCleaner.WAND_TYPE+"="+getWandType()+", "+
                SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION+"="+getMotorSpeed()+", "+
                SearchCriteria.VacuumCleaner.CLEANING_WIDTH+"="+getCleaningWidth();
        return c+";";
    }
}
