/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: will take and sort the actions needed for battle
*/
public class BattleEngine
{
    private static Node firstNode;

    public static void addFirst(BattleEvent eventB)
    {
        firstNode = new Node(null, eventB);
    }

    public static int size()
    {
        int count = 0;
        Node nodeCounter = firstNode;

        while (nodeCounter != null)
        {
            count++;
            nodeCounter = nodeCounter.getNext();
        }

        return count;
    }

    public static boolean isEmpty()
    {
        return (firstNode == null);
    }

    //priority check
    public static void add(BattleEvent eventB)
    {
        if(isEmpty())
        {
            addFirst(eventB);
        }

        else
        {
            if (firstNode.getBattleEvent().getPriority() > eventB.getPriority()) //if eventB is supposed to come before the first event
            {
                Node newNode = new Node(null, eventB); //create new node with no new previous
                newNode.setNode(firstNode); // put the first node after it
                firstNode.setPrevious(newNode); // let the first node know that the newNode is before it
                firstNode = newNode; // point to our newNode as the first node
            }

            else
            {
                Node nodeHolder = firstNode;
                while (nodeHolder.getNext() != null && eventB.getPriority() >= nodeHolder.getBattleEvent().getPriority())
                {
                    nodeHolder = nodeHolder.getNext();
                }
                Node newNode = new Node(nodeHolder, eventB);
                newNode.setNode(nodeHolder.getNext());
                nodeHolder.setNode(newNode);
            }
        }
    }

    public static void print()
    {
        Node nodeCounter = firstNode;
        while (nodeCounter != null)
        {
            System.out.println(nodeCounter.getBattleEvent().toString());
            nodeCounter = nodeCounter.getNext();
        }
    }

    public static Node executeNext()
    {
        if(!isEmpty())
        {
            Node nodeHolder = firstNode;
            firstNode.getBattleEvent().doEvent();
            firstNode = firstNode.getNext();

            if (firstNode != null)
                firstNode.setPrevious(null);
            
            return nodeHolder;
        }

        else
            return null;
    }

    public static void remove(Actor actor)
    {
        Node nodeCounter = firstNode;

        while (nodeCounter != null)
        {
            if(nodeCounter.getBattleEvent().getOwner() == actor || nodeCounter.getBattleEvent().getTarget() == actor)
            {
                
                /*
                    checks if the current node has a previous one
                    If it does than that means it is somewhere in the middle or end of our list of events
                */
                if (nodeCounter.getPrevious() != null)
                {
                    nodeCounter.getPrevious().setNode(nodeCounter.getNext()); // gets the previous node and sets its nextNode to the current node's next node (making it so the previous node does not point to this one)
                    
                    if (nodeCounter.getNext() != null)
                    {
                        nodeCounter.getNext().setPrevious(nodeCounter.getPrevious()); // makes it so the current nextNode points back to the current node's previous (essentially pointing to the node behind the current node)
                    }
                }

                /* 
                    since it doesn't have a previous node it means that this can only be the first node
                    but since there can possibly be more nodes after the first we want to check for that
                */
                else if (nodeCounter.getNext() != null)
                {
                    
                    firstNode = nodeCounter.getNext(); // sets firstNode to the nextNode
                    firstNode.setPrevious(null); //sets the new firstNode's previous node to null
                }

                //but if there isn't another node after the first then it will just get set to null
                else
                    firstNode = null; 
            }
            nodeCounter = nodeCounter.getNext();
        }
    }
}