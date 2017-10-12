package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Speakers extends Appliance{

    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLenght;

    public Speakers(){}

    public Speakers(String[] components) {
        for(int i=1;i<components.length;i++) {
            String[] word = components[i].split("=");
            switch (word[0]) {
                case "POWER_CONSUMPTION":
                    this.setPowerConsumption(Integer.parseInt(word[1]));
                    break;
                case "NUMBER_OF_SPEAKERS":
                    this.setNumberOfSpeakers(Integer.parseInt(word[1]));
                    break;
                case "FREQUENCY_RANGE":
                    this.setFrequencyRange(word[1]);
                    break;
                case "CORD_LENGTH":
                    this.setCordLenght(Integer.parseInt(word[1]));
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

    public int  getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void  setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String  getFrequencyRange() {
        return frequencyRange;
    }

    public void  setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public int  getCordLenght() {
        return cordLenght;
    }

    public void  setCordLenght(int cordLenght) {
        this.cordLenght = cordLenght;
    }

    public String toString() {

        String c = this.getClass().getSimpleName() + " : " +
                SearchCriteria.Speakers.POWER_CONSUMPTION + "=" + getPowerConsumption() + ", " +
                SearchCriteria.Speakers.NUMBER_OF_SPEAKERS + "=" + getNumberOfSpeakers() + ", " +
                SearchCriteria.Speakers.FREQUENCY_RANGE + "=" + getFrequencyRange() + ", " +
                SearchCriteria.Speakers.CORD_LENGTH + "=" + getCordLenght();
        return c + ";";
    }

}
