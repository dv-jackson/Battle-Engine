/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: a move an actor can preform on another actor
*/
public class Attack extends BattleEvent
{
    //30 & 0
    public Attack(Actor target, Actor owner)
    {
        super(target, owner, 30, 0);
    }
    
    public Attack(Actor target, Actor owner, int damage, int priority)
    {
        super(target, owner, damage, priority);
    }

    @Override
    public void doEvent()
    {
        System.out.println(getOwner().getName() + " attacks " + getTarget().getName() + " for " + getDamage() + " damage.");
        getTarget().takeDamage(getDamage());
    }
}