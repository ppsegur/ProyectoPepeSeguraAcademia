package base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T,ID> {
	
	List<T> findAll();
    
    	Optional<T> findById(ID id);
    
	    T save(T t);
	    
	    T edit(T t);
	    
	    void delete(T t);
	    
	    void deleteById(ID id);
}
<<<<<<< HEAD

=======
>>>>>>> bea6ad7cdd1dcd1ecc1ff2f343d38f3b827969f5
