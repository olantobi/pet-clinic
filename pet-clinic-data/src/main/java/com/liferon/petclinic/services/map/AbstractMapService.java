package com.liferon.petclinic.services.map;

import com.liferon.petclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMapService<T extends BaseEntity<Long>, ID extends Long>
{
    protected Map<Long, T> map = new ConcurrentHashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        if (object.getId() != null) {
            map.remove(object.getId());
        } else
            map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        if (map.size() == 0)
            return 1L;
        return Collections.max(map.keySet()) + 1;
    }
}
