package com.simple;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Adminis on 2017/5/1.
 */
public class PasswordView extends EditText {
    private static final String TAG ="PasswordView" ;
    private Paint bordPaint;//外框画笔
    private Paint linePaint;//线 的画笔
    private Paint passTextPaint;//密码画笔
    private float width;
    private float height;
    private int passwordLength = 6;//代码的长度
    private int textLength;
    private int radius = 15;
    public PasswordView(Context context) {
        this(context,null);
    }
    public PasswordView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        setFocusable(true);
        bordPaint = new Paint();
        bordPaint.setStrokeWidth(8);
        bordPaint.setColor(Color.WHITE);
        bordPaint.setStyle(Paint.Style.FILL);

        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#eeeeee"));
        linePaint.setStrokeWidth(2);

        passTextPaint = new Paint();
        passTextPaint.setColor(Color.parseColor("#000000"));
        passTextPaint.setStrokeWidth(12);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        drawRoundRect(canvas);
        drawLine(canvas);
        drawTextPass(canvas);
    }

    /**
     * 绘制密码
     * @param canvas
     */
    private void drawTextPass(Canvas canvas) {
        float cx, cy = height/ 2;
        float half = width / passwordLength / 2;
        for(int i = 0; i < textLength; i++) {
            cx = width * i / passwordLength + half;
            canvas.drawCircle(cx, cy, radius, passTextPaint);
        }
    }

    /**
     * 绘制线
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        for (int i = 1; i < passwordLength; i++) {
            float x = width * i / passwordLength;
            canvas.drawLine(x, 12, x, height-12, linePaint);
        }
    }
    /**
     * 绘制背景
     * @param canvas
     */
    private void drawRoundRect(Canvas canvas) {
        canvas.drawRoundRect(0f,0f,width,height,16f,16f,bordPaint);
    }
    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        this.textLength = text.toString().length();
        if(textLength==6){
            Toast.makeText(getContext(),"您设置的密码为"+text, Toast.LENGTH_SHORT).show();
        }
        invalidate();
    }
    public void setEmpeyText(){
        setText("");
        invalidate();
    }
}
