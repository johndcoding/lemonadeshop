package com.johndcoding.lemonadeshop.view.converter;


public interface FormConverter<ClassForm,ClassDTO> {

    ClassDTO convertToDTO(ClassForm form);


}
