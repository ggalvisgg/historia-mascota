package com.historia_mascota.persistence;

import com.historia_mascota.domain.TipoDesparacitacionDomain;
import com.historia_mascota.domain.repository.TipoDesparacitacionRepository;
import com.historia_mascota.persistence.crud.TypeDewormingCRUDRepository;
import com.historia_mascota.persistence.entity.TypeDewormingEntity;
import com.historia_mascota.persistence.mapper.TipoDesparacitacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TypeDewormingRepository implements TipoDesparacitacionRepository {

    @Autowired
    private TypeDewormingCRUDRepository typeDewormingCRUDRepository;

    @Autowired
    private TipoDesparacitacionMapper mapper;

    @Override
    public List<TipoDesparacitacionDomain> traerTodosTipos() {
        List<TypeDewormingEntity> dewormings = (List<TypeDewormingEntity>) typeDewormingCRUDRepository.findAll();
        return mapper.toTipoDesparacitaciones(dewormings);
    }

    @Override
    public Optional<TipoDesparacitacionDomain> traerPorId(int id) {
        return typeDewormingCRUDRepository.findById(id)
                .map(deworming -> mapper.toTipoDesparacitacion(deworming));
    }

    @Override
    public TipoDesparacitacionDomain guardarTipo(TipoDesparacitacionDomain tipoDesparacitacionDomain) {
        TypeDewormingEntity typeDeworming = mapper.toTypeDeworming(tipoDesparacitacionDomain);
        return mapper.toTipoDesparacitacion(typeDewormingCRUDRepository.save(typeDeworming));
    }
}
