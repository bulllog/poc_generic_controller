package com.dlab.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RequestDeserializer.class)
public interface RequestInterface {
}
