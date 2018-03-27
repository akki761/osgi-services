package com.sling.com.sling.bundle;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="My Configuration" , description = "Service Configuration")
public @interface MyConfiguration {
	
@AttributeDefinition(name="Passing Marks" , description = "Marks requierd to pass")
int get_marks();

@AttributeDefinition(name="Max Student Limit" , description = "Maximum number of students")
int get_max_students();

}
