package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class Validator {

	public static <E> boolean criteriaValidator(Criteria<E> criteria) {

		Map<E, Object> mapCriteria = criteria.getCriteria();
		for (Map.Entry<E, Object> entry : mapCriteria.entrySet()) {
			Object criteriaValue=entry.getValue();
			E criteriaName=entry.getKey();
			// TODO:  if( checkFieldType(entry.getKey().getClass().getSimpleName(), applianceCriteria, criteriaValue)== false)
            if(!check(criteria.getApplianceType(), criteriaName, criteriaValue))
            	return false;
		}
		return true;
	}

	private static <E> boolean check(String criteriaClass, E key, Object value){
		return checkCorrectValue(FieldType(criteriaClass,key),value);
	}

	public static <E> Object FieldType(String criteriaClass, E key) {
		if( criteriaClass.equals("Oven")){
			return getTypeOvenCriteria(key);
		}
		if( criteriaClass.equals("Laptop")){
			return getTypeLaptopCriteria(key);
		}
		if( criteriaClass.equals("Refrigerator")){
			return getTypeRefrigeratorCriteria(key);
		}

		if( criteriaClass.equals("Speakers")){
			return getTypeSpeakersCriteria(key);
		}

		if( criteriaClass.equals("TabletPC")){
			return getTypeTabletPCCriteria(key);
		}

		if( criteriaClass.equals("VacuumCleaner")){
			return getTypeVacuumCleanerCriteria(key);
		}

		return null;
	}


	private static <E> Object getTypeVacuumCleanerCriteria(E criteria) {
		if (criteria == SearchCriteria.VacuumCleaner.POWER_CONSUMPTION ||
				criteria== SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION ||
				criteria== SearchCriteria.VacuumCleaner.CLEANING_WIDTH){
			return new Integer(0);
		}
		if (criteria == SearchCriteria.VacuumCleaner.BAG_TYPE || criteria== SearchCriteria.VacuumCleaner.WAND_TYPE){
			return  new String();
		}
		if (criteria == SearchCriteria.VacuumCleaner.FILTER_TYPE ){
			return new Character('a');
		}
		return null;
	}

	private static <E> Object getTypeTabletPCCriteria(E criteria) {
		if (criteria == SearchCriteria.TabletPC.MEMORY_ROM || criteria== SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY ||
				criteria== SearchCriteria.TabletPC.BATTERY_CAPACITY ||criteria== SearchCriteria.TabletPC.DISPLAY_INCHES ){
			return  new Integer(0);
		}
		if (criteria == SearchCriteria.TabletPC.COLOR ){
			return  new String();
		}
		return null;
	}

	private static <E> Object getTypeSpeakersCriteria(E criteria) {
		if (criteria == SearchCriteria.Speakers.POWER_CONSUMPTION || criteria== SearchCriteria.Speakers.NUMBER_OF_SPEAKERS ||
				criteria== SearchCriteria.Speakers.CORD_LENGTH){
			return  new Integer(0);
		}
		if (criteria == SearchCriteria.Speakers.FREQUENCY_RANGE ){
			return  new String();
		}
		return null;
	}

	private static <E> Object getTypeRefrigeratorCriteria(E criteria) {
		if (criteria == SearchCriteria.Refrigerator.POWER_CONSUMPTION || criteria == SearchCriteria.Refrigerator.WEIGHT ||
				criteria == SearchCriteria.Refrigerator.FREEZER_CAPACITY || criteria == SearchCriteria.Refrigerator.WIDTH
				|| criteria == SearchCriteria.Refrigerator.HEIGHT){
			return  new Integer(0);
		}
		if (criteria == SearchCriteria.Refrigerator.OVERALL_CAPACITY) {
			return  new Double(0);
		}
		return null;
	}

	private static <E> Object getTypeLaptopCriteria(E criteria) {
		if (criteria == SearchCriteria.Laptop.MEMORY_ROM || criteria == SearchCriteria.Laptop.DISPLAY_INCHS ||
				criteria == SearchCriteria.Laptop.SYSTEM_MEMORY) {
			return  new Integer(0);
		}
		if (criteria ==SearchCriteria.Laptop.BATTERY_CAPACITY || criteria==SearchCriteria.Laptop.CPU) {
			return  new Double(0);
		}
		if (criteria == SearchCriteria.Laptop.OS) {
			return  new String("");
		}
		return null;
	}

	private static <E> Object getTypeOvenCriteria(E criteria) {

		if (criteria == SearchCriteria.Oven.POWER_CONSUMPTION || criteria == SearchCriteria.Oven.WEIGHT ||
				criteria == SearchCriteria.Oven.CAPACITY || criteria == SearchCriteria.Oven.DEPTH  ){
			return  new Integer(0);
		}
		if (criteria == SearchCriteria.Oven.WIDTH || criteria == SearchCriteria.Oven.HEIGHT) {
			return  new Double(0);
		}

		return null;
	}



	private static boolean checkCorrectValue(Object type, Object value) {
		if (value.getClass() == type.getClass()) {
            return true;
        } else{
			if((type instanceof Double && value instanceof Integer)||(type instanceof Integer && value instanceof Double)) {
				return true;
			}
			if(type instanceof Character && (value instanceof String && ((String) value).length()==1)) {
				return true;
			}
		}
		return false;
	}
}
