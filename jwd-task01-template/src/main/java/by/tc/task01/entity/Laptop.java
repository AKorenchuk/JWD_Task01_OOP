package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Laptop extends Appliance{

    private double batteryCapacity;
    private String os;
    private int memoryROM;
    private int systemMemory;
    private double cpu;
    private int displayInchs;

    public Laptop(){

    }

//    public Laptop(double batteryCapacity, String os,int memoryROM, int systemMemory, double cpu, int displayInchs){
//        this.batteryCapacity=batteryCapacity;
//        this.os = os;
//        this.memoryROM = memoryROM;
//        this.systemMemory = systemMemory;
//        this.cpu = cpu;
//        this.displayInchs = displayInchs;
//    }

    public Laptop(String[] components) {
        for(int i=0;i<components.length;i++){
            String[] word = components[i].split("=");
            if(word[0].equals("MEMORY_ROM")){
                this.setMemoryROM(Integer.parseInt(word[1]));
            }
            if(word[0].equals("SYSTEM_MEMORY")){
                this.setSystemMemory(Integer.parseInt(word[1]));
            }
            if(word[0].equals("DISPLAY_INCHS")){
                this.setDisplayInchs(Integer.parseInt(word[1]));
            }
            if(word[0].equals("OS")){
                this.setOS(word[1]);
            }
            if(word[0].equals("CPU")){
                this.setCPU(Double.parseDouble(word[1]));
            }
            if(word[0].equals("BATTERY_CAPACITY")) {
                this.setBatteryCapacity(Double.parseDouble(word[1]));
            }
        }
    }


    public double  getBatteryCapacity() {
        return batteryCapacity;
    }

    public void  setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String  getOS() {
        return os;
    }

    public void  setOS(String os) {
        this.os = os;
    }

    public int  getMemoryROM() {
        return memoryROM;
    }

    public void  setMemoryROM(int  memoryROM) {
        this.memoryROM = memoryROM;
    }

    public int  getSystemMemory() {
        return systemMemory;
    }

    public void  setSystemMemory(int  systemMemory) {
        this.systemMemory = systemMemory;
    }

    public double  getCPU() {
        return cpu;
    }

    public void  setCPU(double cpu) {
        this.cpu = cpu;
    }

    public int  getDisplayInchs() {
        return displayInchs;
    }

    public void  setDisplayInchs(int  displayInchs) {
        this.displayInchs = displayInchs;
    }

    public String toString()
    {
        String c = this.getClass().getSimpleName()+" : "+
                SearchCriteria.Laptop.BATTERY_CAPACITY+"="+getBatteryCapacity()+", "+
                SearchCriteria.Laptop.OS+"="+getOS()+", "+
                SearchCriteria.Laptop.MEMORY_ROM+"="+getMemoryROM()+", "+
                SearchCriteria.Laptop.SYSTEM_MEMORY+"="+getSystemMemory()+", "+
                SearchCriteria.Laptop.CPU+"="+getCPU()+", "+
                SearchCriteria.Laptop.DISPLAY_INCHS+"="+getDisplayInchs();
        return c+";";
    }

}
