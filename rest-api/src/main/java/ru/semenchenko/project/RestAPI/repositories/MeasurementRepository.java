package ru.semenchenko.project.RestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.semenchenko.project.RestAPI.models.Measurement;

/**
 * @author Artyom Semenchenko
 */

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
