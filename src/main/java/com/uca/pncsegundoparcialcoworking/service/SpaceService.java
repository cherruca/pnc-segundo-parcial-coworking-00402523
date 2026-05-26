package com.uca.pncsegundoparcialcoworking.service;

import com.uca.pncsegundoparcialcoworking.domain.entity.Space;
import com.uca.pncsegundoparcialcoworking.domain.enums.SpaceType;
import com.uca.pncsegundoparcialcoworking.dto.SpaceRequestDTO;

import java.util.List;

public interface SpaceService {
    Space createSpace(SpaceRequestDTO dto);
    List<Space> getAllSpaces(SpaceType type, Boolean available);
    Space getSpaceById(Long id);
    Space updateSpace(Long id, SpaceRequestDTO dto);
    Space deleteSpace(Long id);
}
