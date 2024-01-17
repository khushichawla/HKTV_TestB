import java.util.Arrays;
import java.util.Scanner;

public class Q3_MaximiseCarton {
    public static int calculateOptimalPairings(int productLength, int productWidth, int productHeight, int cartonLength, int cartonWidth, int cartonHeight) {
        int[] productDimensions = { productLength, productWidth, productHeight };
        int[] cartonDimensions = { cartonLength, cartonWidth, cartonHeight };

        Arrays.sort(cartonDimensions);

        int minDifference = Integer.MAX_VALUE;
        int[] selectedProductDimensions = new int[3];
        int[] selectedCartonDimensions = new int[3];

        // finding the first optimal dimension pair between product and carton that minimises the waste area
        for (int i = 0; i < productDimensions.length; i++) {
            for (int j = 0; j < cartonDimensions.length; j++) {
                if (productDimensions[i] > cartonDimensions[j]) continue;
                int difference = (cartonDimensions[j] - productDimensions[i]);
                if (difference < minDifference) {
                    minDifference = difference;
                    selectedProductDimensions[0] = i;
                    selectedCartonDimensions[0] = j;
                }
            }
        }

        minDifference = Integer.MAX_VALUE;

        // finding the second optimal dimension pair between product and carton that minimises the waste area
        for (int i = 0; i < productDimensions.length; i++) {
            if (i == selectedProductDimensions[0]) {
                continue;
            }
            for (int j = 0; j < cartonDimensions.length; j++) {
                if (j == selectedCartonDimensions[0]) {
                    continue;
                }
                if (productDimensions[i] > cartonDimensions[j]) continue;
                int difference = (cartonDimensions[j] - productDimensions[i]);
                if (difference < minDifference) {
                    minDifference = difference;
                    selectedProductDimensions[1] = i;
                    selectedCartonDimensions[1] = j;
                }
            }
        }

        minDifference = Integer.MAX_VALUE;
        
        // Finding out the final remaining pair for further calculation
        for (int i = 0; i < productDimensions.length; i++) {
            if (i == selectedProductDimensions[0] || i == selectedProductDimensions[1]) {
                continue;
            } else {
                selectedProductDimensions[2] = i;
                break;
            }
        }

        for (int i = 0; i < cartonDimensions.length; i++) {
            if (i == selectedCartonDimensions[0] || i == selectedCartonDimensions[1]) {
                continue;
            } else {
                selectedCartonDimensions[2] = i;
                break;
            }
        }

        int productQuantity = (cartonDimensions[selectedCartonDimensions[0]] / productDimensions[selectedProductDimensions[0]]) *
                              (cartonDimensions[selectedCartonDimensions[1]] / productDimensions[selectedProductDimensions[1]]) *
                              (cartonDimensions[selectedCartonDimensions[2]] / productDimensions[selectedProductDimensions[2]]);
        
        return productQuantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Take in product dimensions
        System.out.print("Enter the product length: ");
        int productLength = scanner.nextInt();

        System.out.print("Enter the product width: ");
        int productWidth = scanner.nextInt();

        System.out.print("Enter the product height: ");
        int productHeight = scanner.nextInt();

        //Take in carton dimensions
        System.out.print("Enter the carton length: ");
        int cartonLength = scanner.nextInt();

        System.out.print("Enter the carton width: ");
        int cartonWidth = scanner.nextInt();

        System.out.print("Enter the carton height: ");
        int cartonHeight = scanner.nextInt();

        // Calculate the optimal dimension pairings
        int maxQuantity = calculateOptimalPairings(productLength, productWidth, productHeight, cartonLength, cartonWidth, cartonHeight);
        System.out.println("Maximum quantity that can be stored in the carton: " + maxQuantity);
        
        scanner.close();
    }
}
