package  org.example.libs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* Essa clas
*/
public class ConjuntosDisjuntos<T> {
private List<Map<Integer, Set<T>>> disjointSet;
 
    public ConjuntosDisjuntos()
    {
        disjointSet = new ArrayList<Map<Integer, Set<T>>>();
    }
 
    public void create_set(T element)
    {
        Map<Integer, Set<T>> map = new HashMap<Integer, Set<T>>();
        Set<T> set = new HashSet<T>();
        set.add(element);
        map.put(element, set);
        disjointSet.add(map);
    }
 
    public void union(T first, T second)
    {
        T first_rep = find_set(first);
        T second_rep = find_set(second);
 
        Set<T> first_set = null;
        Set<T> second_set = null;
 
        for (int index = 0; index < disjointSet.size(); index++)
        {
            Map<Integer, Set<T>> map = disjointSet.get(index);
            if (map.containsKey(first_rep))
            {
                first_set = map.get(first_rep);
            } else if (map.containsKey(second_rep))
            { 
                second_set = map.get(second_rep);
            }
        }
 
        if (first_set != null && second_set != null)
        first_set.addAll(second_set);
 
        for (int index = 0; index < disjointSet.size(); index++)
        {
            Map<Integer, Set<T>> map = disjointSet.get(index);
            if (map.containsKey(first_rep))
            {
                map.put(first_rep, first_set);
            } else if (map.containsKey(second_rep))
            {
                map.remove(second_rep);
                disjointSet.remove(index);
            }
        }
 
        return;
    }
 
    public T find_set(T element)
    {
        for (int index = 0; index < disjointSet.size(); index++)
        {
            Map<Integer, Set<T>> map = disjointSet.get(index);
            Set<T> keySet = map.keySet();
            for (Integer key : keySet)
            {
                Set<T> set = map.get(key);
                if (set.contains(element))
                {
                    return key;
                }
            }
        }
        return -1;
    }
 
    public int getNumberofConjuntosDisjuntos()
    {
        return disjointSet.size();
    }

}