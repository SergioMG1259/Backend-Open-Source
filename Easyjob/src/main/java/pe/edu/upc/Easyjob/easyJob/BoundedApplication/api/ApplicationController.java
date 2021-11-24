package pe.edu.upc.Easyjob.easyJob.BoundedApplication.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.domain.service.ApplicationService;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.mapping.ApplicationMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource.ApplicationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource.CreateApplicationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedApplication.resource.UpdateApplicationResource;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.domain.service.PostulantService;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.mapping.PostulantMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.PostulantResource;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private PostulantService postulantService;
    @Autowired
    private ApplicationMapper mapper;
    @Autowired
    private PostulantMapper mapperPostulant;
    @GetMapping
    public Page<ApplicationResource>getAllApplications(Pageable pageable){
        return mapper.modelListToPage(applicationService.getAllApplications(), pageable);
    }
    @GetMapping("/announcement/{announcementId}")
    public Page<ApplicationResource> getByAnnouncementId(@PathVariable Long announcementId, Pageable pageable) {
        return mapper.modelListToPage(applicationService.getApplicationsByAnnouncementId(announcementId), pageable);
    }
    @GetMapping("/announcement/{announcementId}/postulant/{postulantId}")
    public Page<ApplicationResource> getByAnnouncementIdAndPostulantId(@PathVariable("announcementId")Long announcementId,@PathVariable("postulantId") Long postulantId,Pageable pageable) {
        return mapper.modelListToPage(applicationService.getApplicationsByAnnouncementIdAndPostulantId(announcementId,postulantId), pageable);
    }
    @GetMapping("/postulant/{postulantId}")
    public PostulantResource getByPostulantId(@PathVariable("postulantId")Long postulantId){
        return mapperPostulant.toResource(postulantService.getById(postulantId));
    }
    @GetMapping("{applicationId}")
    public ApplicationResource getById(@PathVariable("applicationId") Long postulantId) {
        return mapper.toResource(applicationService.getById(postulantId));
    }
    @PostMapping("/announcement/{announcementId}/postulant/{postulantId}")
    public ApplicationResource createApplication(@PathVariable("announcementId")Long announcementId,
                                                 @PathVariable("postulantId")Long postulantId,
                                                 @RequestBody CreateApplicationResource request) {
        return mapper.toResource(applicationService.create(announcementId,postulantId, mapper.toModel(request)));
    }
    @PutMapping("{applicationId}")
    public ApplicationResource updateApplication(@PathVariable Long applicationId,
                                                   @RequestBody UpdateApplicationResource request) {
        return mapper.toResource(applicationService.update(applicationId, mapper.toModel(request)));
    }
    @DeleteMapping("{applicationId}")
    public ResponseEntity<?> deleteApplication(@PathVariable Long applicationId) {
        return applicationService.delete(applicationId);
    }
}
