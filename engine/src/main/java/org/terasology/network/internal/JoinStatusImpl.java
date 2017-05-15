/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.network.internal;

import com.google.common.util.concurrent.AtomicDouble;
import org.terasology.network.joinState.Status;
import org.terasology.network.joinState.StatusManager;
import org.terasology.network.JoinStatus;


/**
 */
public class JoinStatusImpl implements JoinStatus {
    private StatusManager status = new StatusManager();
    private String currentActivity = "";
    private AtomicDouble currentProgress = new AtomicDouble(0);

    public JoinStatusImpl() {
    }

    public JoinStatusImpl(String errorMessage) {
        status.setStatus(errorMessage);
    }

    @Override
    public synchronized Status getStatus() {
        return status.getStatus();
    }

    @Override
    public synchronized String getCurrentActivity() {
        return currentActivity;
    }

    public synchronized void setCurrentActivity(String currentActivity) {
        this.currentActivity = currentActivity;
        currentProgress.set(0);
    }

    @Override
    public float getCurrentActivityProgress() {
        return (float) currentProgress.get();
    }

    public void setCurrentProgress(float currentProgress) {
        this.currentProgress.set(currentProgress);
    }

    @Override
    public synchronized String getErrorMessage() {
        return status.getStatus().getMessage();
    }

    public synchronized void setErrorMessage(String errorMessage) {
        status.setStatus(errorMessage);
    }

    public synchronized void setComplete() {
        status.setStatus("");
    }
}
