package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
	private final static Storage ARRAY_STORAGE = new ArrayStorage();

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

		printAll();

		System.out.println("Get resume1: " + ARRAY_STORAGE.get(resume1.getUuid()));
		System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
		System.out.println("Size: " + ARRAY_STORAGE.size());

		ARRAY_STORAGE.update(resume4);
		printAll();

		ARRAY_STORAGE.delete("uuid2");
		printAll();

		ARRAY_STORAGE.clear();
		printAll();

		System.out.println("Size: " + ARRAY_STORAGE.size());
	}

	private static void printAll() {
		System.out.println("\nGet All");
		for (Resume resume : ARRAY_STORAGE.getAll()) {
			System.out.println(resume);
		}
	}

}
