package ru.semenchenko.project.rest_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.semenchenko.project.rest_api.models.Measurement;

/**
 * @author Artyom Semenchenko
 */

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
