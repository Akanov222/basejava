package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
//public class ArrayStorage extends AbstractArrayStorage {
public class ArrayStorage {

	private final Resume[] storage = new Resume[10000];
	private int size;

	public void clear() {
//		Arrays.fill(storage, 0, size, null);
		for (int i = 0; i < size; i++) {
			storage[i] = null;
		}
		size = 0;
	}

	public void update(Resume resume) {
		int index = getIndex(resume.getUuid());
		if (index == -1) {
			System.out.println("Resume " + resume.getUuid() + " not exist");
		} else {
			storage[index] = resume;
		}
	}

	public void save(Resume resume) {
		if (getIndex(resume.getUuid()) != -1) {
			System.out.println("Resume " + resume.getUuid() + " already exist");
		} else if (size >= storage.length) {
			System.out.println("Storage overflow");
		} else {
			storage[size] = resume;
			size++;
		}
	}

	public Resume get(String uuid) {
		int index = getIndex(uuid);
		if (index == -1) {
			System.out.println("Resume " + uuid + " not exist");
			return null;
		} else {
			return storage[index];
		}
	}

	public void delete(String uuid) {
		int index = getIndex(uuid);
		if (index == -1) {
			System.out.println("Resume " + uuid + " not exist");
		} else {
			storage[index] = storage[size - 1];
			storage[size - 1] = null;
			size--;
		}
	}

	public Resume[] getAll() {
		return Arrays.copyOfRange(storage, 0, size);
	}

	public int size() {
		return size;
	}

	protected int getIndex(String uuid) {
		for (int i = 0; i < size; i++) {
			if (uuid.equals(storage[i].getUuid())) {
				return i;
			}
		}
		return -1;
	}
}
