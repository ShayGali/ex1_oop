import java.util.ArrayList;
import java.util.List;

public abstract class ConcretePiece implements Piece {
    protected final Player owner;
    protected final List<Position> moves;
    protected final int pieceNum;
    protected int distance;

    public ConcretePiece(Player owner, int pieceNum, Position initialPosition) {
        this.owner = owner;
        this.pieceNum = pieceNum;
        this.moves = new ArrayList<>();
        this.moves.add(initialPosition);
        distance = 0;
    }

    public abstract int getNumberOfEats();

    public abstract void setNumberOfEats(int i);

    /**
     * @return the representation of the piece.
     */
    public abstract String getName();

    /**
     * add a move to the moves list.
     * update the distance that the piece has moved.
     *
     * @param position the position to add to the moves list.
     */
    public void addMove(Position position) {
        if (moves.size() > 0) {
            distance += moves.get(moves.size() - 1).distance(position);
        }
        this.moves.add(position);
    }

    public void removeMove(Position position) {
        this.distance -= moves.get(moves.size() - 1).distance(position); // Updating the distance by removing last place in 'moves'  and using distance method
        this.moves.remove(position);
    }

    /**
     * @return the distance that the piece has moved.
     */
    public List<Position> getMoves() {
        return moves;
    }

    /**
     * @return the distance that the piece has moved.
     */
    public int getDistance() {
        return distance;
    }

    @Override
    public Player getOwner() {
        return this.owner;
    }


    public int getPieceNum() {
        return pieceNum;
    }


}
