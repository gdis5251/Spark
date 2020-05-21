package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object create_rdd_demo {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("create_rdd_demo").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    // 通过makeRDD 创建
    val rdd1 = sc.makeRDD(Array(1, 2, 3, 4, 5, 6))
    // 通过 parallelize
    val rdd2 = sc.parallelize(Array(1, 2, 3, 4, 5, 6))

    // 通过读取外部文件创就按
    val rdd3 = sc.textFile("本地路径/HDFS路径")

    sc.stop()
  }
}
