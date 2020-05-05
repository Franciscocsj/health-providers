package br.com.healthProviders.service.impl;

import br.com.healthProviders.dto.InsuredLocationDto;
import br.com.healthProviders.dto.ProviderDto;
import br.com.healthProviders.exception.HealthProvidersNotFoundException;
import br.com.healthProviders.model.ProviderModel;
import br.com.healthProviders.repository.HealthProvidersRepository;
import br.com.healthProviders.service.HealthProvidersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class HealthProvidersServiceImpl implements HealthProvidersService {

    @Autowired
    private HealthProvidersRepository repository;

    @Override
    public List<ProviderDto> findHealthProvidersFiltered(InsuredLocationDto insuredLocationDto) {
        List<ProviderDto> specialties = findHealthProviders(insuredLocationDto);
        List<ProviderDto> specialtiesFiltered = new ArrayList<>();

        if (specialties != null && specialties.size() > 0) {
            specialties.forEach(specialty -> specialtiesFiltered.add(calculateDistanceSpecialty(insuredLocationDto, specialty)));
            specialtiesFiltered.sort(Comparator.comparingDouble(ProviderDto::getDistance));
            return specialtiesFiltered;
        } else {
            log.error("ERROR");
            throw new HealthProvidersNotFoundException("Specialty " + insuredLocationDto.getSpecialty() + " not found");
        }
    }

    private List<ProviderDto> findHealthProviders(InsuredLocationDto insuredLocationDto) {
        List<ProviderModel> listProviderModels = repository.findBySpecialty(insuredLocationDto.getSpecialty());
        List<ProviderDto> listProviderDto = converterToListDto(listProviderModels);

        return listProviderDto;
    }

    private List<ProviderDto> converterToListDto(List<ProviderModel> providerModelList) {
        return providerModelList.stream()
                .filter(Objects::nonNull)
                .map(providerModel -> ProviderDto.converterToDto(providerModel))
                .collect(Collectors.toList());
    }

    private ProviderDto calculateDistanceSpecialty(InsuredLocationDto insuredLocationDto, ProviderDto providerDto) {
        double distance = Math.sqrt(Math.pow(providerDto.getLatitude() - insuredLocationDto.getGeographicCoordinates().getLatitude(), 2) + Math.pow(providerDto.getLongitude() - insuredLocationDto.getGeographicCoordinates().getLongitude(), 2));
        providerDto.setDistance(distance);

        return providerDto;
    }
}
