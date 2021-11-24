package pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.api;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.domain.service.AnnouncementService;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.mapping.AnnouncementMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource.AnnouncementResource;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource.CreateAnnouncementResource;
import pe.edu.upc.Easyjob.easyJob.BoundedAnnouncement.resource.UpdateAnnouncementResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.BoundedPostulant.resource.PostulantResource;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private AnnouncementMapper mapper;
    @GetMapping
    public Page<AnnouncementResource>getAllCompanies(Pageable pageable){
        return mapper.modelListToPage(announcementService.getAll(), pageable);
    }
    @GetMapping("/company/{companyId}")
    public Page<AnnouncementResource> getAllAnnouncementsByCompanyId(@PathVariable Long companyId, Pageable pageable) {
        return mapper.modelListToPage(announcementService.getAllByCompanyId(companyId), pageable);
    }
    @GetMapping("{announcementId}")
    public AnnouncementResource getAnnouncementById(@PathVariable("announcementId") Long announcementId) {
        return mapper.toResource(announcementService.getById(announcementId));
    }
    @PostMapping("/company/{companyId}")
    public AnnouncementResource createAnnouncement(@PathVariable Long companyId,
                                           @RequestBody CreateAnnouncementResource request) {
        return mapper.toResource(announcementService.create(companyId, mapper.toModel(request)));
    }
    @PutMapping("{announcementId}")
    public AnnouncementResource updateAnnouncement(@PathVariable Long announcementId,
                                          @RequestBody UpdateAnnouncementResource request) {
        return mapper.toResource(announcementService.update(announcementId, mapper.toModel(request)));
    }
    @DeleteMapping("{announcementId}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable Long announcementId) {
        return announcementService.delete(announcementId);
    }
    @GetMapping("/NotPracticing")
    public Page<AnnouncementResource>getNotPracticing(Pageable pageable){
        return mapper.modelListToPage(announcementService.getNotPracticing("Practicante",true), pageable);
    }
    @GetMapping("/Practicing")
    public Page<AnnouncementResource>getPracticing(Pageable pageable){
        return mapper.modelListToPage(announcementService.getPracticing("Practicante",true), pageable);
    }
}
