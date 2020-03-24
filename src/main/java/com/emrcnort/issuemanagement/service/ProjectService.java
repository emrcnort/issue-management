package com.emrcnort.issuemanagement.service;

import com.emrcnort.issuemanagement.dto.ProjectDto;
import com.emrcnort.issuemanagement.entity.Project;
import com.emrcnort.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode (String projectCode);

    List<ProjectDto> getByProjectCodeContains (String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete (ProjectDto project);
}
