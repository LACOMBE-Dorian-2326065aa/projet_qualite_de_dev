package TD3_Part.creatures;

public interface MortVivant {

    default void trepasser() {
        if (this instanceof Creature creature) {
            creature.setMoral(creature.getMoral() + 15);
            System.out.println(creature.getNom() + " trépasse mais se regénère !");
        }
    }

}
