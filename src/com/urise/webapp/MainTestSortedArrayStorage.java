package com.urise.webapp;

import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;
import com.urise.webapp.model.Resume;

public class MainTestSortedArrayStorage {

    public static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume resume1 = new Resume();
        resume1.setUuid("uuid1");
        final Resume resume2 = new Resume();
        resume2.setUuid("uuid2");
        final Resume resume3 = new Resume();
        resume3.setUuid("uuid8");
        final Resume resume4 = new Resume();
        resume4.setUuid("uuid4");
        final Resume resume5 = new Resume();
        resume5.setUuid("uuid5");

        System.out.println(resume1 == resume2);

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);
        ARRAY_STORAGE.save(resume4);
        ARRAY_STORAGE.save(resume5);

        printAllResumes();

        System.out.println("Get resume1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.update(resume4);
        printAllResumes();

        ARRAY_STORAGE.delete("uuid2");
        printAllResumes();

        ARRAY_STORAGE.clear();
        printAllResumes();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAllResumes() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAll()) {
            System.out.println(resume);
        }
        System.out.println();
    }
}
