package com.uca.pncsegundoparcialcoworking.service.impl;

import com.uca.pncsegundoparcialcoworking.domain.entity.Space;
import com.uca.pncsegundoparcialcoworking.domain.enums.SpaceType;
import com.uca.pncsegundoparcialcoworking.dto.SpaceRequestDTO;
import com.uca.pncsegundoparcialcoworking.exception.BusinessRuleException;
import com.uca.pncsegundoparcialcoworking.exception.ResourceNotFoundException;
import com.uca.pncsegundoparcialcoworking.repository.SpaceRepository;
import com.uca.pncsegundoparcialcoworking.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

    @Override
    public Space createSpace(SpaceRequestDTO dto) {
        if (spaceRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new BusinessRuleException("Ya existe un espacio con el nombre: " + dto.getName());
        }

        Space space = Space.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .type(dto.getType())
                .capacity(dto.getCapacity())
                .pricePerHour(dto.getPricePerHour())
                .available(dto.getAvailable() != null ? dto.getAvailable() : true)
                .floor(dto.getFloor())
                .amenities(dto.getAmenities())
                .build();

        return spaceRepository.save(space);
    }

    @Override
    public List<Space> getAllSpaces(SpaceType type, Boolean available) {
        if (type != null && available != null) {
            return spaceRepository.findByTypeAndAvailable(type, available);
        } else if (type != null) {
            return spaceRepository.findByType(type);
        } else if (available != null) {
            return spaceRepository.findByAvailable(available);
        }
        return spaceRepository.findAll();
    }

    @Override
    public Space getSpaceById(Long id) {
        return spaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espacio no encontrado con id: " + id));
    }

    @Override
    public Space updateSpace(Long id, SpaceRequestDTO dto) {
        Space existing = spaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espacio no encontrado con id: " + id));

        if (!existing.getName().equalsIgnoreCase(dto.getName())
                && spaceRepository.existsByNameIgnoreCaseAndIdNot(dto.getName(), id)) {
            throw new BusinessRuleException("Ya existe un espacio con el nombre: " + dto.getName());
        }

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setType(dto.getType());
        existing.setCapacity(dto.getCapacity());
        existing.setPricePerHour(dto.getPricePerHour());
        existing.setFloor(dto.getFloor());
        existing.setAmenities(dto.getAmenities());
        if (dto.getAvailable() != null) {
            existing.setAvailable(dto.getAvailable());
        }

        return spaceRepository.save(existing);
    }

    @Override
    public Space deleteSpace(Long id) {
        Space existing = spaceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Espacio no encontrado con id: " + id));

        if (Boolean.FALSE.equals(existing.getAvailable())) {
            throw new BusinessRuleException(
                    "No se puede eliminar el espacio '" + existing.getName() + "' porque no está disponible (está en uso o bloqueado)");
        }

        spaceRepository.deleteById(id);
        return existing;
    }
}
