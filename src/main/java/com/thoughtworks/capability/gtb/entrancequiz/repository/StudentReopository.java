package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.utils.StudentsConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class StudentReopository {
    private List<Student> students;

    public StudentReopository() {
        this.students = StudentsConverter.getStudents();
    }
}
