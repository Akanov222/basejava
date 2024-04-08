package ru.javawebinar.basejava.storage;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
	protected static final int STORAGE_LIMIT = 10000;
	protected final Resume[] storage = new Resume[STORAGE_LIMIT];
	protected int index;
	protected int size;

	public  int size() {
		return size;
	}

	public Resume get(String uuid) {
		index = findIndex(uuid);
		if (index == -1) {
			System.out.println("Resume is not found");
			return null;
		}
		return storage[index];
	}

	protected abstract int findIndex(String uuid);
}
