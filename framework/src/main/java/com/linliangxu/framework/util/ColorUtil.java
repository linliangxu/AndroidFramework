package com.linliangxu.framework.util;

import android.graphics.Color;

/**
 * @author : Linxu
 * @create : 2021/4/16
 * @update : 2022/3/16
 * ==============================
 * @desc   : 颜色相关工具类
 */
public final class ColorUtil {

    public static class RGB {
        int red;
        int green;
        int blue;

        public RGB(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getRed() {
            return red;
        }

        public int getGreen() {
            return green;
        }

        public int getBlue() {
            return blue;
        }

        public float getRedFloat() {
            return toFloat(red);
        }

        public float getGreenFloat() {
            return toFloat(green);
        }

        public float getBlueFloat() {
            return toFloat(blue);
        }
    }

    private static float toFloat(int color) {
        return (float) color / 255f;
    }

    public static RGB toRGB(int color) {
        int red = (color >> 16) & 0xff;
        int green = (color >> 8) & 0xff;
        int blue = color & 0xff;

        return new RGB(red, green, blue);
    }

    public static RGB toRGB(String color) {
        return toRGB(Color.parseColor(color));
    }

    /**
     * rgb转换成16进制
     * @param r
     * @param g
     * @param b
     * @return
     */
    public static String toHex(int r, int g, int b){
        return String.format("#%02X%02X%02X", r, g, b);
    }

    public static String toHex(RGB rgb) {
        return toHex(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    }

    public static String toHex(int color) {
        return toHex(toRGB(color));
    }



    public static final int DEFAULT_COLOR = Color.parseColor("#DFDFDF");
    public static final int DEFAULT_DARKEN_COLOR = Color.parseColor("#DDDDDD");
    public static final int COLOR_BLUE = Color.parseColor("#33B5E5");
    public static final int COLOR_VIOLET = Color.parseColor("#AA66CC");
    public static final int COLOR_GREEN = Color.parseColor("#99CC00");
    public static final int COLOR_ORANGE = Color.parseColor("#FFBB33");
    public static final int COLOR_RED = Color.parseColor("#FF4444");
    public static final int[] COLORS = new int[]{COLOR_BLUE, COLOR_VIOLET, COLOR_GREEN, COLOR_ORANGE, COLOR_RED};
    private static final float DARKEN_SATURATION = 1.1f;
    private static final float DARKEN_INTENSITY = 0.9f;
    private static int COLOR_INDEX = 0;

    public static final int pickColor() {
        return COLORS[(int) Math.round(Math.random() * (COLORS.length - 1))];
    }

    public static final int nextColor() {
        if (COLOR_INDEX >= COLORS.length) {
            COLOR_INDEX = 0;
        }
        return COLORS[COLOR_INDEX++];
    }

    public static int darkenColor(int color) {
        float[] hsv = new float[3];
        int alpha = Color.alpha(color);
        Color.colorToHSV(color, hsv);
        hsv[1] = Math.min(hsv[1] * DARKEN_SATURATION, 1.0f);
        hsv[2] = hsv[2] * DARKEN_INTENSITY;
        int tempColor = Color.HSVToColor(hsv);
        return Color.argb(alpha, Color.red(tempColor), Color.green(tempColor), Color.blue(tempColor));
    }
}
