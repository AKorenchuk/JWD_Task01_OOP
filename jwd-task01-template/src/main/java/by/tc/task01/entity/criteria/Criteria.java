package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

import static by.tc.task01.service.validation.Validator.FieldType;

public class Criteria<E> {

	private String applianceType;

	private Map<E, Object> criteria = new HashMap<E, Object>();

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	public Map<E, Object> getCriteria(){
		return criteria;
	}

	public static <E>String getCriteriaToString(String applianceType,E criteria,Object value){
		Object typeCriteria = (FieldType(applianceType, criteria));
		Object temp=value.toString();

		if (typeCriteria instanceof Double  && value instanceof Integer) {
			temp = Double.parseDouble( value.toString() );
		}
		if(typeCriteria instanceof Integer && value instanceof Double){
			temp =(int) (Double.parseDouble(value.toString() ) + 0.5);
		}
		if(typeCriteria instanceof Character){
			temp =(value.toString()).charAt(0);;
		}
		if(typeCriteria.getClass()==value.getClass()){
			temp = value.toString() ;
		}
		return (String)(criteria + "=" + temp);
	}

	public String getApplianceType(){
		return this.applianceType;
	}

	public void setApplianceType(String applianceType){
		this.applianceType=applianceType;
	}

}
