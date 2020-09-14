/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: a critical move an actor can preform on another actor that is slower but harder hitting
*/
public class LongHeal extends Heal
{
    public LongHeal(Actor target, Actor owner)
    {
        super(target, owner, -70, 1);
    }
}