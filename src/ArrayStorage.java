import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
	Resume[] storage = new Resume[4];
	private int size = 0;

	public void clear() {
		if (size != 0) {
			Arrays.fill(storage, 0, size, null);
			size = 0;
		}
	}

	public void save(Resume resume) {
		if (findIndex(resume) == null) {
			storage[size] = resume;
			size++;
		} else {
			System.out.println("This resume is already in the repository");
		}
	}

	public void update(Resume resume) {
		Integer index = findIndex(resume);
		if (index != null) {
			storage[index] = resume;
		} else {
			System.out.println("This resume is not found");
		}
	}

	public Resume get(String uuid) {
		Integer index = findIndex(uuid);
		if (index == null) {
			System.out.println("Resume is not found");
			return null;
		}
		return storage[index];
	}

	public void delete(String uuid) {
		Integer index = findIndex(uuid);
		if (index == null) {
			System.out.println("Resume is not found");
		}
		storage[index] = storage[size - 1];
		storage[size - 1] = null;
		size--;
	}

	public Resume[] getAll() {
		Resume[] resumes = new Resume[size];
		System.arraycopy(storage, 0, resumes, 0, size);
		return resumes;
	}

	public int size() {
		return size;
	}

	private Integer findIndex(String uuid) {
		for (int i = 0; i < size; i++) {
			if (storage[i].getUuid().equals(uuid)) {
				return i;
			}
		}
		return null;
	}

	private Integer findIndex(Resume resume) {
		for (int i = 0; i < size; i++) {
			if (resume.equals(storage[i])) {
				return i;
			}
		}
		return null;
	}
}
