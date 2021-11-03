package pe.edu.upc.Easyjob.easyJob.api;
import pe.edu.upc.Easyjob.easyJob.domain.service.EvidenceService;
import pe.edu.upc.Easyjob.easyJob.mapping.EvidenceMapper;
import pe.edu.upc.Easyjob.easyJob.resource.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/projects/{projectId}/evidences")
public class EvidenceController {
    @Autowired
    private EvidenceService evidenceService;
    @Autowired
    private EvidenceMapper mapper;
    @GetMapping
    public Page<EvidenceResource> getAllEvidencesByProjectId(@PathVariable Long projectId, Pageable pageable) {
        return mapper.modelListToPage(evidenceService.getAllByProjectId(projectId), pageable);
    }
    @GetMapping("{evidenceId}")
    public EvidenceResource getEvidenceById(@PathVariable("projectId") Long projectId,
                                          @PathVariable("evidenceId") Long evidenceId) {
        return mapper.toResource(evidenceService.getByIdAndProjectId(projectId, evidenceId));
    }
    @PostMapping
    public EvidenceResource createEvidence(@PathVariable Long projectId,
                                         @RequestBody CreateEvidenceResource request) {
        return mapper.toResource(evidenceService.create(projectId, mapper.toModel(request)));
    }
    @PutMapping("{evidenceId}")
    public EvidenceResource updateComment(@PathVariable Long projectId,
                                         @PathVariable Long evidenceId,
                                         @RequestBody UpdateEvidenceResource request) {
        return mapper.toResource(evidenceService.update(projectId, evidenceId, mapper.toModel(request)));
    }
    @DeleteMapping("{evidenceId}")
    public ResponseEntity<?> deleteEvidence(@PathVariable Long projectId,
                                           @PathVariable Long evidenceId) {
        return evidenceService.delete(projectId, evidenceId);
    }
}
