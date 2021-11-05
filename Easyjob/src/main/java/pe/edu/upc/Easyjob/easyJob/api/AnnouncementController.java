package pe.edu.upc.Easyjob.easyJob.api;
import pe.edu.upc.Easyjob.easyJob.domain.service.AnnouncementService;
import pe.edu.upc.Easyjob.easyJob.mapping.AnnouncementMapper;
import pe.edu.upc.Easyjob.easyJob.resource.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/companies/{companyId}/announcements")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;
    @Autowired
    private AnnouncementMapper mapper;
    @GetMapping
    public Page<AnnouncementResource> getAllAnnouncementsByCompanyId(@PathVariable Long companyId, Pageable pageable) {
        return mapper.modelListToPage(announcementService.getAllByCompanyId(companyId), pageable);
    }
    @GetMapping("{announcementId}")
    public AnnouncementResource getAnnouncementById(@PathVariable("companyId") Long companyId,
                                            @PathVariable("announcementId") Long announcementId) {
        return mapper.toResource(announcementService.getByIdAndCompanyId(companyId, announcementId));
    }
    @PostMapping
    public AnnouncementResource createAnnouncement(@PathVariable Long companyId,
                                           @RequestBody CreateAnnouncementResource request) {
        return mapper.toResource(announcementService.create(companyId, mapper.toModel(request)));
    }
    @PutMapping("{announcementId}")
    public AnnouncementResource updateAnnouncement(@PathVariable Long companyId,
                                          @PathVariable Long announcementId,
                                          @RequestBody UpdateAnnouncementResource request) {
        return mapper.toResource(announcementService.update(companyId, announcementId, mapper.toModel(request)));
    }
    @DeleteMapping("{announcementId}")
    public ResponseEntity<?> deleteAnnouncement(@PathVariable Long companyId,
                                            @PathVariable Long announcementId) {
        return announcementService.delete(companyId, announcementId);
    }
}
