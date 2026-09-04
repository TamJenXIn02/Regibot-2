package com.example.automator;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.view.accessibility.AccessibilityEvent;

public class AutomationService extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // Runs whenever the screen content changes
    }

    @Override
    public void onInterrupt() {
        // Runs if the service is stopped
    }

    // Simulates a screen tap at specific X and Y coordinates
    public void tapScreen(float x, float y) {
        Path path = new Path();
        path.moveTo(x, y);

        GestureDescription.StrokeDescription stroke = 
            new GestureDescription.StrokeDescription(path, 0, 50);

        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(stroke);

        dispatchGesture(builder.build(), null, null);
    }
}
