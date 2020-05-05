package br.com.healthProviders.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeographicCoordinatesDto {

    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
}
