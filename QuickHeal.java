/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: rapidly heals the actor
*/
public class QuickHeal extends Heal
{
    public QuickHeal(Actor target, Actor owner)
    {
        super(target, owner, -10, -1);
    }
}