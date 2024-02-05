import java.util.Arrays;
/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[4];
    int count = 0;
    Resume tempResume = null;
    
    void clear() {
        Arrays.fill(storage, null);
    }
    void save(Resume r) {
        storage[count] = r;
        count++;
    }
    Resume get(String uuid) {
        tempResume = null;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                tempResume = storage[i];
            }
        }
        return tempResume;
    }
    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
        }
        deleteNull();
    }
    Resume[] getAll() {
        deleteNull();
        return Arrays.copyOf(storage, storage.length);
    }
    int size() {
        return count;
    }
    void deleteNull() {
        Resume[] tempResume = new Resume[storage.length - 1];
        count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                tempResume[count] = storage[i];
                count++;
            }
            storage = tempResume;
        }
    }
}