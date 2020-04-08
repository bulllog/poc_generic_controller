package com.dlab.demo.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.DataInput;
import java.io.IOException;

public class RequestDeserializer extends JsonDeserializer<RequestInterface> {
    private final static String STUDENT = "Student";
    private final static String EMPLOYEE = "Employee";

    @Override
    public RequestInterface deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends RequestInterface> instanceClass;

        String instanceType = getInstanceType(root);

        switch (instanceType) {
            case STUDENT:
                instanceClass = Student.class;
                break;
            case EMPLOYEE:
                instanceClass = Employee.class;
                break;
            default:
                throw new IOException("Instance type not found");
        }
        return mapper.convertValue(root, instanceClass);
    }

    /**
     * Override this method to change the condition for instance type.
     * @param root
     * @return
     */
    private String getInstanceType(ObjectNode root) {
        if(root.get("rollNo") != null) {
            return STUDENT;
        } else {
            return EMPLOYEE;
        }
    }
}
