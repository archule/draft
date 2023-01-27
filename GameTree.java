import java.util.*;

class GameTree {
    public GameState state;
    public GameTree parent;
    public List<GameTree> children;
    private int visits;
    private double reward;
    private Action action;

    public GameTree(GameState state, GameTree parent, Action action) {
        this.state = state;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.visits = 0;
        this.reward = 0;
        this.action = action;
    }

    public GameTree addChild(GameState childState, Action action) {
        GameTree child = new GameTree(childState, this, action);
        children.add(child);
        return child;
    }

    public void update(double reward) {
        this.visits++;
        this.reward += reward;
    }

    public GameTree selectChild() {
        // select child with highest reward-to-visit ratio
        children.sort((c1, c2) -> Double.compare(c2.reward / c2.visits, c1.reward / c1.visits));
        return children.get(0);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }
}
