package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.model.entity.Specialty;

import java.util.List;
public interface SpecialtyService {
    List<Specialty> getAllByPostulantId(Long postulantId);
    Page<Specialty> getAllByPostulantId(Long postulantId, Pageable pageable);
    Specialty create(Long postulantId, Specialty request);
    Specialty getById(Long specialtyId);
    Specialty update(Long specialtyId, Specialty request);
    ResponseEntity<?> delete(Long specialtyId);
    List<Specialty>getBySpecialtyOrExperience(String specialty,String experience);
    Page<Specialty>getBySpecialtyOrExperience(String specialty,String experience,Pageable pageable);
}
