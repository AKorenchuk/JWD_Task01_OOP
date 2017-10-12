package by.tc.task01.entity;

public class Appliance {

    public Appliance() {    }

    public static Appliance createAppliance(String criteriaClass, String[] info) {
        if( criteriaClass.equals("Oven")){
            return new Oven(info);
        }
        if( criteriaClass.equals("Laptop")){
            return new Laptop(info);
        }
        if( criteriaClass.equals("Refrigerator")){
            return new Refrigerator(info);
        }

        if( criteriaClass.equals("Speakers")){
            return new Speakers(info);
        }

        if( criteriaClass.equals("TabletPC")){
            return new TabletPC(info);
        }

        if( criteriaClass.equals("VacuumCleaner")){
            return new VacuumCleaner(info);
        }
        return null;
    }
}
