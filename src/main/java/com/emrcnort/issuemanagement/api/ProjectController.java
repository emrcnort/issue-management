package com.emrcnort.issuemanagement.api;

import com.emrcnort.issuemanagement.dto.ProjectDto;
import com.emrcnort.issuemanagement.service.impl.ProjectServiceImpl;
import com.emrcnort.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController( ProjectServiceImpl projectServiceImpl)
    {
        this.projectServiceImpl = projectServiceImpl;

    }
    /**
     * Http Methods
     * GET
     * POST
     * PUT
     * DELETE
     */
   @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable (value ="id",required = true)Long id)
    {
      ProjectDto projectDto =projectServiceImpl.getById(id);
      return ResponseEntity.ok(projectDto); // .ok -> Http 200
    }


    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody  ProjectDto project)
    {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    //@RequestMapping(path = "/update", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable (value = "id", required = true)Long id, @Valid @RequestBody  ProjectDto project)
    {
       return ResponseEntity.ok(projectServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (value = "id",required = true) Long id)
    {
      return ResponseEntity.ok(projectServiceImpl.delete(id));
    }


}
