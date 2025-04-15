package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    final String uuid1 = "uuid1";
    final Resume resume1 = new Resume(uuid1);
    final String uuid2 = "uuid2";
    final Resume resume2 = new Resume(uuid2);
    final String uuid3 = "uuid8";
    final Resume resume3 = new Resume(uuid3);
    final String uuid4 = "uuid4";
    final Resume resume4 = new Resume(uuid4);
    final String uuid5 = "uuid5";
    final Resume resume5 = new Resume(uuid5);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setup() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
        storage.save(resume4);
        storage.save(resume5);
    }

    @Test
    public void save() {
        storage.delete(resume5.getUuid());
        storage.save(resume5);
        assertEquals(5, storage.size());
        assertGet(resume5);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume5);
    }

    @Test
    public void getAllArrayStorage() {
        if (storage instanceof ArrayStorage) {
            Resume[] array = storage.getAll();
            assertEquals(5, array.length);
            assertEquals(resume1, array[0]);
            assertEquals(resume2, array[1]);
            assertEquals(resume3, array[2]);
            assertEquals(resume4, array[3]);
            assertEquals(resume5, array[4]);
        }
    }

    @Test
    public void getAllSortedArrayStorage() {
        if (storage instanceof SortedArrayStorage) {
            Resume[] array = storage.getAll();
            assertEquals(5, array.length);
            for (int i = 0; i < array.length - 1; i++) {
                assertTrue(array[i].compareTo(array[i + 1]) < 0);
            }
        }
    }

    @Test
    public void get() {
        assertGet(resume1);
        assertGet(resume2);
        assertGet(resume3);
        assertGet(resume4);
        assertGet(resume5);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void size() {
        assertSize(5);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(uuid4);
        storage.update(newResume);
        assertEquals(newResume, storage.get(uuid4));
    }

    @Test(expected = NotExistStorageException.class)
    public void upDateNotExist() {
        Resume newResume = new Resume("dummy");
        storage.update(newResume);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(uuid4);
        assertSize(4);
        storage.get(uuid4);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test(expected = StorageException.class)
    public void storageOverFlow() {
        try {
            storage.clear();
            for(int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume(Integer.toString(i)));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("overflow"));
    }



    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}
