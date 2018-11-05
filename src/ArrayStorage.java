/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int searchIndex = 0, maxi = 0;

    void clear() {
        for (int i=0; i<size(); i++)
            storage[i] = null;
    }

    void save(Resume resume) {
        storage[size()] = resume;
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid == uuid)
                resume = storage[i];
        }
        return resume;
    }

    void delete(String uuid) {
        maxi = size();
        for (int i = 0; i < maxi; i++)
            if (storage[i].uuid == uuid) {
                searchIndex = i;
                break;
            }
        for (int i = searchIndex; i < maxi; i++)
            storage[i] = storage[i + 1];
        storage[maxi] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        maxi = size();
        Resume resume[] = new Resume[maxi];
        for (int i = 0; i < maxi; i++)
            resume[i] = storage[i];
        return resume;
    }

    int size() {
        searchIndex = 0;
        for (int i = 0; i < storage.length; i++)
            if (storage[i] == null) {
                searchIndex = i;
                break;
            }
        return (searchIndex);
    }
}



