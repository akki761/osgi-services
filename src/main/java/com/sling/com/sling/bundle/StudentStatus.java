package com.sling.com.sling.bundle;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;
import java.util.ArrayList;
import java.util.List;

public class StudentStatus implements Use{

    StudentService studentService;
    SlingHttpServletRequest request = null;
    String message = null;
    int id;

    @Override
    public void init(Bindings bindings) {
        request = (SlingHttpServletRequest) bindings.get("request");
        id = Integer.valueOf(request.getParameter("id"));
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        studentService = slingScriptHelper.getService(StudentService.class);
    }

    public String getMessage() {
        if(studentService.isStudentPassed(id)) {
            message = "Student is passed.";
        } else {
            message = "Student is not passed";
        }
        return message;
    }

}
