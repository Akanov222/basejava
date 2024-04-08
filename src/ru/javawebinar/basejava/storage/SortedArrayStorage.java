package ru.javawebinar.basejava.storage;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

	@Override
	protected int findIndex(String uuid) {
		Resume searchKey = new Resume();
		searchKey.saveUuid(uuid);
		return Arrays.binarySearch(storage, 0, size, searchKey);
	}

	@Override
	public void clear() {

	}

	@Override
	public void save(Resume resume) {

	}

	@Override
	public void update(Resume resume) {

	}

	@Override
	public void delete(String uuid) {

	}

	@Override
	public Resume[] getAll() {
		return new Resume[0];
	}
}
