import java.util.Arrays;

public class Laundry {

    public static void main(String[] args) {
        System.out.println(washing(new int[]{3, 7, 8, 4},1)); //22
        System.out.println(washing(new int[]{3, 15, 2, 6}, 2)); //15
    }

    public static int washing(int[] customerWashTime, int numberOfWashingMachines) {
        int[] machines = new int[numberOfWashingMachines];
        for (int customer :
                customerWashTime) {
            machines[indexOfFreeWashingMachine(machines)]+=customer;
        }
        return maximumMachineTime(machines);
    }

    private static int indexOfFreeWashingMachine(int[] machines) {
        int index = 0;
        for (int i = 1; i < machines.length; i++)
        {
            if (machines[i] < machines[index])
            {
                index = i;
            }
        }
        return index;
    }

    private static int maximumMachineTime(int[] machines) {
        return Arrays.stream(machines).max().getAsInt();
    }

}
