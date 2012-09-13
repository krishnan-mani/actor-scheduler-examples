package com.ee.scheduler
import javax.servlet.{ServletContextEvent, ServletContextListener}


class MyServletContextListener extends ServletContextListener {
  def contextInitialized(p1: ServletContextEvent) {
    ScheduleOnceExample.runOnceFuncExample()
    ScheduleOnceExample.runOnceReceiverMessageExample()
    ScheduleOnceExample.runOnceRunnableExample()
  }

  def contextDestroyed(p1: ServletContextEvent) {
    println("Gotta go now!")
  }
}
