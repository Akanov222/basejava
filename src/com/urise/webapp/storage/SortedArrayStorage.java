package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteAndMoveElements(int index) {
        int tmpIndex = size - 1 - index;
        if (tmpIndex > 0) {
            System.arraycopy(storage, index + 1, storage, index, tmpIndex);
        }
    }

    protected void insertResume(Resume resume, int index) {
        int tmpIndex = - index - 1;
        if (size - tmpIndex <= 0 || storage[tmpIndex] == null) {
            storage[tmpIndex] = resume;
        } else {
            System.arraycopy(storage, tmpIndex, storage, tmpIndex + 1, size - tmpIndex);
            storage[tmpIndex] = resume;
        }
    }

    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
