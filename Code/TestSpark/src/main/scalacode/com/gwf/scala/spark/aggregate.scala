package com.gwf.scala.spark

import org.apache.spark.{SparkConf, SparkContext, TaskContext}

import scala.collection.mutable.ArrayBuffer

object aggregate {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("aggregate").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("Error")

    val rdd1 = sc.parallelize(List(("a", 2), ("a", 5), ("a", 4), ("b", 5), ("c", 3), ("b", 3), ("c", 6), ("a", 8)), 4)
    val result = rdd1.aggregate((0, 0))(
      (u, c) => (u._1 + 1, u._2 + c._2),
      (r1, r2) => (r1._1 + r2._1, r1._2 + r2._2)
    )

    println(result)

//    rdd1.foreachPartition(part => {
//      val partitionId = TaskContext.getPartitionId()
//      part.foreach(x => {
//        println((partitionId, x._1, x._2))
//      })
//    })

    rdd1.mapPartitionsWithIndex((index, iter) => {
      val arr: ArrayBuffer[(String, Int)] = ArrayBuffer[(String, Int)]()
      iter.foreach(tp => {
        arr.append(tp)
        println(s"rdd1 partition index = $index, value = $tp")
      })
      arr.iterator
    }).count()

    sc.stop()
  }
}
