package com.ee.scheduler

import akka.actor.{Props, Actor, ActorSystem}
import akka.util.FiniteDuration
import actors.threadpool.{TimeUnit, RunnableFuture}

object ScheduleOnceExample {

  val system = ActorSystem("system")
  val scheduler = system.scheduler

  val thirty_seconds = new FiniteDuration(30, "seconds")
  val fifty_seconds = new FiniteDuration(50, "seconds")

/* 
  Following examples are to schedule just one invocation
  Similar mechanism is used with the addition of a method argument for the frequency when scheduled to run at intervals
*/

  def runOnceFuncExample() {
    scheduler.scheduleOnce(thirty_seconds)(println("Simple function that is run once with a delay"))
  }

  def runOnceReceiverMessageExample() {
    scheduler.scheduleOnce(fifty_seconds, system.actorOf(Props[MyReceiver], "mbrando"), "test")
  }

  def runOnceRunnableExample() {
    scheduler.scheduleOnce(fifty_seconds + thirty_seconds, new MyThread())
  }

}

class MyReceiver extends Actor {
  def receive = {
    case _ => println("Received a message")
  }
}

class MyThread extends Thread {
  override def run() {
    println("Thread was run")
  }
}
