package pe.edu.upc.Easyjob.easyJob.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Postulant;

import java.util.List;

public interface PostulantService {
    List<Postulant>getAll();
    Page<Postulant> getAll(Pageable pageable);
    Postulant getById(Long postulantId);
    Postulant create(Postulant postulant);
    Postulant update(Long postulantId,Postulant request);
    ResponseEntity<?>delete(Long postulantId);
}
