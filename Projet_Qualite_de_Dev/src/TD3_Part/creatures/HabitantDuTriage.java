package TD3_Part.creatures;

public interface HabitantDuTriage {

    default void attendre() {
        if (this instanceof Creature creature) {
            return;
        }
    }

}
