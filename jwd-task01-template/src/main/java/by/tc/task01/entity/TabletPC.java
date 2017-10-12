package by.tc.task01.entity;

import by.tc.task01.entity.criteria.SearchCriteria;

public class TabletPC extends Appliance{

    private int batteryCapacity;
    private int displayInches;
    private int memoryROM;
    private int flashMemoryROM;
    private String color;

    public TabletPC(){}


    public TabletPC(String[] components) {
        for(int i=0;i<components.length;i++) {
            String[] word = components[i].split("=");
            switch (word[0]) {
                case "BATTERY_CAPACITY":
                    this.setBatteryCapacity(Integer.parseInt(word[1]));
                    break;
                case "DISPLAY_INCHES":
                    this.setDisplayInchs(Integer.parseInt(word[1]));
                    break;
                case "MEMORY_ROM":
                    this.setMemoryROM(Integer.parseInt(word[1]));
                    break;
                case "FLASH_MEMORY_CAPACITY":
                    this.setFlashMemoryROM(Integer.parseInt(word[1]));
                    break;
                case "COLOR":
                    this.setColor(word[1]);
                    break;
            }
        }
    }

    public int  getBatteryCapacity() {
        return batteryCapacity;
    }

    public void  setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int  getDisplayInchs() {
        return displayInches;
    }

    public void  setDisplayInchs(int  displayInchs) {
        this.displayInches = displayInchs;
    }

    public int  getMemoryROM() {
        return memoryROM;
    }

    public void  setMemoryROM(int  memoryROM) {
        this.memoryROM = memoryROM;
    }

    public int  getFlashMemoryROM() {
        return flashMemoryROM;
    }

    public void  setFlashMemoryROM(int  flashMemoryROM) {
        this.flashMemoryROM = flashMemoryROM;
    }

    public String  getColor() {
        return color;
    }

    public void  setColor(String color) {
        this.color = color;
    }

    public String toString()
    {
        String c = this.getClass().getSimpleName()+" : "+
                SearchCriteria.TabletPC.BATTERY_CAPACITY+"="+getBatteryCapacity()+", "+
                SearchCriteria.TabletPC.DISPLAY_INCHES+"="+getDisplayInchs()+", "+
                SearchCriteria.TabletPC.MEMORY_ROM+"="+getMemoryROM()+", "+
                SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY+"="+getFlashMemoryROM()+", "+
                SearchCriteria.TabletPC.COLOR+"="+getColor();

        return c+";";
    }
}
