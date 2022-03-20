package com.concurrent.deadlock.detection;

import java.lang.management.ThreadInfo;

public interface DetectionHandler {
    void handleDeadlock(final ThreadInfo[] deadlockedThreads);
}
