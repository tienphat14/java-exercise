package coaching.repository;

import coaching.model.Staff;

import javax.sql.DataSource;
import java.util.Collection;

/**
 * Staff repository
 */
public class StaffRepository implements CrudRepository<Staff> {

    /**
     * Initialize
     *
     * @param dataSource Data source
     */
    public StaffRepository(DataSource dataSource) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @param data Data
     */
    @Override
    public void save(Collection<Staff> data) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public int[] saveBatch(Collection<Staff> data) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Collection<Staff> findAll() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }
}
