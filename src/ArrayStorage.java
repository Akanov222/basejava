import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[4];
    int count = 0;

    void clear() {
        Arrays.fill(storage, null);
		count = 0;
    }
    void save(Resume r) {
        storage[count] = r;
        count++;
    }
    Resume get(String uuid) {
        int number = getNumber(uuid);
        if (number == -1) {
			System.out.println("Resume is not found");
			return null;
		}
		return storage[number];
    }
    void delete(String uuid) {
		int number = getNumber(uuid);
		if (number == -1) {
			System.out.println("Resume is not found");
		} else {
			if (number != count) {
				while (number < count) {
					storage[number] = storage[number + 1];
					storage[number + 1] = null;
					number++;
				}
			} else {
				storage[number] = null;
			}
		}
    }
    Resume[] getAll() {
		Resume[] tempResume = new Resume[count];
    	System.arraycopy (storage, 0, tempResume, 0, count);
    	return tempResume;
    }
    int size() {
        return count;
    }
    int getNumber(String uuid) {
		for (int i = 0; i < count; i++) {
			if (storage[i].uuid.equals(uuid)) {
				return i;
			}
		}
		return -1;
	}
}
