package com.kuznetsov.homework03;

import static com.kuznetsov.homework03.ImageUtility.getImageFromPixels;
import static com.kuznetsov.homework03.ImageUtility.getPixelsFromImage;

public class DrawAPicture {

    public static void main(String[] args) {

        int red = 0xFF0000, green = 0x00FF00, blue = 0x0000FF, yellow = 0xFFFF00, //основные, яркие цвета
                redDim = 0xC80000, greenDim = 0x00C800, blueDim = 0x0000C8, yellowDim = 0xC8C800, //основные, тусклые цвета
                white = 0xFFFFFF, black = 0x000000, gray = 0x757575; //вторичные цвета
        int height = 1080, width = 1920, //разрешение 1920x1080
                heightSquare = 1000, widthSquare = 1000; //квадратное разрешение 1000x1000
        int[][] pixels = new int[height][width];//1920x1080
        int[][] pixelsSquare = new int[heightSquare][widthSquare];//1000x1000


        //Фигуры
        if (false) {
            for (int i = 0; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    if (i > j) {
                        pixelsSquare[i][j] = black;
                    } else {
                        pixelsSquare[i][j] = red;
                    }
                }
            }//Diagonal Left-Right (left corner is black (i > j))
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    if (i < j) {
                        pixelsSquare[i][j] = black;
                    } else {
                        pixelsSquare[i][j] = red;
                    }
                }
            }//Diagonal Left-Right (right corner is black (i < j))
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0; i < heightSquare; i++) {
                for (int j = 0; j < heightSquare; j++) {
                    if (i > widthSquare - j) {
                        pixelsSquare[i][j] = black;
                    } else {
                        pixelsSquare[i][j] = red;
                    }
                }
            }//Diagonal Right-Left (right corner is black (i > width - j))
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0; i < heightSquare; i++) {
                for (int j = 0; j < heightSquare; j++) {
                    if (i < widthSquare - j) {
                        pixelsSquare[i][j] = black;
                    } else {
                        pixelsSquare[i][j] = red;
                    }
                }
            }//Diagonal Right-Left (left corner is black (i < width - j))
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0, r = 100, fourPartsHeight = heightSquare / 4, fourPartsWidth = widthSquare / 4; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    int iFourParts_x1 = (i - fourPartsHeight) * (i - fourPartsHeight), jFourParts_x1 = (j - fourPartsWidth) * (j - fourPartsWidth), iFourParts_x2 = (i - fourPartsHeight * 2) * (i - fourPartsHeight * 2), jFourParts_x2 = (j - fourPartsWidth * 2) * (j - fourPartsWidth * 2), iFourParts_x3 = (i - fourPartsHeight * 3) * (i - fourPartsHeight * 3), jFourParts_x3 = (j - fourPartsWidth * 3) * (j - fourPartsWidth * 3);

                    if (iFourParts_x2 + jFourParts_x2 < r * r) {
                        pixelsSquare[i][j] = white;
                    }
                }
            }//Dice - One
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0, r = 100, fourPartsHeight = heightSquare / 4, fourPartsWidth = widthSquare / 4; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    int iFourParts_x1 = (i - fourPartsHeight) * (i - fourPartsHeight), jFourParts_x1 = (j - fourPartsWidth) * (j - fourPartsWidth), iFourParts_x2 = (i - fourPartsHeight * 2) * (i - fourPartsHeight * 2), jFourParts_x2 = (j - fourPartsWidth * 2) * (j - fourPartsWidth * 2), iFourParts_x3 = (i - fourPartsHeight * 3) * (i - fourPartsHeight * 3), jFourParts_x3 = (j - fourPartsWidth * 3) * (j - fourPartsWidth * 3);

                    if (iFourParts_x1 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }
                }
            }//Dice - Two
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0, r = 100, fourPartsHeight = heightSquare / 4, fourPartsWidth = widthSquare / 4; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    int iFourParts_x1 = (i - fourPartsHeight) * (i - fourPartsHeight), jFourParts_x1 = (j - fourPartsWidth) * (j - fourPartsWidth), iFourParts_x2 = (i - fourPartsHeight * 2) * (i - fourPartsHeight * 2), jFourParts_x2 = (j - fourPartsWidth * 2) * (j - fourPartsWidth * 2), iFourParts_x3 = (i - fourPartsHeight * 3) * (i - fourPartsHeight * 3), jFourParts_x3 = (j - fourPartsWidth * 3) * (j - fourPartsWidth * 3);

                    if (iFourParts_x3 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x2 + jFourParts_x2 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x1 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }
                }
            }//Dice - Three
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0, r = 100, fourPartsHeight = heightSquare / 4, fourPartsWidth = widthSquare / 4; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    int iFourParts_x1 = (i - fourPartsHeight) * (i - fourPartsHeight), jFourParts_x1 = (j - fourPartsWidth) * (j - fourPartsWidth), iFourParts_x2 = (i - fourPartsHeight * 2) * (i - fourPartsHeight * 2), jFourParts_x2 = (j - fourPartsWidth * 2) * (j - fourPartsWidth * 2), iFourParts_x3 = (i - fourPartsHeight * 3) * (i - fourPartsHeight * 3), jFourParts_x3 = (j - fourPartsWidth * 3) * (j - fourPartsWidth * 3);

                    if (iFourParts_x1 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x1 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }
                }
            }//Dice - Four
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0, r = 100, fourPartsHeight = heightSquare / 4, fourPartsWidth = widthSquare / 4; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    int iFourParts_x1 = (i - fourPartsHeight) * (i - fourPartsHeight), jFourParts_x1 = (j - fourPartsWidth) * (j - fourPartsWidth), iFourParts_x2 = (i - fourPartsHeight * 2) * (i - fourPartsHeight * 2), jFourParts_x2 = (j - fourPartsWidth * 2) * (j - fourPartsWidth * 2), iFourParts_x3 = (i - fourPartsHeight * 3) * (i - fourPartsHeight * 3), jFourParts_x3 = (j - fourPartsWidth * 3) * (j - fourPartsWidth * 3);

                    if (iFourParts_x1 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x1 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x2 + jFourParts_x2 < r * r) {
                        pixelsSquare[i][j] = white;
                    }
                }
            }//Dice - Five
            ImageUtility.getImageFromPixels(pixelsSquare);
        }

        if (false) {
            for (int i = 0, r = 100, fourPartsHeight = heightSquare / 4, fourPartsWidth = widthSquare / 4; i < heightSquare; i++) {
                for (int j = 0; j < widthSquare; j++) {
                    int iFourParts_x1 = (i - fourPartsHeight) * (i - fourPartsHeight), jFourParts_x1 = (j - fourPartsWidth) * (j - fourPartsWidth), iFourParts_x2 = (i - fourPartsHeight * 2) * (i - fourPartsHeight * 2), jFourParts_x2 = (j - fourPartsWidth * 2) * (j - fourPartsWidth * 2), iFourParts_x3 = (i - fourPartsHeight * 3) * (i - fourPartsHeight * 3), jFourParts_x3 = (j - fourPartsWidth * 3) * (j - fourPartsWidth * 3);

                    if (iFourParts_x1 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x1 + jFourParts_x2 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x1 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x1 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x2 < r * r) {
                        pixelsSquare[i][j] = white;
                    }

                    if (iFourParts_x3 + jFourParts_x3 < r * r) {
                        pixelsSquare[i][j] = white;
                    }
                }
            }//Dice - Six
            ImageUtility.getImageFromPixels(pixelsSquare);
        }


        //Цветовой спектр
        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int x = i * 0xFF / height;
                    pixels[i][j] = x * 0x10000;
                }
            }//Color spectrum - red
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int x = i * 0xFF / height;
                    pixels[i][j] = x * 0x100;
                }
            }//Color spectrum - green
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int x = i * 0xFF / height;
                    pixels[i][j] = x;
                }
            }//Color spectrum - blue
            ImageUtility.getImageFromPixels(pixels);
        }


        //Флаги
        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i < height / 2) {
                        pixels[i][j] = blue;
                    } else {
                        pixels[i][j] = yellow;
                    }
                }
            }//Ukraine
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j < width / 3) {
                        pixels[i][j] = greenDim;
                    } else if (j < width / 1.5) {
                        pixels[i][j] = white;
                    } else {
                        pixels[i][j] = redDim;
                    }
                }
            }//Italy
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j < width / 3) {
                        pixels[i][j] = blue;
                    } else if (j < width / 1.5) {
                        pixels[i][j] = white;
                    } else {
                        pixels[i][j] = red;
                    }
                }
            }//France
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i > height / 2.6 && i < height / 1.6) {
                        pixels[i][j] = blue;
                    } else {
                        pixels[i][j] = white;
                    }
                    if (j > width / 4 && j < width / 2.5) {
                        pixels[i][j] = blue;
                    }
                }
            }//Finland
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i > height / 2.6 && i < height / 1.6) {
                        pixels[i][j] = yellowDim;
                    } else {
                        pixels[i][j] = blueDim;
                    }
                    if (j > width / 4 && j < width / 2.5) {
                        pixels[i][j] = yellowDim;
                    }
                }
            }//Sweden
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i > height / 2.6 && i < height / 1.6) {
                        pixels[i][j] = white;
                    } else {
                        pixels[i][j] = red;
                    }

                    if (j > width / 4 && j < width / 3.5) {
                        pixels[i][j] = white;
                    } else if (j > width / 3.5 && j < width / 2.8) {
                        pixels[i][j] = blue;
                    } else if (j > width / 2.8 && j < width / 2.5) {
                        pixels[i][j] = white;
                    }

                    if (i > height / 2.3 && i < height / 1.8) {
                        pixels[i][j] = blue;
                    }
                }
            }//Norway
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i < height - j && i > j) {
                        pixels[i][j] = blue;
                    } else if (i > height / 2) {
                        pixels[i][j] = red;
                    } else {
                        pixels[i][j] = white;
                    }
                }
            }//Czech Republic
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0, r = 250; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((i - height / 2) * (i - height / 2) + (j - width / 2) * (j - width / 2) < r * r) {
                        pixels[i][j] = red;
                    } else {
                        pixels[i][j] = white;
                    }
                }
            }//Japan
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0, r = 250; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((i - height / 2) * (i - height / 2) + (j - width / 2) * (j - width / 2) < r * r) {
                        pixels[i][j] = white;
                    } else if (i < height / 1.3 && i > height / 4.5) {
                        pixels[i][j] = blue;
                    } else {
                        pixels[i][j] = red;
                    }
                }
            }//Laos
            ImageUtility.getImageFromPixels(pixels);
        }

        if (false) {
            for (int i = 0, ninePartsHeight = height / 9, ninePartsWidth = width / 9; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i < ninePartsHeight * 2 && i > ninePartsHeight || i < ninePartsHeight * 4 && i > ninePartsHeight * 3 || i < ninePartsHeight * 6 && i > ninePartsHeight * 5 || i < ninePartsHeight * 8 && i > ninePartsHeight * 7) {
                        pixels[i][j] = white;
                    } else {
                        pixels[i][j] = blueDim;
                    }
                    if (j < ninePartsWidth * 4 && i < ninePartsHeight * 5) {
                        pixels[i][j] = blueDim;
                        if (j > ninePartsWidth && j < ninePartsWidth * 2 || i < ninePartsHeight * 3 && i > ninePartsHeight * 2) {
                            pixels[i][j] = white;
                        }
                    }
                }
            }//Greece
            ImageUtility.getImageFromPixels(pixels);
        }
        //Шестое задание ✔

        if (false) {

            int[][] pixelsFromImage = getPixelsFromImage("Doge.jpg");
            int widthPicture = pixelsFromImage.length;
            int heightPicture = pixelsFromImage[0].length;

            for (int i = 0; i < widthPicture; i++) {
                for (int left = 0, right = heightPicture - 1; left < right; left++, right--) {
                    int temp = pixelsFromImage[i][left];
                    pixelsFromImage[i][left] = pixelsFromImage[i][right];
                    pixelsFromImage[i][right] = temp;
                }

            }//Седьмое задание ✔
            getImageFromPixels(pixelsFromImage);
        }

        if (false) {

            int[][] pixelsFromImage = getPixelsFromImage("Doge.jpg");
            int[][] result = new int[pixelsFromImage[0].length][pixelsFromImage.length];

            for (int i = 0; i < pixelsFromImage.length; i++) {
                for (int j = 0; j < pixelsFromImage[0].length; j++) {
                    result[j][pixelsFromImage.length - 1 - i] = pixelsFromImage[i][j];
                }
            }//Восьмое задание ✔
            ImageUtility.getImageFromPixels(result);
        }

        if (false) {

            int[][] pixelsFromImage = getPixelsFromImage("Doge.jpg");
            int[][] result = new int[pixelsFromImage[0].length][pixelsFromImage.length];

            for (int i = 0; i < pixelsFromImage.length; i++) {
                for (int j = 0; j < pixelsFromImage[0].length; j++) {
                    result[pixelsFromImage[0].length - 1 - j][pixelsFromImage.length - 1 - i] = pixelsFromImage[i][j];
                }
            }
            ImageUtility.getImageFromPixels(result);
        }

    }
}
