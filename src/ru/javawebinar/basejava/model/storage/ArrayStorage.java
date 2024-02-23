import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
	int STORAGE_LIMIT = 10000;
	private final Resume[] storage = new Resume[STORAGE_LIMIT];
	private int size;

	public void clear() {
		Arrays.fill(storage, 0, size, null);
		size = 0;
	}

	public void save(Resume resume) {
		if (size >= STORAGE_LIMIT) {
			System.out.println("This storage is not overflow");
		} else if (findIndex(resume) >= 0) {
			System.out.println("This resume is already in the repository");
		} else if (findIndex(resume) == -1) {
			storage[size] = resume;
			size++;
		}
	}

	public void update(Resume resume) {
		int index = findIndex(resume);
		if (index != -1) {
			storage[index] = resume;
		} else {
			System.out.println("This resume is not found");
		}
	}

	public Resume get(String uuid) {
		int index = findIndex(uuid);
		if (index == -1) {
			System.out.println("Resume is not found");
			return null;
		}
		return storage[index];
	}

	public void delete(String uuid) {
		int index = findIndex(uuid);
		if (index == -1) {
			System.out.println("Resume is not found");
		}
		storage[index] = storage[size - 1];
		storage[size - 1] = null;
		size--;
	}

	public Resume[] getAll() {
		Resume[] resumes = new Resume[size];
		resumes = Arrays.copyOf(storage, size);
		return resumes;
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

	private int findIndex(Resume resume) {
		for (int i = 0; i < size; i++) {
			if (resume.equals(storage[i])) {
				return i;
			}
		}
		return -1;
	}
}
