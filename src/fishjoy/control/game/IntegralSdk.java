package fishjoy.control.game;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.xbwx.Actions;

import fishjoy.control.menu.R;

public class IntegralSdk {

	public static IntegralSdk gameScoreSdk = new IntegralSdk();
	public Handler myHandler = new Handler();
	
	private Actions actions;
	private Activity context;
	
	private static final String APP_ID = "appId";
	
	
	public static IntegralSdk getInstance(){
		return gameScoreSdk;
		
	}
	
	public void init(Activity context){
		this.context = context;
		initIntegral();
	}
	
	/**
	 * 初始化积分列表
	 */
    public void initIntegral(){
		actions = Actions.getInstance(context,APP_ID,myHandler);
		actions.downLoadBanner();
		actions.initBannerLayout(8,1,true,12);
		try {
			FrameLayout.LayoutParams params3 = new FrameLayout.LayoutParams
	        (FrameLayout.LayoutParams.FILL_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
	        params3.setMargins(0, 100, 0, 100);
	        params3.gravity=Gravity.BOTTOM|Gravity.RIGHT;
			actions.setBannerLayout(params3, params3);
			actions.initNoticeLayout(R.layout.push_layout, R.id.notify_text, R.id.notify_image);
			actions.downLoadNotification();
			actions.showNotice(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    /**
     * 
     * @return 获取积分
     */
    public int getSdkScore(){
    	if(actions != null){
    		return actions.getPoints();
    	}
    	return 0;
    }
    
    
    /**
     * 花费积分
     * @param integral
     */
    public void consumeIntegral(int integral){
    	if(actions != null){
    		actions.spendPoints(integral);
    	}
    }
    
    
    /**
     * 展现积分列表
     */
    public void showIntegralList(){
    	if(actions != null){
    		actions.showOfferList();
    	}
    	
    }
    
    /**
     * 展现广告条
     */
    public void controlIntegral(boolean show){
    	if(actions != null){
    		actions.showBanner(show);
    	}
    	
    }
}
