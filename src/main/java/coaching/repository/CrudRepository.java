package coaching.repository;

import java.util.Collection;

/**
 * Generic CRUD repository
 */
public interface CrudRepository<T> {

    /**
     * Save data into persistence storage
     * When an exception occurs, continue to next item
     *
     * @param data
     * @return number of successfully saved item
     */
    int save(Collection<T> data);

    /**
     * Save data into persistence storage in batch
     * When an exception occurs, rollback
     *
     * @param data
     * @return
     */
    void saveBatch(Collection<T> data);

    int saveSingle(T data);

    /**
     * Get all data existing in storage
     *
     * @return Data
     */
    Collection<T> findAll();
}
