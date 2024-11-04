import java.io.*;
import java.util.*;
public class Fill {
    public static void main(String[] args) {
        File file = new File("D:\\fill.txt");
        Scanner sc = null;
        int count = 0;
        double sum = 0;
        try {
            double score = 0;
            sc = new Scanner(file);
            sc.useDelimiter("[^0123456789.]+");
            while (sc.hasNextDouble()) {
                score = sc.nextDouble();
                count++;
                sum += score;
                System.out.println(score);
            }
            if (count > 0) {
                double aver = sum / count;
                String str = String.format("%.2f", aver);
                System.out.println("平均价格：" + str);
                
                try (FileWriter fw = new FileWriter(file,true); 
                    BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write('\n'+"平均价格，" + str + "元/台"); 
                }
            } else {
                System.out.println("无法计算");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
