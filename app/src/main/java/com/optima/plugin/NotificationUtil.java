package com.optima.plugin;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.optima.plugin.repluginlib.pluginUtils.P_Constants;
import com.optima.plugin.repluginlib.pluginUtils.P_Context;

/**
 * com.optima.android.notification
 * LiuYang 2019-06-13 10:48
 */
public class NotificationUtil {
	private static final String TAG = "NotificationUtil";

	public static final int FOREGROUND_SERVICE_ID = 8888;

	private final NotificationManager mNotificationManager;
	private String mChannelImportanceId = "9998";
	private String mChannelDownloadId = "9997";
	private String mChannelImportanceName = "importance";
	private String mChannelDefaultId = "9999";
	private String mChannelDefaultName = "default";
	private String mChannelGroupId = P_Constants.HOST_PACKAGE_NAME;
	private String mDownloadChannelGroupId = P_Constants.HOST_PACKAGE_NAME + ".download";
	private Context mContext;
	private String contentText;
	private String contentTitle;
	private int smallIcon;
	private Bitmap largeIcon;

	public NotificationUtil() {
		this.mContext = P_Context.getContext();
		this.mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
	}

	/**
	 * 创建一个重要的频道
	 * @param channelId   频道id
	 * @param channelName 频道名称
	 * @return
	 */
	@RequiresApi(api = Build.VERSION_CODES.O)
	private NotificationChannel createImportanceChannel(String channelId, String channelName) {
		NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);

//		channel.setGroup(mChannelGroupId);// 给 channel 分配组
		channel.enableLights(true);// 是否可以亮呼吸灯
		channel.setLightColor(Color.RED);// 设置呼吸灯颜色
		channel.enableVibration(true);// 是否可以震动
		channel.setVibrationPattern(new long[]{1000, 500, 1000});// 震动1秒。停止0.5秒。再震动2秒
		channel.setBypassDnd(true);// 是否可以打断用户
		channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);// 设置是否锁屏后可见
		channel.setShowBadge(true);// Launcher图标上是否可显示消息
//        channel.setSound();// 设置提示声音
		return channel;
	}

	/**
	 * 创建一个重要NotificationBuilder
	 * @return
	 */
	public Notification.Builder createImportanceBuilder() {
		Log.i(TAG, "createImportanceBuilder: ");
		Notification.Builder builder;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel channel = createImportanceChannel(mChannelImportanceId, mChannelImportanceName);
			mNotificationManager.createNotificationChannel(channel);
			builder = new Notification.Builder(mContext, mChannelImportanceId);
		} else {
			builder = new Notification.Builder(mContext);
		}
		builder.setPriority(Notification.PRIORITY_MAX) //
				.setContentTitle(contentTitle) //
				.setContentText(contentText) //
				.setSmallIcon(smallIcon) //
				.setLargeIcon(largeIcon) //
				.setVibrate(new long[]{1000, 500, 2000}) //
				.setAutoCancel(false) //
				.setGroup(mChannelGroupId) //
				.setGroupSummary(true) //
				.setLights(Color.RED, 1000, 1000) //
				.setShowWhen(true) //
				.setWhen(System.currentTimeMillis()) //
		;
		return builder;
	}

	/**
	 * 创建一个默认频道
	 * @param channelId   频道id
	 * @param channelName 频道名称
	 * @return
	 */
	@RequiresApi(api = Build.VERSION_CODES.O)
	private NotificationChannel createDefaultChannel(String channelId, String channelName) {
		NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW);

//		channel.setGroup(mChannelGroupId);// 给 channel 分配组
		channel.enableLights(true);// 是否可以亮呼吸灯
		channel.setLightColor(Color.GREEN);// 设置呼吸灯颜色
//        channel.enableVibration(true);// 是否可以震动
//        channel.setVibrationPattern(new long[]{1000, 500, 1000});// 震动1秒。停止0.5秒。再震动2秒
		channel.setBypassDnd(false);// 是否可以打断用户
		channel.setLockscreenVisibility(Notification.VISIBILITY_SECRET);// 设置是否锁屏后可见
		channel.setShowBadge(false);// Launcher图标上是否可显示消息
