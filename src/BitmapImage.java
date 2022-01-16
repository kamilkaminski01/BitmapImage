import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Pixel {
    int x, y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class RGB {
    int R, G, B;

    public RGB(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }
}

public class BitmapImage {

    int width;
    int height;
    RGB[][] tab = new RGB[width][height];
    Scanner scannner = new Scanner(System.in);


    public BitmapImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.tab = new RGB[width][height];
    }

    public void setPixelColor(Pixel p, RGB rgb) {
        tab[p.x][p.y] = rgb;
    }

    public void saveToFile(String fname) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(fname + ".ppm");
        output.println("P3");
        output.println(width + " " + height);
        output.println("255");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                output.println(tab[j][i].R + " " + tab[j][i].G + " " + tab[j][i].B);
            }
        }
        output.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        BitmapImage b = new BitmapImage(800, 500);
        RGB bialy = new RGB(255, 255, 255);
        RGB czerwony = new RGB(255, 0, 0);
        RGB czarny = new RGB(0, 0, 0);
        RGB zloty = new RGB(255, 215, 0);
        RGB niebieski = new RGB(0, 0, 255);

        String fname;

        //----------------------------------------------------
        for (int j = 0; j < b.height / 2; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, bialy);
            }
        }

        for (int j = b.height / 2; j < b.height; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, czerwony);
            }
        }

        fname = "polish";
        b.saveToFile(fname);
        //----------------------------------------------------
        for (int j = 0; j < b.height / 3; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, czarny);
            }
        }

        for (int j = b.height / 3; j < b.height * 2 / 3; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, czerwony);
            }
        }

        for (int j = b.height * 2 / 3; j < b.height; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, zloty);
            }
        }

        fname = "german";
        b.saveToFile(fname);
        //----------------------------------------------------
        for (int j = 0; j < b.height / 2; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, bialy);
            }
        }

        for (int j = b.height / 2; j < b.height; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, czerwony);
            }
        }

        for (int j = 0; j <= b.height / 2; j++) {
            for (int i = 0; i <= b.width / 2; i++) {
                if (j * 8 / 5 >= i) {
                    Pixel p = new Pixel(i, j);
                    b.setPixelColor(p, niebieski);
                }

            }
        }

        int k = 0;
        for (int j = b.height - 1; j > b.height / 2; j--) {
            k++;
            for (int i = 0; i < b.width; i++) {
                if (k * 8 / 5 >= i) {
                    Pixel p = new Pixel(i, j);
                    b.setPixelColor(p, niebieski);
                }
            }
        }

        fname = "czech";
        b.saveToFile(fname);
        //----------------------------------------------------
        for (int j = 0; j < b.height / 3; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, bialy);
            }
        }

        for (int j = b.height / 3; j < b.height * 2 / 3; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, niebieski);
            }
        }

        for (int j = b.height * 2 / 3; j < b.height; j++) {
            for (int i = 0; i < b.width; i++) {
                Pixel p = new Pixel(i, j);
                b.setPixelColor(p, czerwony);
            }
        }

        fname = "russia";
        b.saveToFile(fname);
    }
}
