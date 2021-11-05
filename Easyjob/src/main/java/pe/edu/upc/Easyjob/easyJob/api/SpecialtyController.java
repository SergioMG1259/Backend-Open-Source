package pe.edu.upc.Easyjob.easyJob.api;

import pe.edu.upc.Easyjob.easyJob.domain.service.SpecialtyService;
import pe.edu.upc.Easyjob.easyJob.mapping.SpecialtyMapper;
import pe.edu.upc.Easyjob.easyJob.resource.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/postulants/{postulantId}/specialties")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private SpecialtyMapper mapper;
    @GetMapping
    public Page<SpecialtyResource> getAllSpecialtiesByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        return mapper.modelListToPage(specialtyService.getAllByPostulantId(postulantId), pageable);
    }
    @GetMapping("{specialtyId}")
    public SpecialtyResource getSpecialtyById(@PathVariable("postulantId") Long postulantId,
                                          @PathVariable("specialtyId") Long specialtyId) {
        return mapper.toResource(specialtyService.getByIdAndPostulantId(postulantId, specialtyId));
    }
    @PostMapping
    public SpecialtyResource createSpecialty(@PathVariable Long postulantId,
                                         @RequestBody CreateSpecialtyResource request) {
        return mapper.toResource(specialtyService.create(postulantId, mapper.toModel(request)));
    }
    @PutMapping("{specialtyId}")
    public SpecialtyResource updateSpecialty(@PathVariable Long postulantId,
                                         @PathVariable Long specialtyId,
                                         @RequestBody UpdateSpecialtyResource request) {
        return mapper.toResource(specialtyService.update(postulantId, specialtyId, mapper.toModel(request)));
    }
    @DeleteMapping("{specialtyId}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable Long postulantId,
                                           @PathVariable Long specialtyId) {
        return specialtyService.delete(postulantId, specialtyId);
    }
}
