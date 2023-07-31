package com.curvu.farmingutils.utils;

import java.awt.*;
import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

public class Utils {
  /**
   * Schedule a task
   * @param function that will run
   * @param time in seconds
   */
  public static void scheduleTask(Runnable function, float time) {
    new Timer().schedule(
      new TimerTask() {
        @Override
        public void run() { function.run(); }
      },
      (int) (time * 1000));
  }

  /**
   * Open an url in the default browser
   * @param url to open
   */
  public static void openUrl(String url) {
    try {
      Desktop.getDesktop().browse(URI.create(url));
    } catch (java.io.IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
