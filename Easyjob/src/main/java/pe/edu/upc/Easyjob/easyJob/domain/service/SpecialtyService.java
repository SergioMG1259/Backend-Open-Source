package pe.edu.upc.Easyjob.easyJob.domain.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Specialty;

import java.util.List;
public interface SpecialtyService {
    List<Specialty> getAllByPostulantId(Long postulantId);
    Page<Specialty> getAllByPostulantId(Long postulantId, Pageable pageable);
    Specialty create(Long postulantId, Specialty request);
    Specialty getByIdAndPostulantId(Long postulantId, Long specialtyId);
    Specialty update(Long postulantId, Long specialtyId, Specialty request);
    ResponseEntity<?> delete(Long postulantId, Long specialtyId);
}
