package TD3_Part.creatures;

public interface ClientVIPPrioritaire {

    default void attendre() {
        if (this instanceof Creature creature) {
            creature.setMoral(creature.getMoral() - 10);
        }
    }

}
