package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

	@Override
	protected void deleteAndMoveElements(int index) {
		storage[index] = storage[size - 1];
	}

	@Override
	protected void insertResume(Resume resume, int index) {
		storage[size] = resume;
	}


	@Override
	protected int getIndex(String uuid) {
		for (int i = 0; i < size; i++) {
			if (uuid.equals(storage[i].getUuid())) {
				return i;
			}
		}
		return -1;
	}
}
