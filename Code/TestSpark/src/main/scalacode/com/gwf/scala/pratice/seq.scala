package com.gwf.scala.pratice

import scala.collection.mutable.ListBuffer

object seq {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3)
    println(list1)

    // 在 list 前面加元素
    val list2 = 0 :: list1
    println(list2)

    val list3 = list1.::(0)
    println(list3)

    val list4 = 0 +: list1
    println(list4)

    val list5 = list1.+:(0)
    println(list5)

    // 在 list 后面加元素
    val list6 = list1 :+ 2
    println(list6)

    // 合并 list
    val list7 = List(4, 5, 6)
    val list8 = list1 ++ list7
    println(list8)
    // 或者
    val list10 = list1 ::: list7
    println(list10)

    // 把 list7 放到 list1 的前面
    val list9 = list7 ++ list1
    println(list9)


    // 可变序列
    val list11 = ListBuffer(1, 3, 5, 7, 9)
    println(list11)
    list11 += 4
    println(list11)
    list11.append(921)
    println(list11)

    val list12 = ListBuffer(111, 921)
    list11 ++= list12
    println(list11)
  }
}
