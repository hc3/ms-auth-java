package br.com.hc3.ms.service;

import org.modelmapper.ModelMapper;

public abstract class AbstractService {

    private ModelMapper modelMapper;

    private void loadModelMapper() {
        if(modelMapper == null) {
            modelMapper = new ModelMapper();
        }
    }

    public <T> T convert(Object convertTo, Class<T> classToConvert) {
        loadModelMapper();
        return (T) modelMapper.map(convertTo, classToConvert);
    }
}
