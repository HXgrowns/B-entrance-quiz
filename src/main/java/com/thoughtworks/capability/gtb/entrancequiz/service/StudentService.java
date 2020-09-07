package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Team;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentReopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private StudentReopository studentReopository;

    public List<Student> findAll() {
        return studentReopository.getStudents();
    }

    public Map<String, List<Student>> groupByTeam() {
        Map<String, List<Student>> teamToStudents = new HashMap<>();

        List<Team> teams = studentReopository.getTeams();
        List<Student> students = studentReopository.getStudents();
        Collections.shuffle(students);

        int teamSize = students.size() / teams.size();
        int rest = students.size() % teams.size();

        int start = 0;
        for (int i = 0; i < teams.size(); i++) {
            String name = teams.get(i).getName();
            List<Student> stus = teamToStudents.getOrDefault(name, new ArrayList<>());

            if(rest > 0) {
                stus.addAll(students.subList(start, start + teamSize+1));
                rest--;
            } else {
                stus.addAll(students.subList(start, start + teamSize));
            }
            start += stus.size();

            teamToStudents.put(name,stus);
        }

        return teamToStudents;
    }
}
