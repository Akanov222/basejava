package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
	protected static final int STORAGE_LIMIT = 10000;
	protected final Resume[] storage = new Resume[STORAGE_LIMIT];
	protected int size;
	protected int index;

	public void clear() {
		Arrays.fill(storage, 0, size, null);
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
		int index = getIndex(resume.getUuid());
		if (index > 0) {
			System.out.println("Resume " + resume.getUuid() + " already exist");
		} else if (size >= storage.length) {
			System.out.println("Storage overflow");
		} else {
			insertResume(resume, index);
			size++;
		}
	}

	public void delete(String uuid) {
		int index = getIndex(uuid);
		if (index < 0) {
			System.out.println("Resume " + uuid + " not exist");
		} else {
			deleteAndMoveElements(index);
			storage[size - 1] = null;
			size--;
		}
	}

	public Resume[] getAll() {
		return Arrays.copyOfRange(storage, 0, size);
	}

	public Resume get(String uuid) {
		int index = getIndex(uuid);
		if (index < 0) {
			System.out.println("Resume " + uuid + " not exist");
			return null;
		}
		return storage[index];
	}

	public int size() {
		return size;
	}

	protected abstract void deleteAndMoveElements(int index);
	protected abstract void insertResume(Resume resume, int index);
	protected abstract int getIndex(String uuid);
}
