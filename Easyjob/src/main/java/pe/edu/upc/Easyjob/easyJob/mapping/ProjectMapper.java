package pe.edu.upc.Easyjob.easyJob.mapping;

import pe.edu.upc.Easyjob.easyJob.domain.model.entity.Project;
import pe.edu.upc.Easyjob.easyJob.resource.ProjectResource;
import pe.edu.upc.Easyjob.easyJob.resource.CreateProjectResource;
import pe.edu.upc.Easyjob.easyJob.resource.UpdateProjectResource;
import pe.edu.upc.Easyjob.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ProjectMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public ProjectResource toResource(Project model) {
        return mapper.map(model, ProjectResource.class);
    }
    public Page<ProjectResource> modelListToPage(List<Project> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProjectResource.class), pageable, modelList.size());
    }
    public Project toModel(CreateProjectResource resource){return mapper.map(resource,Project.class);}
    public Project toModel(UpdateProjectResource resource) {
        return mapper.map(resource, Project.class);
    }
}
