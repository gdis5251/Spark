package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object simple_api {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("gerald")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    // 读取文件, 生成 RDD
    val lines = sc.textFile("./data/words.txt")
    // 挑出 hello
    val words = lines.map(line => line.split(" "))
    words.foreach(println)
    println("++++++++++++++++++")
    val strings = words.reduce((lhs, rhs) => {
      if ("hello".contains(lhs))
        lhs
      else
        rhs
    })
    strings.foreach(println)
  }
}
