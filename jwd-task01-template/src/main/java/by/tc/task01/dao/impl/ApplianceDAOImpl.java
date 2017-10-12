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

                    String criteriaSearch=Criteria.getCriteriaToString(applianceType, entry.getKey(),entry.getValue());

					for(int i = 1; i < infoAboutCriteria.length; i++) {

						String[] pairCriteria = infoAboutCriteria[i].split("=");

						if((entry.getKey().toString()).equals(pairCriteria[0])){

							String criteriaAppliance=Criteria.getCriteriaToString(applianceType, entry.getKey(),pairCriteria[1]);
						    concurrency = criteriaSearch.equalsIgnoreCase(criteriaAppliance);

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