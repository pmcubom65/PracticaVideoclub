package dao;


import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    default Optional<T> get(long id) { return null; };
    
    default List<T> getAll() { return null; };
     
    default void save(T t) {};
     
    default void update(T t, String[] params) {};
     
    default void delete(T t) {};
    
    default void delete() {};
    
    default List<T> getAll(String s) { return null; }
    default void update(String s) {}
}
