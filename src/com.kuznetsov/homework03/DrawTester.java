package com.kuznetsov.homework03;

public class DrawTester {

    public static void main(String[] args) {

        if (false) {
            int width = 1024, height = 720;
            int[][] mtx = new int[height][width];

            int color1 = 0xFF0000;//Left j == 0
            int color2 = 0x00FF00;//Right j == height - 1

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int resRed = average(red(color1), red(color2), width - j, j);
                    int resGreen = average(green(color1), green(color2), width - j, j);
                    int resBlue = average(blue(color1), blue(color2), width - j, j);
                    mtx[i][j] = color(resRed, resGreen, resBlue);

                }
            }

            ImageUtility.getImageFromPixels(mtx);
        }

        if (false) {
            int width = 1024, height = 720;
            int[][] mtx = new int[height][width];

            int color1 = 0xFF0000;//Left top i == 0, j == 0
            int color2 = 0x00FF00;//Right top i == 0, j == height - 1
            int color3 = 0x0000FF;//Right bottom i == width - 1, j == height - 1
            int color4 = 0xFF00FF;//Left bottom i == width - 1, j == 0

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int resRedJTop = average(red(color1), red(color2), width - j, j);
                    int resGreenJTop = average(green(color1), green(color2), width - j, j);
                    int resBlueJTop = average(blue(color1), blue(color2), width - j, j);

                    int resRedJBottom = average(red(color4), red(color3), width - j, j);
                    int resGreenJBottom = average(green(color4), green(color3), width - j, j);
                    int resBlueJBottom = average(blue(color4), blue(color3), width - j, j);

                    int resRed = average(resRedJTop, resRedJBottom, height - i, i);
                    int resGreen = average(resGreenJTop, resGreenJBottom, height - i, i);
                    int resBlue = average(resBlueJTop, resBlueJBottom, height - i, i);


                    mtx[i][j] = color(resRed, resGreen, resBlue);

                }
            }

            ImageUtility.getImageFromPixels(mtx);
        }
    }

    private static int average(int color1, int color2, double weight1, double weight2) {
        return (int) ((color1 * weight1 + color2 * weight2) / (weight1 + weight2));
    }

    private static int color(int red, int green, int blue) {
        return red * 0x10000 + green * 0x100 + blue;
    }

    private static int red(int color) {
        return color / 0x10000;
    }

    private static int green(int color) {
        return color % 0x10000 / 0x100;
    }

    private static int blue(int color) {
        return color % 0x100;
    }
}