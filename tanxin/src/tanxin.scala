/**
 * Created by LY on 2015/5/21.
 */

import scala.io.Source
import java.io.PrintWriter
import scala.collection.mutable.ArrayBuffer

object main
{
  def main(args : Array[String])=
  {
    var jiqi1=new ArrayBuffer[Int]  //用来存放在机器1上运行的工作
    var jiqi2=new ArrayBuffer[Int]  //用来存放在机器2上运行的工作
    var waitTime=new ArrayBuffer[Int] //存放每个作业的等待时间

    var n:Int=0   // 工作的总量初值设为0
    var s:Int=0   //机器的个数初值设为0
    val ServiceTime=new ArrayBuffer[Int]   //保存每个工作的运行时间

    val source=Source.fromFile("input.txt","UTF-8")  //加载文件
    val tokens=source.mkString.split("\\s+")  //以空格分隔分隔
    val numbers=for(i <- tokens) yield i.toInt  //将字符串型的数字转换成整型的数字，保存在数组中
    source.close()  //关闭输入文件

    //数据的预处理部分
    for(index <- 0 until numbers.length) //遍历numbers数组
    {
      if(index==0)
        n=numbers(0)  //读取作业的个数
      else if(index==1)
        s=numbers(1)  //读取机器的个数
      else
        ServiceTime+=numbers(index)  //读取每个作业的运行时间
    }
    val perServiceTime=ServiceTime.sorted//对机器的工作时间由小到大排序

    /*
    println("n="+n)
    println("s="+s)
    for(test1 <- perServiceTime)
      print(test1+" ")
    */

    jiqi1+=(perServiceTime(0)) //将排序后的第一个作业放到机器1运行
    jiqi2+=(perServiceTime(1)) //将排序后的第一个作业放到机器2运行
    waitTime+=(0,0) //前两台机器的等待时间都为0

    //最优选择部分，使得平均等待时间最短
    for(xiabiao <- 2 until perServiceTime.length)  //遍历作业的运行时间数组
    {
      if(jiqi1.sum < jiqi2.sum)  //判断在哪台机器上运行时的等待时间最短
      {
        jiqi1+=perServiceTime(xiabiao)
        waitTime+=jiqi1.sum
      }
      else
      {
        jiqi2+=perServiceTime(xiabiao)
        waitTime+=jiqi2.sum
      }
    }

    /*
    println()
    for(test2 <- jiqi1)
      print(test2+" ")
    println()
    for(test3 <- jiqi2)
      print(test3+" ")
    println()
    for(test4 <- waitTime)
      print(test4+" ")
    */

    val totalTime=waitTime.sum  //计算总共的等待时间
    val perWaitTime:Double=totalTime.toDouble/n.toDouble  //计算平均等待时间

    /*
    println()
    println(totalTime)
    println(perWaitTime)
    */

    val output=new PrintWriter("output.txt")  //创建输出文件
    output.println(perWaitTime)
    output.close()  //关闭输出文件
  }
}