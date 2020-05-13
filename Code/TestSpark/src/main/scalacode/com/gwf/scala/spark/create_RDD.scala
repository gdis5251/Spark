package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object create_RDD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Gerald")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    // RDD 的创建方式
    // parallelize: 直接可以读取一个手动写入的集合
    val rdd = sc.parallelize(List("GuoWenfeng", "HuYue"))
    rdd.foreach(println)

    // 但是常用的方式是 textFile，这里不做演示了
  }
}
