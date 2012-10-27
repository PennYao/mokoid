/*
 * Copyright (C) 2009 The Mokoid Open Source Project
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

package com.mokoid.server;

import android.util.Config;
import android.util.Log;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IBinder;
import mokoid.hardware.ILedService;
import java.lang.String;

/**
 * expose interface to clients.
 *
 *   LedService ls = new LedService();
 *   ServiceManager.addService("led", ls);
 *
 */
public final class LedService extends ILedService.Stub {    

    static {
        System.load("/system/lib/libmokoid_runtime.so");
    }

    public LedService() {
        Log.i("LedService", "Go to get LED Stub...");
	_init();
    }

    /*
     * Mokoid LED native methods.
     */
    public boolean setOn(int led, float timeout, String str, int arr[]) {
        Log.i("MokoidPlatform", "LED On");
	return _set_on(led, timeout, str, arr);
    }

    public boolean setOff(int led) {
        Log.i("MokoidPlatform", "LED Off");
	return _set_off(led);
    }

    private static native boolean _init();
    private static native boolean _set_on(int led, float timeout, String str, int arr[]);
    private static native boolean _set_off(int led);
}
