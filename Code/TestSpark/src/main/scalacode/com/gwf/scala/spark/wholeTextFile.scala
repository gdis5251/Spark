package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object wholeTextFile {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("guowenfeng")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val input = sc.wholeTextFiles("/usr/local/spark-2.4.5-bin-hadoop2.7")
    val res = input.mapValues(y => {
      val num = y.split(" ").map(x => x.toDouble)
      num.sum / num.size.toDouble
    })

    res.saveAsTextFile("./example")
  }
}
