import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BitmapImage {

    int width;
    int height;


    public BitmapImage(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setPixelColor( ){

    }

    public void saveToFile(String fname) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(fname + ".ppm");
        output.println("P3");
        output.println(width + " " + height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                output.println();
            }
        }
        output.close();
    }

    public static void main(String[] args) {


    }

}
