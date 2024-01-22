/*
package com.example.techlab.servicesImp;

import com.example.techlab.dto.PlanificationDTO;
import com.example.techlab.entities.Planification;
import com.example.techlab.exceptions.CustomException;
import com.example.techlab.repositories.PlanificationRepository;
import com.example.techlab.services.PlanificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanificationServiceImp implements PlanificationService {
    private final PlanificationRepository planificationRepository;
    private final PlanificationMapper planificationMapper;

    @Autowired
    public PlanificationServiceImp(PlanificationRepository planificationRepository, PlanificationMapper planificationMapper) {
        this.planificationRepository = planificationRepository;
        this.planificationMapper = planificationMapper;
    }

    @Override
    public List<PlanificationDTO> obtenirPlanification() {
        List<PlanificationDTO> planificationDTOList = planificationRepository
                .findAll()
                .stream()
                .map(planificationMapper::toDTO)
                .collect(Collectors.toList());
        return planificationDTOList;
    }

    @Override
    public PlanificationDTO ajouterPlanification(PlanificationDTO planificationDTO) {
        Planification planification = planificationMapper.toEntity(planificationDTO);
        planificationRepository.save(planification);
        return planificationMapper.toDTO(planification);
    }

    @Override
    public PlanificationDTO obtenirPlanificationParId(Long idPlanification) {
        Optional<Planification> planificationOptional = planificationRepository.findById(idPlanification);
        if (!planificationOptional.isPresent()) {
            throw new CustomException("patient avec "+idPlanification+"  est introuvable ", HttpStatus.NOT_FOUND);
        } else {
            PlanificationDTO planificationDTO = planificationMapper.toDTO(planificationOptional.get());
            return planificationDTO;
        }
    }

    @Override
    public PlanificationDTO modifierAnalyse(Long idPlanification, PlanificationDTO planificationDTO) {
        Optional<Planification> existingPlanificationOptional = planificationRepository.findById(idPlanification);
        if (!existingPlanificationOptional.isPresent()) {
            throw new CustomException("patient avec "+idPlanification+"  est introuvable ", HttpStatus.NOT_FOUND);
        }

        Planification existingPlanification = existingPlanificationOptional.get();

        existingPlanification.setDateDebut(planificationDTO.getDateDebut());
        existingPlanification.setDateFin(planificationDTO.getDateFin());

        Planification updatedPlanification = planificationRepository.save(existingPlanification);

        return planificationMapper.toDTO(updatedPlanification);
    }

    @Override
    public void supprimerPlanification(Long idPlanification) {
        Optional<Planification> existingPlanificationOptional = planificationRepository.findById(idPlanification);
        if (!existingPlanificationOptional.isPresent()) {
            throw new CustomException("patient avec "+idPlanification+"  est introuvable ", HttpStatus.NOT_FOUND);
        }else {
            planificationRepository.deleteById(idPlanification);
        }
    }
}
*/
