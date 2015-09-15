package com.johndcoding.lemonadeshop.view.converter;


import com.johndcoding.lemonadeshop.view.dto.ClientDTO;
import com.johndcoding.lemonadeshop.view.form.CreationClientForm;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

public class ClientFormConverter implements FormConverter<CreationClientForm, ClientDTO> {


    @Override
    public ClientDTO convertToDTO(CreationClientForm form) {

        final List<String> mappingFiles = new ArrayList<String>();
        mappingFiles.add("dozer-mapping.xml");
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(mappingFiles);

        final ClientDTO result = mapper.map(form, ClientDTO.class);
        return result;
    }
}
