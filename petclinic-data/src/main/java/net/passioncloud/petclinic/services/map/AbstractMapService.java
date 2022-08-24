package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.model.BaseEntity;
import net.passioncloud.petclinic.model.Owner;
import net.passioncloud.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    protected Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if (object == null) {
            throw new RuntimeException("Object to save cannot be null");
        }
        if (object.getId() == null) {
            object.setId(nextID());
        }
        map.put(object.getId(), object);
        return object;
    }


    @Override
    public void delete(T object) {
        map.entrySet().removeIf(i -> i.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    private Long nextID() {
        try {
            return Collections.max(this.map.keySet()) + 1L;
        }
        catch(NoSuchElementException e) {
            return 1L;
        }
    }

}
