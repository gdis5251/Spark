package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object checkpoint_test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("checkpoint")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    // 如果要使用 checkpoint 需要先设置保存的目录
    sc.setCheckpointDir("./data/cp")

    val rdd = sc.textFile("./data/words.txt")
    rdd.checkpoint()

    val count = rdd.count
    println(count)

    sc.stop()
  }
}
