package com.sling.com.sling.bundle;

import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = ClassService.class, immediate=true)
@Designate(ocd = MyConfiguration.class)
public class ClassConfigurationService implements ClassService {

	@Reference
	private MyConfiguration config;

	@Activate
	void activate() {
		
		System.out.println("Max marks required = "+config.get_marks());
		System.out.println("Max number of students ="+config.get_max_students());
	}
	
	@Override
	public boolean isClassLimitReached(List li) {
		
	if(li.size() >= config.get_max_students())
		return true;
	else return false;
	}
	
	@Override
	public int getPassingMarks() {
		return config.get_marks();
	}
	
}
