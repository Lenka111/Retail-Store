import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class RetailStore
{
    Scanner scan = new Scanner(System.in);

    static int totalCust = 0;

    public static void main(String args[])
    {
        int rows = 7;
        int columns = 8;
        int[ ][ ] table = new int[rows][columns];
        int rowAnalysis[]  = new int[rows];

        Random randomGen = new Random();
        StringBuilder s = new StringBuilder();
        int randomInt1 = 0;
        int randomInt2 = 0;

        // generate column titles
        for (int j = 0; j < columns; j++)
        {
            s.append("\thr " + (j + 1));
        }
        s.append("\n\n");
        // populate data for each cashier lane
        for (int i = 0; i < rows; i++)
        {
            s.append("lane " + (i + 1));
            s.append("\t");
            for (int j = 0; j < columns; j++)
            {
                // express checkout lane
                randomInt1 = 1 + randomGen.nextInt(20);
                // standard checkout lane
                randomInt2 = 1 + randomGen.nextInt(10);

                if(i == 0)
                    table[i][j] = randomInt1;
                else
                    table[i][j] = randomInt2;
                s.append(table[i][j]);
                s.append(" ");
                s.append("\t");
            }
            s.append("\n");
        }
        System.out.println("data simulation: \n\n" + s);
        System.out.println("");

        // perform data analysis
        // row analysis
        String str =
                JOptionPane.showInputDialog(null, "Enter a cashier lane number: ");
        // subtract 1 to compensate for a zero indexed array
        int laneNum = Integer.parseInt(str) - 1;
        double average = 0.0, sum = 0.0;

        for (int j = 0; j < columns ; j++)
        {
            sum += table[laneNum][j];
           // totalCust = sum;
        }
        average = sum / columns;
        System.out.println( "" );

        String outputMsg = "";

        if (average >= 10) {
            outputMsg = "NOTE:---You Should Schedule Another Bagging Clerk---";
            JOptionPane.showMessageDialog(null, outputMsg);
        }
        outputMsg += "\n For cashier lane " + (laneNum + 1);
        outputMsg += "\n The data analysis is: ";
        outputMsg += "\n Customer count -> " + Math.round(sum);
        outputMsg += "\n Average -> " + Math.round(average);

        JOptionPane.showMessageDialog(null, outputMsg,
                    "Data Row Analysis", JOptionPane.PLAIN_MESSAGE);


        // column analysis
        str = JOptionPane.showInputDialog(null, "enter an hour number : ");
        // subtract 1 to compensate for a zero indexed array
        int hourNum = Integer.parseInt(str) - 1;

        // reset the accumulating variable
        sum = 0;
        for (int i = 0; i < rows ; i++)
        {
            sum += table[i][hourNum];
            System.out.println( table[i][hourNum] );
        }
        average = sum / rows;
        System.out.println( "" );


        outputMsg = "";
        outputMsg += "\n For hour number " + (hourNum + 1);
        outputMsg += "\n The data analysis is: ";
        outputMsg += "\n Customer count -> " + Math.round(sum);
        outputMsg += "\n Average -> " + Math.round(average);
        JOptionPane.showMessageDialog(null, outputMsg,
                    "Data Column Analysis", JOptionPane.PLAIN_MESSAGE);
        outputMsg = "";

        // calculate average customers per lane
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < columns; j++) {
                rowAnalysis[i] += (double) table[i][j];
            }
        }
        System.out.println("\n========================= Lanes Analysis ========================\n");
        System.out.println("Lane #\t\tCustomer Count");
        for(int i=0; i<rows; i++) {
            System.out.println("Lane[" + (i + 1) + "]: \t\t" + rowAnalysis[i]);
            outputMsg += "";
            outputMsg += "\n:=========================:<Lanes Analysis>:========================:\n";
            outputMsg += "\nLane #\t\t\tCustomer Count";
            outputMsg +="\nLane[" + (i + 1) + "]:\t " + rowAnalysis[i] + "\n";
            JOptionPane.showMessageDialog(null, outputMsg);
        }



        // calculate total customers at all lanes
        for(int i=0; i<rows; i++){
            for(int j = 0; j < columns; j++){
                totalCust += table [i][j];
            }
        }
        System.out.println();
        System.out.println(totalCust + " customers served at all lanes");

        outputMsg = "Total customers served today at all lanes : " + totalCust;
        JOptionPane.showMessageDialog(null, outputMsg);


    }
}




