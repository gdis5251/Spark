package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object flatmap {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("guowenfeng")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val lines = sc.parallelize(List("Hello guowenfeng", "Hi Huyue"))
    val words = lines.flatMap(line => {
      line.split(" ")
    })

    words.foreach(println)
  }
}
