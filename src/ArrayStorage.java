import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    public Resume[] storage = new Resume[10000];
    private int count = 0;
    private Resume tempOneResume = null;

    public void clear() {
        Arrays.fill(storage, null);
    }

    public void save(Resume r) {
        storage[count] = r;
        count++;
    }

    public Resume get(String uuid) {
        findUuid(uuid);
        return tempOneResume;
    }

    public void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                storage[i] = null;
            }
        }
        deleteNull();
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        deleteNull();
        return Arrays.copyOf(storage, storage.length);
    }

    int size() {
        return count;
    }
    private void findUuid(String uuid) {
        for (Resume resume : storage) {
            if (resume.getUuid().equals(uuid)) {
                tempOneResume = resume;
                break;
            }
        }
    }
    private void deleteNull() {
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

