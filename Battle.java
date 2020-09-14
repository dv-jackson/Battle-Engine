import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: a rapid move an actor can preform on another actor that is faster than a regular attack but does less damage
*/

public class Battle
{
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Actor> inFight = new ArrayList<Actor>();
    private static Actor player;
    private static boolean onGoing, newEnemy;
    private static int turns;

    public static void main(String[] args)
    {
        player = new Actor("Player");
        inFight.add(player);
        inFight.add(new Actor("Goblin"));
        onGoing = true;
        mainMenu();
    }

    public static void mainMenu()
    {
        String input;

        do
        {
            System.out.println("a. Check the status of the combatants \nb. Quick Attack \nc. Normal Attack \nd. Precise Attack \ne. Quick Heal \nf. Normal Heal \ng. Long Heal \nh. Quit");
            input = scan.next();

            switch(input)
            {
                case "a":
                    CheckStatus();
                    break;

                case "b":
                    doQuickAttack();
                    break;

                case "c":
                    doNormalAttack();
                    break;

                case "d":
                    doPreciseAttack();
                    break;
                    
                case "e":
                    doQuickHeal();
                    break;

                case "f":
                    doNormalHeal();
                    break;

                case "g":
                    doLongHeal();
                    break;

                case "h":
                    System.out.println("The game has been suspended");
                    break;

                default :
                    System.out.println("Your input was not recognized please try again");
                    break;
            }
        }while(!input.equals("h") && onGoing);
    }

    public static void CheckStatus()
    {
        for(Actor actor: inFight)
        {
            actor.Status();
        }
    }

    public static void doQuickAttack()
    {
        BattleEngine.add(new QuickAttack(helper(), player));
        runTurn();
    }

    public static void doNormalAttack()
    {
        BattleEngine.add(new Attack(helper(), player));
        runTurn();
    }

    public static void doPreciseAttack()
    {
        BattleEngine.add(new PreciseAttack(helper(), player));
        runTurn();
    }

    public static void doQuickHeal()
    {
        BattleEngine.add(new QuickHeal(player, player));
        runTurn();
    }

    public static void doNormalHeal()
    {
        BattleEngine.add(new Heal(player, player));
        runTurn();
    }

    public static void doLongHeal()
    {
        BattleEngine.add(new LongHeal(player, player));
        runTurn();
    }

    public static Actor helper()
    {
        boolean enemyFound = false;
        String name;

        do
        {
            System.out.println("Which enemy would you like to attack");
            name = scan.next();

            for(Actor actor: inFight)
            {
                if (actor.getName().equals(name))
                {
                    enemyFound = true;
                    return actor;
                }
            }
        }while(!enemyFound);

        return null;
    }

    public static void runTurn()
    {
        for(Actor fighters: inFight)
        {
            addEnemyMoves(fighters);
        }
        BattleEngine.print();

        //Executes the battle while the player has neither won or lost
        while (BattleEngine.executeNext() != null && onGoing)
        {
            onGoing = !player.isDead(); //checks if the player is dead
            checkDefeated(); //checks if any enemies were defeated
        }

        /*
            After the or on the 3rd round Imp will be added
            If the player defeats the Goblbin before the 3rd round then Game will stop as Imp did not make it in time
        */
        if(!newEnemy && turns >= 3 && onGoing)
         {
            addImp();
        }
    }

    static void addEnemyMoves(Actor fighters)
    {
        turns++;

            if (fighters.getName() == "Goblin")
            {
                Attack gAttack = new Attack(player, fighters);
                BattleEngine.add(gAttack);
            }

            else if (fighters.getName() == "Imp")
            {
                Attack iAttack = new QuickAttack(player, fighters);
                BattleEngine.add(iAttack);
            } 
    }

    static void addImp()
    {
        Actor imp = new Actor("Imp");
        inFight.add(imp);
        System.out.println("\nImp has joined the fight!");
        newEnemy = true;
    }

    public static void checkDefeated()
    {
        for(ListIterator<Actor> actor = inFight.listIterator(); actor.hasNext();)
        {
            Actor act = actor.next();
            if(act.isDead())
            {
                System.out.println(act.getName() + " has been defeated");
                if(act == player)
                {
                    System.out.println("The match is over. YOU LOSE.");
                    onGoing = false;
                }

                BattleEngine.remove(act);
                actor.remove();

                if (inFight.size() == 1 && inFight.contains(player)) 
                {
                    System.out.println("The match is over. YOU WIN!");
                    onGoing = false;
                }
            }
        }
    }
}