package classes;

public class CellChecker implements CellCheckInterface{
    private int x;
    private int y;

//    inject dimension of matrix
    public CellChecker(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    checks if the given sell is in the matrix field and returns boolean
    @Override
    public boolean checkCell(int xz, int yz) {
        if(xz>=0 && xz<x && yz>=0 && yz<y){
            return true;
        }
        return false;
    }
}
