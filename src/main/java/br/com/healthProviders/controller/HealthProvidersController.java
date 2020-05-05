package br.com.healthProviders.controller;

import br.com.healthProviders.dto.InsuredLocationDto;
import br.com.healthProviders.dto.ProviderDto;
import br.com.healthProviders.service.HealthProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/health-providers")
public class HealthProvidersController {

    @Autowired
    private HealthProvidersService service;

    @GetMapping("/find/specialty")
    public ResponseEntity<ProviderDto> findHealthProviders(@RequestBody @Valid InsuredLocationDto insuredLocationDto) throws Exception {
        return new ResponseEntity(service.findHealthProvidersFiltered(insuredLocationDto), HttpStatus.OK);
    }
}
