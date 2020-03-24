package com.emrcnort.issuemanagement.service;

import com.emrcnort.issuemanagement.dto.IssueDto;
import com.emrcnort.issuemanagement.entity.Issue;
import com.emrcnort.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete (IssueDto issue);
}
