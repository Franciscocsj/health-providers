package br.com.healthProviders.dto;

import br.com.healthProviders.model.ProviderModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderDto {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    @NotNull
    private double distance;

    public static ProviderDto converterToDto(ProviderModel model) {
        return ProviderDto
                .builder()
                .id(model.getId())
                .name(model.getName())
                .address(model.getAddress())
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .build();
    }
}
