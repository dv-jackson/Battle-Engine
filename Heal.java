/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: heals an actor 
*/
public class Heal extends BattleEvent
{
    //-30 & 0
    public Heal(Actor target, Actor owner)
    {
        super(target, owner, -30, 0);
    }

    public Heal(Actor target, Actor owner, int damage, int priority)
    {
        super(target, owner, damage, priority);
    }

    @Override
    public void doEvent()
    {
        System.out.println(getOwner().getName() + " heals himself for " + -getDamage() + "hp.");
        getTarget().takeDamage(getDamage());
    }
}