package com.emrcnort.issuemanagement.api;

import com.emrcnort.issuemanagement.dto.ProjectDto;
import com.emrcnort.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
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
    public ResponseEntity<ProjectDto> getById(@PathVariable ("id")Long id)
    {
      ProjectDto projectDto =projectServiceImpl.getById(id);
      return ResponseEntity.ok(projectDto); // .ok -> Http 200
    }


    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody  ProjectDto project)
    {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

}
