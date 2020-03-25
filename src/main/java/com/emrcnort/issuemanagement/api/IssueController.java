package com.emrcnort.issuemanagement.api;


import com.emrcnort.issuemanagement.dto.IssueDto;
import com.emrcnort.issuemanagement.service.impl.IssueServiceImpl;
import com.emrcnort.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }
    /**
     * Http Methods
     * GET
     * POST
     * PUT
     * DELETE
     */
   @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable (value ="id",required = true)Long id)
    {
        IssueDto issueDto =issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto); // .ok -> Http 200
    }


    @PostMapping
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody  IssueDto project)
    {
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }

    //@RequestMapping(path = "/update", method = RequestMethod.PUT)
    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable (value = "id", required = true)Long id, @Valid @RequestBody  IssueDto issue)
    {
       return ResponseEntity.ok(issueServiceImpl.update(id,issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable (value = "id",required = true) Long id)
    {
      return ResponseEntity.ok(issueServiceImpl.delete(id));
    }


}
