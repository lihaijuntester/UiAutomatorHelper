package com.uitest;
import android.util.Log;
import android.widget.TextView;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class test extends UiAutomatorTestCase {
	
	public static void main(String[] args) {
		String jarName, testClass, testName, androidId;
		jarName="test";
		testClass="com.uitest.Demo";
		testName="testId";
		androidId="1";
	new UiAutomatorHelper(jarName, testClass, testName, androidId);

	}
	public void testdemo() throws Exception{
		UiObject messageObject=new UiObject( new UiSelector().text("Messaging"));
		//UiObject browserObject=new UiObject( new UiSelector().text("browser"));
		messageObject.clickAndWaitForNewWindow();
		UiObject mesgObject=new UiObject( new UiSelector().className("android.widget.TextView"));
		Log.v("error", "这个是抓到的"+mesgObject);
		mesgObject.click();
		mesgObject.clickAndWaitForNewWindow();
		Log.v("error", "点击等待新窗口成功");
		//UiObject editphone=new UiObject( new UiSelector().text("To"));
		UiObject editphone=new UiObject( new UiSelector().className("android.widget.MultiAutoCompleteTextView"));
		editphone.click();
		editphone.setText("13917357664");
		UiObject edittext=new UiObject(new UiSelector().className("android.widget.EditText"));
		edittext.click();
		edittext.setText("the myfirst auto test sequence");
		UiObject imagebutton=new UiObject(new UiSelector().className("android.widget.ImageButton"));
		imagebutton.click();
		UiDevice.getInstance().pressHome();
		sleep(2000);
	}
	public void testdemo1() throws UiObjectNotFoundException{
		UiSelector homepage=new UiSelector().className("android.widget.TextView");
		UiObject homeObject=new UiObject(homepage);
		homeObject.clickAndWaitForNewWindow();	
	}
	public void testDemo() throws UiObjectNotFoundException{
		//找到对象---点击对象
		UiSelector l=new UiSelector().text("联系人");
		UiObject object=new UiObject(l);
		object.click();
		
	}
	public void testMatches() throws UiObjectNotFoundException{
		//联系人
		//完全匹配：联系人
		//包含匹配：系人
		//正则匹配：.*系.*
		//起始匹配：联系
		
		//UiSelector l=new UiSelector().textContains("系人");
		//UiSelector l=new UiSelector().textMatches(".*系.*");
		UiSelector l=new UiSelector().textStartsWith("联系");
		UiObject object=new UiObject(l);
		object.click();		
		
	}
	public void testDesc() throws UiObjectNotFoundException{
		//完全匹配：应用
		//UiSelector selector=new UiSelector().description("应用");
		//包含匹配:应
		//UiSelector selector=new UiSelector().descriptionContains("应");
		//正则匹配
		//UiSelector selector=new UiSelector().descriptionMatches("应.*");
		//起始匹配
		UiSelector selector=new UiSelector().descriptionStartsWith("应");
		UiObject object=new UiObject(selector);
		object.click();
		TextView.class.getName();
		
	}
	public void testClassAndPackage() throws UiObjectNotFoundException{
		//完全匹配
		//UiSelector selector=new UiSelector().className("android.view.View").instance(5);
		//正则方式
		//UiSelector selector=new UiSelector().classNameMatches(".*View").instance(7);
		//class.getName
//		UiSelector selector=new UiSelector().className(View.class.getName()).instance(5);
//		UiObject object=new UiObject(selector);
//		object.click();
		
		UiSelector selector=new UiSelector().packageName("com.android.deskclock");						
		
	}
	public void testIndex() throws UiObjectNotFoundException{
		//城市按钮
		UiSelector selector=new UiSelector().className("android.widget.ImageButton").index(0);
		UiObject object=new UiObject(selector);
		object.click();
		sleep(2000);
		UiDevice.getInstance().pressBack();
		sleep(2000);
		//更多选项
		UiSelector more=new UiSelector().className("android.widget.ImageButton").instance(1);
		UiObject objectMore=new UiObject(more);
		objectMore.click();
		
	}

	public void testProperty() throws UiObjectNotFoundException{
//		UiObject swtichObj=new UiObject(new UiSelector().checkable(true));
//		swtichObj.click();
		
//		UiObject swtichObj=new UiObject(new UiSelector().checked(true));
//		swtichObj.click();
		
		//enable
//		UiObject send=new UiObject(new UiSelector().enabled(false));		
//		System.out.println("CLASS NAME:"+send.getClassName());
		
		//focused
//		UiObject focusedObj=new UiObject(new UiSelector().focused(true));
//		focusedObj.setText("abcd");
		
		//longclick
//		UiObject longclick=new UiObject(new UiSelector().longClickable(true).index(4));
//		longclick.click();
		
		//scrollable
		UiScrollable scrollable=new UiScrollable(new UiSelector().scrollable(true));
		scrollable.scrollForward();
		sleep(1000);
		scrollable.scrollForward();
		sleep(1000);
		scrollable.scrollForward();
		sleep(1000);
		
	}
	public void testNode() throws UiObjectNotFoundException{
		//childselector
//		UiScrollable scrollable=new UiScrollable(new UiSelector()
//		.scrollable(true).childSelector(new UiSelector().text("Android")));		
//		scrollable.click();
		
		//formParent
		UiObject parentObj=new UiObject(new UiSelector()
		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_details_item")
		.fromParent(new UiSelector().className("android.widget.LinearLayout").index(1)));
		parentObj.click();
	}
	public void testId() throws UiObjectNotFoundException{
//		UiObject home=new UiObject(new UiSelector().resourceId("android:id/home"));
//		home.click();
		
//		UiObject download=new UiObject(new UiSelector()
//		.resourceId("com.cyanogenmod.filemanager:id/navigation_view_details_item")
//		.index(3));
//		
//		download.click();
		
		UiObject download=new UiObject(new UiSelector()
		.resourceIdMatches(".*navigation_view_details_item")
		.index(3));		
		download.click();
			
	}

}
