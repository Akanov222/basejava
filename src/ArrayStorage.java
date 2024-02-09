import java.util.Arrays;
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count;

    void clear() {
        Arrays.fill(storage,0, count - 1, null);
        count = 0;
    }
    
    void save(Resume r) {
        storage[count] = r;
        count++;
    }
    
    Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("Resume is not found");
            return null;
        }
        return storage[index];
    }
    
    void delete(String uuid) {
        int index = findIndex(uuid);
        storage[index] = storage[count - 1];
        storage[count - 1] = null;
        count--;
    }
    
    Resume[] getAll() {
        Resume[] resumes = new Resume[count];
        System.arraycopy(storage, 0, resumes, 0, count);
        return resumes;
    }
    
    int size() {
        return count;
    }
    
    int findIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}