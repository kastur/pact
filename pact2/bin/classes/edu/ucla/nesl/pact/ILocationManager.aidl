/*
 * Copyright (C) 2007, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.ucla.nesl.pact;

import android.location.Criteria;
import edu.ucla.nesl.pact.ILocationListener;
import android.location.Location;

/**
 * System private API for talking with the location service.
 *
 * {@hide}
 */
interface ILocationManager
{

    void requestLocationUpdates(String provider, in Criteria criteria, long minTime, float minDistance,
        boolean singleShot, in ILocationListener listener);
    void removeUpdates(in ILocationListener listener);

    // for reporting callback completion
    void locationCallbackFinished(ILocationListener listener);

    Location getLastKnownLocation(String provider);

    // Used by location providers to tell the location manager when it has a new location.
    // Passive is true if the location is coming from the passive provider, in which case
    // it need not be shared with other providers.
    void reportLocation(in Location location, boolean passive);

}