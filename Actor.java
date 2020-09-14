/*
    author: D'Vonye Jackson
    date: 10/07/2019

    disc: a single fighter in combat
*/
public class Actor
{
    private String name;
    private int health;
    private final int STARTING_HEALTH = 100;

    public Actor(String name)
    {
        this.name = name;
        health = STARTING_HEALTH;
    }

    public String getName()
    {
        return name;
    }

    public boolean isDead()
    {
        return health <= 0;
    }

    public void takeDamage(int damage)
    {
        health -= damage;
        health = (health > 100) ? 100 : (health < 0) ? 0 : health;
    }

    public void Status()
    {
        System.out.println(name + " has " + health + "hp left.");
    }
}