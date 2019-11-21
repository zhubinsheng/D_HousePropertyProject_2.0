package com.example.d_housepropertyproject.tool;

import android.opengl.GLES10;

import javax.microedition.khronos.opengles.GL10;

public class ImageUtils {
    private static final int DEFAULT_MAX_BITMAP_DIMENSION = 2048;
    private static int maxHeight = 0;
    static {
        int[] maxTextureSize = new int[1];
        GLES10.glGetIntegerv(GL10.GL_MAX_TEXTURE_SIZE, maxTextureSize, 0);
        maxHeight = Math.max(maxTextureSize[0], DEFAULT_MAX_BITMAP_DIMENSION);
    }

    public static int getMaxHeight(){
        return maxHeight;
    }
}