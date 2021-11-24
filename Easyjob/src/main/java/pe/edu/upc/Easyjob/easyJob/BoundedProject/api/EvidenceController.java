package pe.edu.upc.Easyjob.easyJob.BoundedProject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.service.EvidenceService;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.mapping.EvidenceMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.CreateEvidenceResource;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.EvidenceResource;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.UpdateEvidenceResource;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/evidences")
public class EvidenceController {
    @Autowired
    private EvidenceService evidenceService;
    @Autowired
    private EvidenceMapper mapper;
    @GetMapping("/project/{projectId}")
    public Page<EvidenceResource> getAllEvidencesByProjectId(@PathVariable Long projectId, Pageable pageable) {
        return mapper.modelListToPage(evidenceService.getAllByProjectId(projectId), pageable);
    }
    @GetMapping("{evidenceId}")
    public EvidenceResource getEvidenceById(@PathVariable("evidenceId") Long evidenceId) {
        return mapper.toResource(evidenceService.getById(evidenceId));
    }
    @PostMapping("/project/{projectId}")
    public EvidenceResource createEvidence(@PathVariable Long projectId,
                                         @RequestBody CreateEvidenceResource request) {
        return mapper.toResource(evidenceService.create(projectId, mapper.toModel(request)));
    }
    @PutMapping("{evidenceId}")
    public EvidenceResource updateEvidence(@PathVariable Long evidenceId,
                                         @RequestBody UpdateEvidenceResource request) {
        return mapper.toResource(evidenceService.update(evidenceId, mapper.toModel(request)));
    }
    @DeleteMapping("{evidenceId}")
    public ResponseEntity<?> deleteEvidence(@PathVariable Long evidenceId) {
        return evidenceService.delete(evidenceId);
    }
}
