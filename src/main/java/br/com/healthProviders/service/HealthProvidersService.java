package br.com.healthProviders.service;

import br.com.healthProviders.dto.InsuredLocationDto;
import br.com.healthProviders.dto.ProviderDto;

import java.util.List;

public interface HealthProvidersService {

    List<ProviderDto> findHealthProvidersFiltered(InsuredLocationDto insuredLocationDto);
}
