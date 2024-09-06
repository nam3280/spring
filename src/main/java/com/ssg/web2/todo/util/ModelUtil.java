package com.ssg.web2.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum ModelUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    ModelUtil(){
        this.modelMapper = new ModelMapper();
        this.modelMapper.getConfiguration()
                        .setFieldMatchingEnabled(true)
                        .setFieldAccessLevel(Configuration.AccessLevel.PACKAGE_PRIVATE)
                        .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get() {
        return modelMapper;
    }
}
