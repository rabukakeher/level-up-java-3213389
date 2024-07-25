package com.linkedin.javacodechallenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
                Map<String, Integer> studentToEventCountMap = new HashMap<>();
                HashSet<String> duplicateStudents = new HashSet<>();
                attendeesMapping.entrySet().stream().forEach(entrySet -> {
                        duplicateStudents.clear();
                        entrySet.getValue().stream().forEach(student -> {
                                if(!duplicateStudents.contains(student)) {
                                        Integer count = studentToEventCountMap.get(student);
                                        if (count == null) {
                                                studentToEventCountMap.put(student, 1);
                                        } else {
                                                studentToEventCountMap.put(student, count + 1);
                                        }
                                }
                        duplicateStudents.add(student); 
                        });

                });

        return students.stream().filter(student -> {
                Integer count = studentToEventCountMap.get(student);
                if (count == null || count < 2) return true;
                return false;
        }).toList();
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }

}
