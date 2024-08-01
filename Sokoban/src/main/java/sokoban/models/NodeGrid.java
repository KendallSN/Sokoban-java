package sokoban.models;

public class NodeGrid {
    private NodeGrid up;
    private NodeGrid down;
    private NodeGrid left;
    private NodeGrid right;
    private char element;
    NodeGrid(char element) {
        this.up=null;
        this.down=null;
        this.left=null;
        this.right=null;
        this.element=element;
    }

    public char getElement() {
        return element;
    }

    public NodeGrid getUp() {
        return up;
    }

    public void setUp(NodeGrid up) {
        this.up = up;
    }

    public NodeGrid getDown() {
        return down;
    }

    public void setDown(NodeGrid down) {
        this.down = down;
    }

    public NodeGrid getLeft() {
        return left;
    }

    public void setLeft(NodeGrid left) {
        this.left = left;
    }

    public NodeGrid getRight() {
        return right;
    }

    public void setRight(NodeGrid right) {
        this.right = right;
    }
    
}
