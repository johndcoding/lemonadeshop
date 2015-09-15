package com.johndcoding.lemonadeshop.view.converter;

import com.johndcoding.lemonadeshop.view.dto.ClientDTO;
import com.johndcoding.lemonadeshop.view.dto.CommandeDTO;
import com.johndcoding.lemonadeshop.view.form.CreationCommandeForm;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;


public class CommandeFormConverter implements FormConverter<CreationCommandeForm, CommandeDTO> {


    @Override
    public CommandeDTO convertToDTO(CreationCommandeForm creationCommandeForm) {
        final List<String> mappingFiles = new ArrayList<String>();
        mappingFiles.add("dozer-mapping.xml");
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(mappingFiles);

        final CommandeDTO result = mapper.map(creationCommandeForm, CommandeDTO.class);
        return result;
    }
}
