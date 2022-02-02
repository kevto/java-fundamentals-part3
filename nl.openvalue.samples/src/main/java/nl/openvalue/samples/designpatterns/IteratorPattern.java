package nl.openvalue.samples.designpatterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPattern {

    public static class Student {
        private String naam;
        private int leeftijd;

        public Student(String naam, int leeftijd) {
            this.naam = naam;
            this.leeftijd = leeftijd;
        }

        public String getNaam() {
            return naam;
        }

        public int getLeeftijd() {
            return leeftijd;
        }
    }

    public static class Klas implements Iterable<Student> {
        private List<Student> studenten = new ArrayList<>();

        public Klas() {

        }

        public void add(Student student) {
            studenten.add(student);
        }

        public List<Student> getStudenten() {
            return studenten;
        }

        public Iterator<Student> iterator() {
            return studenten.iterator();
        }
    }

    public static class KlasIterator implements Iterator<Student> {
        private List<Student> studenten;
        private int index = 0;

        public KlasIterator(List<Student> studenten) {
            this.studenten = studenten;
        }

        @Override
        public boolean hasNext() {
            return studenten.size() > index;
        }

        @Override
        public Student next() {
            Student student = studenten.get(index);
            index++;
            return student;
        }
    }

    public static void main(String[] args) {
        Klas klas = new Klas();
        klas.add(new Student("piet", 18));
        klas.add(new Student("jan", 18));
        klas.add(new Student("anne", 18));

        for(Student student : klas) {
            System.out.println(student.getNaam());
        }

        for(Student student : klas.getStudenten()) {
            System.out.println(student.getNaam());
        }
    }

}
