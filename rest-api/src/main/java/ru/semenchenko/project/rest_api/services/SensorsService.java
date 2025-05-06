package ru.semenchenko.project.rest_api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Artyom Semenchenko
 */

@Service
@Transactional(readOnly = true)
public class SensorsService {
}
