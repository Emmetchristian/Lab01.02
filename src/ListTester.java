import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * ADV Comp Sci

 * ListTester uses a main method that reads
 * lines from a given file and adds them to the list in order
 * prints them in order
 *
 *
 * @version 02/1/2024
 * @author Emmet Christan
 *
 */


public class ListTester {
//   private final JFrame chooserFrame;
//   public File file;

//   public ListTester(JFrame chooserFrame) {
//       this.chooserFrame = chooserFrame;
//   }

//   public String chsen(String input) {
//       return input;
//       /*for(Map.Entry<String, Integer> entry:
//           dictionary.entrySet()) {
//           System.out.println(entry.getKey() + " - " + entry.getValue());
//       }*/
//   }

//   public void choose() {
//       JFileChooser j = new JFileChooser(new File("./Files"));
//       int chosen = j.showOpenDialog(chooserFrame);
//       if (chosen == JFileChooser.APPROVE_OPTION) {
//           file = new File("./Files/" + j.getSelectedFile().getName());
//           try {
//               Scanner s = new Scanner(file);

//               while (s.hasNext()) {
//                   chsen(s.nextLine());
//               }
//               s.close();
//               chooserFrame.dispose();
//               //System.out.println("stream closed");
//           } catch (Exception e) {
//               //noinspection CallToPrintStackTrace
//               e.printStackTrace();
//           }
//       }
//   }

    /**
     *  reads lines from a given file and adds them to the list in order
     *  prints them in order
     * @param args
     */
    public static void main(String[] args) {

        DoublyCircularLinkedList<String> linkedList = new DoublyCircularLinkedList<>();

        try {
            File file = new File("/Users/24christian/Documents/IDEA/DoublyCircularLinkedList/Files/new_scrabble.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                linkedList.addInOrder(line);
            }

            scanner.close();


            System.out.println(linkedList);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}




