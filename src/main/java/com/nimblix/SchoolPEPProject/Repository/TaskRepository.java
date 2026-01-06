package com.nimblix.SchoolPEPProject.Repository;

import com.nimblix.SchoolPEPProject.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
