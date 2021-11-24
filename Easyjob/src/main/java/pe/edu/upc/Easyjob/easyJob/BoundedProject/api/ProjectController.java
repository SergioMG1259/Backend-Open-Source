package pe.edu.upc.Easyjob.easyJob.BoundedProject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.domain.service.ProjectService;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.mapping.ProjectMapper;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.CreateProjectResource;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.ProjectResource;
import pe.edu.upc.Easyjob.easyJob.BoundedProject.resource.UpdateProjectResource;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectMapper mapper;
    @GetMapping("/postulant/{postulantId}")
    public Page<ProjectResource> getAllProjectsByPostulantId(@PathVariable Long postulantId, Pageable pageable) {
        return mapper.modelListToPage(projectService.getAllByPostulantId(postulantId), pageable);
    }
    @GetMapping("{projectId}")
    public ProjectResource getProjectById(@PathVariable("projectId") Long projectId) {
        return mapper.toResource(projectService.getById(projectId));
    }
    @PostMapping("/postulant/{postulantId}")
    public ProjectResource createProject(@PathVariable Long postulantId,
                                         @RequestBody CreateProjectResource request) {
        return mapper.toResource(projectService.create(postulantId, mapper.toModel(request)));
    }
    @PutMapping("{projectId}")
    public ProjectResource updateProject(@PathVariable Long projectId,
                                         @RequestBody UpdateProjectResource request) {
        return mapper.toResource(projectService.update(projectId, mapper.toModel(request)));
    }
    @DeleteMapping("{projectId}")
    public ResponseEntity<?> deleteProject(
                                           @PathVariable Long projectId) {
        return projectService.delete(projectId);
    }
}
