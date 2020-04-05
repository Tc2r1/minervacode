package com.owl.minervacode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.owl.minervacode.objects.Arc;
import com.owl.minervacode.objects.Dot;

import java.util.ArrayList;

public class CircleTextView extends View
{



        private Paint mCirlcePaint;
        private Rect textBounds;
        private double mTextWidth, mTextHeight;
        private int centerX,centerY;
        private ArrayList<String> seperatedWords;
        private Path path;
        private Paint cPaint;
        private Paint tPaint;
        private float radius;

        ArrayList<Arc> arcs;
        ArrayList<Dot> dots;

        public CircleTextView(Context context, AttributeSet attrs) {
            super(context);
            this.seperatedWords = new ArrayList<>();
            init();
        }



        // CONSTRUCTOR
        public CircleTextView(Context context, ArrayList<String> seperatedWords) {
            super(context);
            this.seperatedWords = seperatedWords;
            init();


        }

    private void init()
    {
        setFocusable(true);
        path = new Path();
        tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textBounds = new Rect();

        mCirlcePaint = new Paint();
        mCirlcePaint.setStyle(Paint.Style.FILL);
        mCirlcePaint.setColor(Color.GREEN);

        for (String ss : seperatedWords)
        {
            Log.wtf("Word is: ", ss);
        }
    }

    @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            centerX = w / 2;
            centerY = h / 2;

        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onDraw(Canvas canvas) {


            // tPaint.getTextBounds(quote, 0, quote.length(), textBounds);
            // mTextHeight = textBounds.height(); // Use height from getTextBounds()

//            double clenght = 0.5;
//            for (int i = 0; i < QUOTE.length(); i++) {
//                clenght += 1.5;
//                if (QUOTE.charAt(i) == '-') {
//                    arcs.add(new Arc(radius, -90 + 360 * clenght / mTextWidth, -90 + 360 * (clenght + 3) / mTextWidth));
//                    //arcs.push([crad, -90+360*clenght/tlenght, -90+360*(clenght+3)/tlenght]);
//                    clenght += 3;
//                } else if (QUOTE.charAt(i) == ' ') {
//                    clenght += 1.5;
//                } else if (QUOTE.charAt(i) == '.') {
//                    dots.add(new Dot(clenght/mTextWidth, radius));
//                    //dots.push([clenght/tlenght, crad]);
//                }
//            }

            //                mTextWidth += 1.5;
//                if (QUOTE.charAt(i) == '-') {
//                    mTextWidth+= 3;
//                } else if (QUOTE.charAt(i) == ' ') {
//                    mTextWidth += 1.5;
//                }

            tPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            tPaint.setColor(Color.BLACK);
            tPaint.setTextSize(100f);
            String circleString;

            radius = (float)  360f ;  //(360 / (Math.PI));
            float diameter = radius;

            for (int i = 0; i < seperatedWords.size(); i++ )
            {
                circleString = seperatedWords.get(i);

                float quater = ((4.0f * radius) / 360.0f);
                float startAngle = -(radius / quater);

                Log.wtf("Data:", radius +  " , StartAngle = " + startAngle);
                tPaint.getTextBounds(circleString, 0, circleString.length(), textBounds);
                path.reset();
                path.addCircle(centerX, centerY, diameter, Path.Direction.CW);

                for (int j = 0; j < circleString.length(); j++ )
                {
                    canvas.rotate(startAngle, getWidth() / 2, getHeight() / 2);
                    startAngle = (radius / (circleString.length()));
                    canvas.drawTextOnPath(String.valueOf(circleString.charAt(j)), path, 0, 0, tPaint);
                }


                path.close();


                Log.wtf("Textbound", "Radius is "+ diameter);
                diameter -= textBounds.height();
                // radius -= textBounds.height();

            }
            canvas.rotate(0, getWidth() / 2, getHeight() / 2);
            //canvas.drawCircle(centerX, centerY, radius, mCirlcePaint);
        }

}
