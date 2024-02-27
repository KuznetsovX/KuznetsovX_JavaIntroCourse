package com.kuznetsov.homework03;

public class DrawAPictureV2 {

    final static int red = 0xFF0000, green = 0x00FF00, blue = 0x0000FF, yellow = 0xFFFF00, redDim = 0xC80000, greenDim = 0x00C800, blueDim = 0x0000C8, yellowDim = 0xC8C800, white = 0xFFFFFF, black = 0x000000, gray = 0x757575;
    final static int height = 1080, width = 1920;
    final static int[][] pixels = new int[height][width];

    public static void main(String[] args) {
//        flagUkraine();
//        flagGermany();
//        flagItaly();
//        flagFinland();
//        flagJapan();
//        flagCzech();
//        diceOne();
//        diceTwo();
//        diceThree();
//        diceFour();
//        diceFive();
//        diceSix();
    }

    private static void flagUkraine() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (x < height / 2) {
                    pixels[x][y] = blueDim;
                } else {
                    pixels[x][y] = yellowDim;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void flagGermany() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (x < height / 3) {
                    pixels[x][y] = black;
                } else if (x > height / 3 && x < height / 3 * 2) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = yellow;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void flagItaly() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (y < width / 3) {
                    pixels[x][y] = greenDim;
                } else if (y > width / 3 && y < width / 3 * 2) {
                    pixels[x][y] = white;
                } else {
                    pixels[x][y] = redDim;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void flagFinland() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (x > height / 8 * 3 && x < height / 8 * 5 || y > width / 8 * 2 && y < width / 8 * 3) {
                    pixels[x][y] = blueDim;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    public static void flagJapan() {
        for (int x = 0, r = 300; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (((x - height / 2) * (x - height / 2)) + ((y - width / 2) * (y - width / 2)) < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void flagCzech() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (x < height - y && x > y) {
                    pixels[x][y] = blueDim;
                } else if (x > height / 2) {
                    pixels[x][y] = redDim;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void diceOne() {
        for (int x = 0, r = 100; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int
//                        x1 = (x - height / 4) * (x - height / 4),
                        x2 = (x - height / 4 * 2) * (x - height / 4 * 2),
//                        x3 = (x - height / 4 * 3) * (x - height / 4 * 3),
//                        y1 = (y - width / 4) * (y - width / 4),
                        y2 = (y - width / 4 * 2) * (y - width / 4 * 2);
//                        y3 = (y - width / 4 * 3) * (y - width / 4 * 3);

                if (x2 + y2 < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void diceTwo() {
        for (int x = 0, r = 100; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int x1 = (x - height / 4) * (x - height / 4),
//                        x2 = (x - height / 4 * 2) * (x - height / 4 * 2),
                        x3 = (x - height / 4 * 3) * (x - height / 4 * 3), y1 = (y - width / 4) * (y - width / 4),
//                        y2 = (y - width / 4 * 2) * (y - width / 4 * 2),
                        y3 = (y - width / 4 * 3) * (y - width / 4 * 3);

                if (x1 + y1 < r * r || x3 + y3 < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void diceThree() {
        for (int x = 0, r = 100; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int x1 = (x - height / 4) * (x - height / 4), x2 = (x - height / 4 * 2) * (x - height / 4 * 2), x3 = (x - height / 4 * 3) * (x - height / 4 * 3), y1 = (y - width / 4) * (y - width / 4), y2 = (y - width / 4 * 2) * (y - width / 4 * 2), y3 = (y - width / 4 * 3) * (y - width / 4 * 3);

                if (x1 + y1 < r * r || x2 + y2 < r * r || x3 + y3 < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void diceFour() {
        for (int x = 0, r = 100; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int x1 = (x - height / 4) * (x - height / 4),
//                        x2 = (x - height / 4 * 2) * (x - height / 4 * 2),
                        x3 = (x - height / 4 * 3) * (x - height / 4 * 3), y1 = (y - width / 4) * (y - width / 4),
//                        y2 = (y - width / 4 * 2) * (y - width / 4 * 2),
                        y3 = (y - width / 4 * 3) * (y - width / 4 * 3);

                if (x1 + y1 < r * r || x1 + y3 < r * r || x3 + y1 < r * r || x3 + y3 < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void diceFive() {
        for (int x = 0, r = 100; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int x1 = (x - height / 4) * (x - height / 4), x2 = (x - height / 4 * 2) * (x - height / 4 * 2), x3 = (x - height / 4 * 3) * (x - height / 4 * 3), y1 = (y - width / 4) * (y - width / 4), y2 = (y - width / 4 * 2) * (y - width / 4 * 2), y3 = (y - width / 4 * 3) * (y - width / 4 * 3);

                if (x1 + y1 < r * r || x1 + y3 < r * r || x2 + y2 < r * r || x3 + y1 < r * r || x3 + y3 < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

    private static void diceSix() {
        for (int x = 0, r = 100; x < height; x++) {
            for (int y = 0; y < width; y++) {
                int x1 = (x - height / 4) * (x - height / 4),
//                        x2 = (x - height / 4 * 2) * (x - height / 4 * 2),
                        x3 = (x - height / 4 * 3) * (x - height / 4 * 3), y1 = (y - width / 4) * (y - width / 4), y2 = (y - width / 4 * 2) * (y - width / 4 * 2), y3 = (y - width / 4 * 3) * (y - width / 4 * 3);

                if (x1 + y1 < r * r || x1 + y2 < r * r || x1 + y3 < r * r || x3 + y1 < r * r || x3 + y2 < r * r || x3 + y3 < r * r) {
                    pixels[x][y] = red;
                } else {
                    pixels[x][y] = white;
                }
            }
        }
        ImageUtility.getImageFromPixels(pixels);
    }

}
