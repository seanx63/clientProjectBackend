package seanx63.clientproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seanx63.clientproject.domain.Project;
import seanx63.clientproject.domain.ProjectRespository;

@RestController
public class ProjectController {
	@Autowired
	private ProjectRespository repository;

	@RequestMapping("/projects")
	public Iterable<Project> getProjects() {
		return repository.findAll();
	}
}
