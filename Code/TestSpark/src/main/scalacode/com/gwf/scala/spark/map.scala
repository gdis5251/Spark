package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object map {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("guowenfeng")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val input = sc.parallelize(List(1, 2, 3, 4, 5))
    val res = input.map(x => {
      x*x
    })

    res.foreach(println)
    println(res.collect().mkString(","))
  }
}
