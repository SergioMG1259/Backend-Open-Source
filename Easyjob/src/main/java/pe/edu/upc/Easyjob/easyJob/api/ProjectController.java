package pe.edu.upc.Easyjob.easyJob.api;

import pe.edu.upc.Easyjob.easyJob.domain.service.ProjectService;
import pe.edu.upc.Easyjob.easyJob.mapping.ProjectMapper;
import pe.edu.upc.Easyjob.easyJob.resource.ProjectResource;
import pe.edu.upc.Easyjob.easyJob.resource.CreateProjectResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.resource.UpdateProjectResource;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/postulants/{postulantId}/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectMapper mapper;
    @GetMapping
    public Page<ProjectResource> getAllProjectsByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        return mapper.modelListToPage(projectService.getAllByPostulantId(postulantId), pageable);
    }
    @GetMapping("{projectId}")
    public ProjectResource getProjectById(@PathVariable("postulantId") Long postulantId,
                                          @PathVariable("projectId") Long projectId) {
        return mapper.toResource(projectService.getByIdAndPostulantId(postulantId, projectId));
    }
    @PostMapping
    public ProjectResource createProject(@PathVariable Long postulantId,
                                         @RequestBody CreateProjectResource request) {
        return mapper.toResource(projectService.create(postulantId, mapper.toModel(request)));
    }
    @PutMapping("{projectId}")
    public ProjectResource updateProject(@PathVariable Long postulantId,
                                         @PathVariable Long projectId,
                                         @RequestBody UpdateProjectResource request) {
        return mapper.toResource(projectService.update(postulantId, projectId, mapper.toModel(request)));
    }
    @DeleteMapping("{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long postulantId,
                                           @PathVariable Long projectId) {
        return projectService.delete(postulantId, projectId);
    }
}
