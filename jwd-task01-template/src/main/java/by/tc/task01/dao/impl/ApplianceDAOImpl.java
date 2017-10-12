package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static by.tc.task01.entity.Appliance.createAppliance;
import static by.tc.task01.service.validation.Validator.FieldType;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
    public <E> Appliance find(Criteria<E> criteria) throws IOException {

		List<String> listOfAppliance = Files.readAllLines(Paths.get("jwd-task01-template/src/main/resources/appliances_db.txt"), Charset.defaultCharset());

		for(String line: listOfAppliance){
			String[] infoAboutCriteria = line.split("[,;:\\s]+");
			String applianceType = infoAboutCriteria[0];

			if(applianceType.equals(criteria.getApplianceType())) {

				Map<E, Object> mapCriteria = criteria.getCriteria();

                boolean concurrency=false;
				for (Map.Entry<E, Object> entry : mapCriteria.entrySet()) {

                    Object typeCriteria = FieldType(criteria.getApplianceType(), entry.getKey());
                    String pairCriteria=Criteria.getCriteriaToString(criteria.getApplianceType(), entry.getKey(),entry.getValue());

					for(int i = 1; i < infoAboutCriteria.length; i++) {

						String[] searchCirteria = infoAboutCriteria[i].split("=");
						Object s=null;
                        String dfg= (String) (entry.getKey()+"");

						if(dfg.equals(searchCirteria[0])){

						    if(typeCriteria instanceof Double)
						        s = Double.parseDouble(searchCirteria[1]);
                            if(typeCriteria instanceof Integer)
                                s = Integer.parseInt(searchCirteria[1]);
                            if(typeCriteria instanceof Character)
                                s =searchCirteria[1].charAt(0);
                            if(typeCriteria instanceof String)
                                s = searchCirteria[1];

                            concurrency = pairCriteria.equalsIgnoreCase(searchCirteria[0]+"="+s);
                            if(!concurrency) {
                                break;

                            }
						}
                    }

					if(!concurrency) {
						break;

					}
				}


				if(concurrency) {
					return createAppliance(applianceType,infoAboutCriteria);
				}
			}

		}
		return null;
	}


}