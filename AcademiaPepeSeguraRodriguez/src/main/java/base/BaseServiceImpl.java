package base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public class BaseServiceImpl <T, ID, R extends JpaRepository<T, ID>> 
=======
public class BaseServiceImpl<T, ID, R extends JpaRepository<T, ID>> 
>>>>>>> bea6ad7cdd1dcd1ecc1ff2f343d38f3b827969f5
	implements BaseService<T, ID>{
    @Autowired
    protected R repository;
    
    
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public T edit(T t) {
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
        
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);        
    }
<<<<<<< HEAD
=======

>>>>>>> bea6ad7cdd1dcd1ecc1ff2f343d38f3b827969f5
}