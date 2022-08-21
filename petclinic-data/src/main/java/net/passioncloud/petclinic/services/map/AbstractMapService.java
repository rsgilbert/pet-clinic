package net.passioncloud.petclinic.services.map;

import net.passioncloud.petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T,ID> implements CrudService<T,ID> {
    protected Map<ID, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    public T save(ID id, T object) {
        map.put(id, object);
        return null;
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


}
