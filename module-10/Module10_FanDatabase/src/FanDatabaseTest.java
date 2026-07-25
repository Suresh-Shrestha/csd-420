public class FanDatabaseTest {
    public static void main(String[] args) {

        System.out.println("Manual Test Cases");

        System.out.println("1. Enter ID = 1");
        System.out.println(" Click Display");
        System.out.println(" Expected: Fan information appears.");

        System.out.println();

        System.out.println("2. Change Faorite Team");
        System.out.println(" Click Update");
        System.out.println(" Expected: 'Record update.'");

        System.out.println();

        System.out.println("3. Click Display again");
        System.out.println(" Expected: Updated team is shown.");

        System.out.println();

        System.out.println("4. Enter ID = 999");
        System.out.println(" Expected: Record not found.");
    }
}