//        channel.setSound();// 设置提示声音
		return channel;
	}

	/**
	 * 创建一个默认配置的NotificationBuilder
	 * @return
	 */
	public Notification.Builder createDefaultBuilder() {
		Log.i(TAG, "createDefaultBuilder: ");

		Notification.Builder builder;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel channel = createDefaultChannel(mChannelDefaultId, mChannelDefaultName);
			mNotificationManager.createNotificationChannel(channel);

			builder = new Notification.Builder(mContext, mChannelDefaultId);
		} else {
			builder = new Notification.Builder(mContext);
		}

		builder.setPriority(Notification.PRIORITY_DEFAULT) // 重要程度
				.setContentTitle(contentTitle) // 标题
				.setContentText(contentText) // 内容
				.setSmallIcon(smallIcon) // 小图标
				.setLargeIcon(largeIcon) // 大图表
//                .setVibrate(new long[]{1000, 500, 2000})
				.setAutoCancel(true) // 是否可以取消删除
				.setGroup(mChannelGroupId) // 分组
				.setGroupSummary(true) // group key相同的归为一组,必须和setGroup一起使用才生效
				.setLights(Color.GREEN, 1000, 1000) // 三色灯控制
				.setShowWhen(true) // 是否显示多久之前添加的
				.setLocalOnly(true) // 是否只在当前设备显示
				.setWhen(System.currentTimeMillis()) // 时间
		;
		return builder;
	}

	/**
	 * 显示一个通知
	 * @param notificationId 通知id
	 * @param notification   通知对象
	 */
	public void showNotification(int notificationId, Notification notification) {
		mNotificationManager.notify(notificationId, notification);
	}

	/**
	 * 取消显示一个通知
	 * @param notificationId 通知id
	 */
	public void cancelNotification(int notificationId) {
		mNotificationManager.cancel(notificationId);
	}

	/**
	 * 创建下载通知的Builder
	 * @param max     通知最大值
	 * @param process 当前进度值
	 * @return
	 */
	public Notification.Builder createDownloadBuilder(int max, int process) {
		Log.i(TAG, "createDownloadBuilder: ");

		Notification.Builder builder;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel channel = createImportanceChannel(mChannelDownloadId, mChannelImportanceName);
			mNotificationManager.createNotificationChannel(channel);
			builder = new Notification.Builder(mContext, mChannelImportanceId);
		} else {
			builder = new Notification.Builder(mContext);
		}

		builder.setPriority(Notification.PRIORITY_MAX) //
				.setContentTitle(contentTitle) //
				.setContentText(contentText) //
				.setSmallIcon(smallIcon) //
				.setLargeIcon(largeIcon) //
				.setAutoCancel(false) //
				.setOnlyAlertOnce(true) //
				.setVibrate(new long[]{1000, 500, 2000}) //
				.setAutoCancel(false) //
				.setGroup(mDownloadChannelGroupId) //
				.setGroupSummary(true) //
				.setProgress(max, process, false) //
				.setLights(Color.RED, 1000, 1000) //
				.setShowWhen(true) //
				.setWhen(System.currentTimeMillis()) //
		;
		return builder;

	}

	/**
	 * 更新下载notification
	 * @param notificationId 通知id
	 * @param max            最大值
	 * @param process        当前进度
	 * @param builder        通知对象
	 */
	public void updateDownloadNotification(int notificationId, int max, int process, Notification.Builder builder) {
		if (process != max) {
			builder.setProgress(max, process, false);
			builder.setContentTitle("正在下载");
			builder.setContentText((process * 100 / max) + "%");
		} else {
			builder.setProgress(100, 100, false);
			builder.setContentTitle("下载完毕");
//			builder.setContentText("等待安装");
			builder.setContentText((process * 100 / max) + "%");
		}
		showNotification(notificationId, builder.build());
	}

	/**
	 * 开启前台服务
	 * @param service 服务
	 */
	public void startForeground(Service service) {
		Log.i(TAG, "startForeground: ");
		if (service != null) {
			service.startForeground(FOREGROUND_SERVICE_ID, createDefaultBuilder().build());
		}
	}

}
