package com.kingston.game.core;

import java.util.Objects;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * job定时器挂点
 */
public class SchedulerHelper {

	private static Scheduler scheduler;

	private final static String configPath = "configs/jobs/quartz.properties";

	public static synchronized void setScheduler(Scheduler scheduler) {
		Objects.requireNonNull(scheduler);
		SchedulerHelper.scheduler = scheduler;
	}

	public static synchronized Scheduler getScheduler() {
		return scheduler;
	}

	/**
	 * 初始化
	 * @param path 配置文件的路径
	 * @throws SchedulerException
	 */
	public static synchronized void initAndStart(String path) throws SchedulerException {
		Objects.requireNonNull(path);
		SchedulerFactory schedulerFactory;
		schedulerFactory = new StdSchedulerFactory(path);
		scheduler = schedulerFactory.getScheduler();
		scheduler.start();
	}

	public static synchronized void initAndStart() throws SchedulerException {
		SchedulerFactory schedulerFactory;
		schedulerFactory = new StdSchedulerFactory(configPath);
		scheduler = schedulerFactory.getScheduler();
		scheduler.start();
	}

	/**
	 * 初始化
	 * @param path 配置文件的路径
	 * @throws SchedulerException
	 */
	public static synchronized void init(String path) throws SchedulerException {
		Objects.requireNonNull(path);
		SchedulerFactory schedulerFactory = new StdSchedulerFactory(path);
		scheduler = schedulerFactory.getScheduler();
	}


}
