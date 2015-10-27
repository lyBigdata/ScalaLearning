/**
 * Created by LY on 2015/5/26.
 */

import scala.io.Source
import java.io.PrintWriter
import scala.collection.mutable.ArrayBuffer

object  main
{
  val output=new PrintWriter("output.txt")  //创建输出文件
  var resOutPut=new ArrayBuffer[Int]   //结果缓冲数组
  val ServiceTime=new ArrayBuffer[Int]  //存放集合元素
  var n:Int=0   //集合元素的个数，初值设为0
  var c:Int=0   //子集合的目标值，初值设为0
  var flag:Int=0

  def backTrack(index:Int):Unit=
  {
    if(index>=n)
    {
      //处理
      if(resOutPut.sum==c) {  //如果结果集合的和值与目标值相等，则输出
        flag=1
        for (j <- 0.until(resOutPut.length))
        {
          output.print(resOutPut(j)+" ")
        }
        output.println()
      }
    }
    else {
      for (i <- Array(0,1)) {
        if (i == 0) {   //不将次元素放入结果集合
          if (resOutPut.sum <= c) {
            backTrack(index + 1)
          }
        }
        else {   //将次元素放入结果集合
          resOutPut += ServiceTime(index)
          if (resOutPut.sum <= c) {
            backTrack(index + 1)
            resOutPut -= ServiceTime(index)
          }
          else
          {
            resOutPut -= ServiceTime(index)
          }
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val source=Source.fromFile("input.txt","UTF-8")  //加载文件
    val tokens=source.mkString.split("\\s+")  //以空格分隔分隔
    val numbers=for(i <- tokens) yield i.toInt  //将字符串型的数字转换成整型的数字，保存在数组中
    source.close()  //关闭输入文件

    //数据的预处理部分
    for(index <- 0 until numbers.length) //遍历numbers数组
    {
      if(index==0)
        n=numbers(0)  //读取集合元素的个数
      else if(index==1)
        c=numbers(1)  //读取目标值
      else
        ServiceTime+=numbers(index)  //读取集合的元素，保存在ServiceTime数组
    }
    backTrack(0)
    if(flag==0)
      output.println("No Solution!")
    output.close()
  }
}