package com.heyoufu.pay.common.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.*;
import java.util.function.Supplier;

/*
 *@Descrition 异步工具类
 *
 *@Autnor XUAN
 *@Date 2018/05/18 15:49
 */
@Log4j2
public class AsyncUtils {
    /**
     * cpu核心数
     */
    private static final int CPU_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * 线程工厂
     */
    private static ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder()
            .setNameFormat("daqing-yunying-pool-%d")
            .setDaemon(true);
    /**
     * 线程池
     */
    public static final Executor EXECUTOR = new ThreadPoolExecutor(CPU_CORES + 1, CPU_CORES * 30, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(4096), threadFactoryBuilder.build(), new ThreadPoolExecutor.AbortPolicy());

    /**
     * 异步执行，有返回值
     *
     * @param supplier
     * @param <U>
     * @return CompletableFuture<U>
     */
    public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
        return CompletableFuture.supplyAsync(supplier, EXECUTOR);
    }

    /**
     * 异步执行，没有返回值
     *
     * @param runnable
     */
    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        return CompletableFuture.runAsync(runnable, EXECUTOR).exceptionally(e -> {
            log.error("runAsync error", e);
            return null;
        });
    }


}
