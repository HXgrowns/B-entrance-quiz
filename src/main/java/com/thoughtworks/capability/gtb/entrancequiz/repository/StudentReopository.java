package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import com.thoughtworks.capability.gtb.entrancequiz.utils.StudentsConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class StudentReopository {
    private List<Student> students;
    private List<Team> teams;

    public StudentReopository() {
        this.students = StudentsConverter.getStudents();
        this.teams = Arrays.asList(
                new Team("Team 1"),
                new Team("Team 2"),
                new Team("Team 3"),
                new Team("Team 4"),
                new Team("Team 5"),
                new Team("Team 6")
        );
    }
}
