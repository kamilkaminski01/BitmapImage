import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Pixel {
    double x, y;

    public Pixel(double x, double y) {
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
        tab[(int) p.x][(int) p.y] = rgb;
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

    // Metody draw
    //-----------------------------------------------------------
    public void drawLine(Pixel k, Pixel j, RGB rgb) {

        double x = 0, y = 0;
        double a = (j.y - k.y) / (j.x - k.x);
        if (k.x < j.x) {
            x = k.x;
            while (x != j.x + 1) {
                y = (a * (x - k.x) + k.y);
                Pixel p = new Pixel(x, y);
                setPixelColor(p, rgb);
                x++;
            }
        } else {
            x = k.x;
            while (x != j.x) {

                y = (a * (x - k.x) + k.y);
                Pixel p = new Pixel(x, y);
                setPixelColor(p, rgb);
                x--;
            }
        }
    }

    public void drawRectangle(Pixel j, Pixel k, RGB rgb) {
        Pixel p = new Pixel(k.x, j.y);
        Pixel l = new Pixel(j.x, k.y);
        drawLine(j, p, rgb);
        drawLine(p, k, rgb);
        drawLine(k, l, rgb);
        drawLine(l, j, rgb);
    }

    public void drawTriangle(Pixel j, Pixel k, Pixel l, RGB rgb) {
        drawLine(j, k, rgb);
        drawLine(j, l, rgb);
        drawLine(k, l, rgb);
    }

    public void drawCircle(Pixel s, int r, RGB rgb) {
        double i, x1, y1;

        for (i = 0; i < 360; i += 0.1) {
            x1 = (r * Math.cos(i * Math.PI / 180));
            y1 = (r * Math.sin(i * Math.PI / 180));
            Pixel p = new Pixel(s.x + x1, s.y + y1);
            setPixelColor(p, rgb);
        }
    }

    public void fillRectangle(Pixel j, Pixel k, RGB rgb) {
        Pixel p = new Pixel(k.x, j.y);
        Pixel l = new Pixel(j.x, k.y);
        for (double i = j.x; i < k.x; i++) {
            for (double c = j.y; c < k.y; c++) {
                Pixel pixel = new Pixel(i, c);
                setPixelColor(pixel, rgb);
            }
        }

    }

    public void fillTriangle(Pixel k ,Pixel p, RGB rgb ) {
        double x1 = k.x;
        double y = p.y;
        double x2 = p.x;

        while (x1 < x2) {
            drawLine(new Pixel(x1, y), new Pixel(x2, y), rgb);
            x1++;
            x2--;
            y--;
        }
    }

    public void fillDownTriangle(Pixel k ,Pixel p, RGB rgb ){
        double x1 = k.x;
        double y = p.y;
        double x2 = p.x;

        while(x1<x2){
            drawLine(new Pixel(x1, y), new Pixel(x2, y), rgb);
            x1++;
            x2--;
            y++;
        }
    }

    public void fillCircle(Pixel s, int r, int r2, RGB rgb) {
        for (int i = r2; i <= r; i++) {
            drawCircle(s, i, rgb);
        }
    }
    //-----------------------------------------------------------

    public static void main(String[] args) throws IOException {

        BitmapImage b = new BitmapImage(600, 800);

        RGB bialy = new RGB(255, 255, 255);
        RGB czerwony = new RGB(255, 0, 0);
        RGB czarny = new RGB(0, 0, 0);
        RGB zloty = new RGB(255, 215, 0);
        RGB niebieski = new RGB(0, 0, 255);
        RGB zielony = new RGB(0, 128, 0);
        RGB brazowy = new RGB(139, 69, 19);
        RGB rozowy = new RGB(255, 0, 255);
        RGB blekitny = new RGB(0, 255, 255);

        String fname;

        // Polska
        /*
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
         */

        // Niemcy
        /*
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
        */

        // Czechy
        /*
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
        */

        // Rosja
        /*
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
        */

        // Zasadnicza
        b.drawRectangle(new Pixel(0, 0), new Pixel(599, 799), bialy);
        b.fillRectangle(new Pixel(0, 0), new Pixel(600, 800), bialy);
//        b.drawTriangle(new Pixel(150, 225), new Pixel(300, 225), new Pixel(225, 150), zielony);
        b.fillTriangle(new Pixel(150, 225), new Pixel(300, 225), zielony);
//        b.drawTriangle(new Pixel(150, 300), new Pixel(300, 300), new Pixel(225, 225), zielony);
        b.fillTriangle(new Pixel(150, 300), new Pixel(300, 300), zielony);
//        b.drawTriangle(new Pixel(150, 375), new Pixel(300, 375), new Pixel(225, 300), zielony);
        b.fillTriangle(new Pixel(150, 375), new Pixel(300, 375), zielony);

        // Pien
        b.fillRectangle(new Pixel(210, 375), new Pixel(240, 420), brazowy);

        // Gwiazda
//        b.drawTriangle(new Pixel(200, 120), new Pixel(250, 120), new Pixel(225, 150), zloty);
        b.fillDownTriangle(new Pixel(200, 120), new Pixel(250, 125), zloty);
//        b.drawTriangle(new Pixel(200, 140), new Pixel(250, 140), new Pixel(225, 110), zloty);
        b.fillTriangle(new Pixel(200, 140), new Pixel(250, 140), zloty);

        // Bombki
        b.fillCircle(new Pixel(270, 235), 10,1, niebieski);
        b.fillCircle(new Pixel(270, 310), 10,1, czerwony);
        b.fillCircle(new Pixel(180, 385), 10,1, rozowy);
        b.fillCircle(new Pixel(180, 310), 10,1, blekitny);

        fname = "choinka";
        b.saveToFile(fname);

    }
}
