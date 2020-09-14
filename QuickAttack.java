/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: a rapid move an actor can preform on another actor that is faster than a regular attack but does less damage
*/
public class QuickAttack extends Attack
{
    public QuickAttack(Actor target, Actor owner)
    {
        super(target, owner, 10, -1);
    }
}