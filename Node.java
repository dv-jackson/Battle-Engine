/*
    author: D'Vonye Jackson
    date: 10/08/2019

    disc: represents a node in a linked list
*/
public class Node
{
    private Node nextNode, previousNode;
    private BattleEvent eventB;

    public Node (Node previousNode, BattleEvent eventB)
    {
        this.previousNode = previousNode;
        this.eventB = eventB;
    }

    public Node getNext()
    {
        return nextNode;
    }

    public void setNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }

    public Node getPrevious()
    {
        return previousNode;
    }

    public void setPrevious(Node previousNode)
    {
        this.previousNode = previousNode;
    }

    public BattleEvent getBattleEvent()
    {
        return eventB;
    }

}