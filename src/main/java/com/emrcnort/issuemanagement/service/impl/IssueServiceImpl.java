package com.emrcnort.issuemanagement.service.impl;

import com.emrcnort.issuemanagement.dto.IssueDto;
import com.emrcnort.issuemanagement.entity.Issue;
import com.emrcnort.issuemanagement.repository.IssueRepository;
import com.emrcnort.issuemanagement.service.IssueService;
import com.emrcnort.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    //Save metotları entity'nin repositorysi üzerinden yapılır.
    //IssueRepository, bu sınıfa constructor yardımıyla enjekte edildi.
    //2. yöntem => @Autowired Anotasyonu
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper)
    {
        this.issueRepository= issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {

        if(issue.getDate()==null)
            throw new IllegalArgumentException("Issue Date cannot be null");

        Issue issueDb = modelMapper.map(issue, Issue.class);;
        issueDb = issueRepository.save(issueDb);

        return  modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {

        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;

    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }



    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
