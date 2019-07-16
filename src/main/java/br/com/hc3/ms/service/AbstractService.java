package br.com.hc3.ms.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public <T> List<T> convert(List<Object> convertTo, Class<T> classToConvert) {
    	loadModelMapper();
    	return convertTo.stream().map(element -> convert(element, classToConvert)).collect(Collectors.toList());
    }
}
