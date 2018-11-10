import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size=0;

    void clear() {
        for (int i=0; i<size(); i++)
            storage[i] = null;
        size=0;
    }

    void save(Resume resume) {
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        int i=0;
        while ((i < size)&&(!storage[i].uuid.equals(uuid)))
            i++;
        if (i < size) {
            while (i < size) {
                storage[i] = storage[i + 1];
                i++;
            }
            storage[size] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (size > 0) return Arrays.copyOf(storage, size);
        return new Resume[0];
    }

    int size() {
        return size;
    }
}



