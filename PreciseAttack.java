/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: a critical move an actor can preform on another actor that is slower but harder hitting
*/
public class PreciseAttack extends Attack
{
    public PreciseAttack(Actor target, Actor owner)
    {
        super(target, owner, 70, 1);
    }
}