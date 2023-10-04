package Day6Recursion;

public class TowerHanoiP {
    public void towerHanoiP(int n, char from, char to, char aux) {
        if(n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }

        towerHanoiP(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        towerHanoiP(n - 1, aux, to, from);
    }
}
