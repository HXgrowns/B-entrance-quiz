package com.thoughtworks.capability.gtb.entrancequiz.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;

import java.util.List;

import static com.thoughtworks.capability.gtb.entrancequiz.utils.ResourceUtils.loadResource;

public class StudentsConverter {
    public static List<Student> getStudents() {
        return JsonUtils.unmarshal(loadResource("/fixtures/students.json"),
                new TypeReference<List<Student>>() {});
    }
}
