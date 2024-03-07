import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
	int STORAGE_LIMIT = 10000;
	private final Resume[] storage = new Resume[STORAGE_LIMIT];
	private int index;
	private int size;

	public void clear() {
		Arrays.fill(storage, 0, size, null);
		size = 0;
	}

	public void save(Resume resume) {
		index = findIndex(resume.getUuid());
		if (size >= STORAGE_LIMIT) {
			System.out.println("This storage is not overflow");
		} else if (index >= 0) {
			System.out.println("This resume is already in the repository");
		} else {
			storage[size] = resume;
			size++;
		}
	}

	public void update(Resume resume) {
		index = findIndex(resume.getUuid());
		if (index != -1) {
			storage[index] = resume;
		} else {
			System.out.println("This resume is not found");
		}
	}

	public Resume get(String uuid) {
		index = findIndex(uuid);
		if (index == -1) {
			System.out.println("Resume is not found");
			return null;
		}
		return storage[index];
	}

	public void delete(String uuid) {
		index = findIndex(uuid);
		if (index == -1) {
			System.out.println("Resume is not found");
		}
		storage[index] = storage[size - 1];
		storage[size - 1] = null;
		size--;
	}

	public Resume[] getAll() {
		Resume[] resumes = new Resume[size];
		return Arrays.copyOf(storage, size);
	}

	public int size() {
		return size;
	}

	private int findIndex(String uuid) {
		for (int i = 0; i < size; i++) {
			if (storage[i].getUuid().equals(uuid)) {
				return i;
			}
		}
		return -1;
	}
}
