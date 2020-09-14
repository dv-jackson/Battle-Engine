/*
    author: D'Vonye Jackson
    date: 10/07/2019

    disc: action being taken by an actor
*/
public abstract class BattleEvent 
{
    private Actor owner, target;
    private int damage, priority;

    public abstract void doEvent();

    public BattleEvent(Actor target, Actor owner, int damage, int priority)
    {
        this.owner = owner;
        this.target = target;
        this.damage = damage;
        this.priority = priority;
    }

    public Actor getOwner()
    {
        return owner;
    }

    public Actor getTarget()
    {
        return target;
    }

    public int getPriority()
    {
        return priority;
    }

    public int getDamage()
    {
        return damage;
    }

    public String toString()
    {
        return target.getName() + ": Damage: " + damage + " Priority: " + priority;
    }
}