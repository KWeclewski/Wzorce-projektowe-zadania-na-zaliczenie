package main.ug.kamilw.pool;

import java.util.HashSet;
import java.util.Set;

public abstract class PulaObjektow<T> {
    protected  T prototyp;
    private final Set<T> wolne;
    private final Set<T> wUzyciu;

    public PulaObjektow(T prototyp){
        this.wolne = new HashSet<>();
        this.wUzyciu = new HashSet<>();
        this.prototyp = prototyp;
    }

    public Set<T> getWolne(){
        return this.wolne;
    }
    public Set<T> getWUzyciu(){
        return this.wUzyciu;
    }

    protected abstract T create();

    protected abstract void reset (T objekt);

    public synchronized T sprawdzSie(){
        System.out.println("Liczba objektow pracujacych w puli: " + wUzyciu.size());
        if (wolne.isEmpty()) {
            wolne.add(create());
        }
        T instancja = wolne.iterator().next();
        wolne.remove(instancja);
        wUzyciu.add(instancja);
        return instancja;
    }
    public synchronized void sprawdz(T instancja) {
        wUzyciu.remove(instancja);
        reset(instancja);
        wolne.add(instancja);
    }
}
