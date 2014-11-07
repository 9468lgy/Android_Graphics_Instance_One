package com.example.testdraw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * �Զ���ؼ�Բ��
 * @author DuGuang
 * blog��ַ��http://blog.csdn.net/duguang77 
 */
public class CustomCircle extends View {

	private float mCenterX; // Բ��X������
	private float mCenterY;	//Բ��Y������
	private float mCircleSize;	//Բ��ֱ����С
	private Context mContext; 
	private int mWidth;	//�����Ŀ� == �ֻ���Ļ�Ŀ�
	private int mHeight;//�����ĸ� == �ֻ���Ļ�ĸ� - ActionBar - ����title

	public CustomCircle(Context context) {
		super(context);
		init(context);
	}

	public CustomCircle(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public CustomCircle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	/**
	 * ��ʼ������
	 * @param context 
	 */
	private void init(Context context) {
		this.mContext = context;
		this.mCenterX = 350f;
		this.mCenterY = 350f;
		this.mCircleSize = 285f;
	
	}


	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		mWidth = canvas.getWidth();
		mHeight = canvas.getHeight();
		mCenterX = mWidth/2;
		mCenterY = mHeight/4;
		mCircleSize = mHeight/6;
		
		//��һ�����ʣ�����һ������Բ
		Paint paint = new Paint();
		paint.setAntiAlias(true); //�����ݾ�
		paint.setStyle(Style.STROKE); //���Ļ���
		paint.setStrokeWidth(30f);	//���ʿ��
		paint.setDither(true);	//������ӱ
		paint.setColor(getResources().getColor(R.color.cril)); //���û�����ɫ

		//ͨ��Path ��canvas�ڻ����ϻ���Բ��
		Path path = new Path();
		path.addCircle(mCenterX, mCenterY, mCircleSize, Path.Direction.CCW);
		canvas.drawPath(path, paint);

		
		//�ڶ������ʣ�����һ��ʵ��Բ
		Paint paint_white = new Paint();
		Path path_white = new Path();
		paint_white.setAntiAlias(true);
		paint_white.setStyle(Style.FILL);
		paint_white.setDither(true);
		paint_white.setColor(getResources().getColor(R.color.white));
		path_white.addCircle(mCenterX, mCenterY, mCircleSize-15, Path.Direction.CCW);
		canvas.drawPath(path_white, paint_white);
		
		
		//���������ʣ�����һ������Բ
		Paint paint_STROKE = new Paint();
		Path path_STROKE = new Path();
		paint_STROKE.setAntiAlias(true);
		paint_STROKE.setStyle(Style.STROKE);
		paint.setStrokeWidth(5f);	//���ʿ��
		paint_STROKE.setDither(true);
		paint_STROKE.setColor(getResources().getColor(R.color.cril));
		path_STROKE.addCircle(mCenterX, mCenterY, mCircleSize-25, Path.Direction.CCW);
		canvas.drawPath(path_STROKE, paint_STROKE);
		
		
		
	}

}
