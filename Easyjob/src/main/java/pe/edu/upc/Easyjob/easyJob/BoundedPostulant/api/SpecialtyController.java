package pe.edu.upc.Easyjob.easyJob.BoundedPostulant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.service.SpecialtyService;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping.SpecialtyMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.CreateSpecialtyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.SpecialtyResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.UpdateSpecialtyResource;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/specialties")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private SpecialtyMapper mapper;
    @GetMapping("/postulant/{postulantId}")
    public Page<SpecialtyResource> getAllSpecialtiesByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        return mapper.modelListToPage(specialtyService.getAllByPostulantId(postulantId), pageable);
    }
    @GetMapping("{specialtyId}")
    public SpecialtyResource getSpecialtyById(@PathVariable("specialtyId") Long specialtyId) {
        return mapper.toResource(specialtyService.getById(specialtyId));
    }
    @PostMapping("/postulant/{postulantId}")
    public SpecialtyResource createSpecialty(@PathVariable Long postulantId,
                                         @RequestBody CreateSpecialtyResource request) {
        return mapper.toResource(specialtyService.create(postulantId, mapper.toModel(request)));
    }
    @PutMapping("{specialtyId}")
    public SpecialtyResource updateSpecialty(@PathVariable Long specialtyId,
                                         @RequestBody UpdateSpecialtyResource request) {
        return mapper.toResource(specialtyService.update(specialtyId, mapper.toModel(request)));
    }
    @DeleteMapping("{specialtyId}")
    public ResponseEntity<?> deleteSpecialty(@PathVariable Long specialtyId) {
        return specialtyService.delete(specialtyId);
    }
    @GetMapping("/specialty/{search}")
    public Page<SpecialtyResource> getBtSpecialtiesOrExperience(@PathVariable("search") String specialty,@PathVariable("search") String experience ,Pageable pageable) {
        return mapper.modelListToPage(specialtyService.getBySpecialtyOrExperience(specialty,experience), pageable);
    }
}
