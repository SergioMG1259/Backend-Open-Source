package pe.edu.upc.Easyjob.easyJob.api;

import pe.edu.upc.Easyjob.easyJob.domain.service.PostulantService;
import pe.edu.upc.Easyjob.easyJob.mapping.PostulantMapper;
import pe.edu.upc.Easyjob.easyJob.resource.PostulantResource;
import pe.edu.upc.Easyjob.easyJob.resource.CreatePostulantResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Easyjob.easyJob.resource.UpdatePostulantResource;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/postulants")
public class PostulantsController {
    @Autowired
    private PostulantService postulantService;
    @Autowired
    private PostulantMapper mapper;
    @GetMapping
    public Page<PostulantResource>getAllPostulants(Pageable pageable){
        return mapper.modelListToPage(postulantService.getAll(), pageable);
    }
    @GetMapping("{postulantId}")
    public PostulantResource getPostulantById(@PathVariable("postulantId")Long postulantId){
        return mapper.toResource(postulantService.getById(postulantId));
    }
    @PostMapping
    public PostulantResource createPostulant(@RequestBody CreatePostulantResource request){
        return mapper.toResource(postulantService.create(mapper.toModel(request)));
    }
    @PutMapping("{postulantId}")
    public PostulantResource updatePostulant(@PathVariable Long postulantId, @RequestBody UpdatePostulantResource request) {
        return mapper.toResource(postulantService.update(postulantId, mapper.toModel(request)));
    }

    @DeleteMapping("{postulantId}")
    public ResponseEntity<?> deletePostulant(@PathVariable Long postulantId) {
        return postulantService.delete(postulantId);
    }

}
