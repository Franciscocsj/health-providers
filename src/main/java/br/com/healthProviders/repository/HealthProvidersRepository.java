package br.com.healthProviders.repository;

import br.com.healthProviders.model.ProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HealthProvidersRepository extends JpaRepository<ProviderModel, Long> {

    @Query("from ProviderModel p where p.name = :specialty ")
    List<ProviderModel> findBySpecialty(@Param("specialty") String specialty);
}
