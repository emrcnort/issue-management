package com.emrcnort.issuemanagement.entity;


import lombok.*;

import javax.persistence.*;


@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Project  extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "projectCode",unique = true)
    private String projectCode;

    @Column(name = "projectName",length = 1000)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private User manager;
}
