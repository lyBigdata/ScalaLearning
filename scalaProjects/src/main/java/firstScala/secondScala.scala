package firstScala
import  scala.math._  //导入包 _为通配符
import  scala.collection.mutable.ArrayBuffer

/**
 * Created by LY on 2015/1/12.
 */
class secondScala{
}

object  secondScala{
  def main(args:Array[String]): Unit ={
    val answer=2+2*7 //定义常变量
    val answer1 = answer * 8 //定义可变变量
    println(answer1)

    val test1:Int=123
    val test2:String ="Hello,Scala...."+test1
    print(test2)

    val one1:Double =test1
    println()
    println(one1)
    /* 以val声明的值实际上是一个常量，无法改变它的内容；var声明的可以改变；声明的同时也可以指定
    * 变量的类型
    * */

    var ones,twos=123   //两个变量的值都是123
    val liu ,yu: String=null  //两个变量都是String类型的，并被赋值为null
    println(ones)
    print(twos)
    println(liu + yu )

    println(1.to(10))
    println("Hello".intersect("world"))  //intersect()方法输出两个字符串共同的一组字符
    /*在scala中，我们用方法进行数值间的的转换，而不是强制类型转换*/
    val int=123
    println(int.toDouble)
    println(23.+(323))

    val bigData:BigInt=1234567890
    println(bigData*bigData*bigData)

    println(sqrt(2))
    println(pow(12.0,3.0))
    println(min(23.9,232.0))
    println("hello".distinct)  //distinct方法获取字符串中的不重复字符


    val nums=new Array[Int](8)  //定义长度不变的数组，所有元素被初始化为null
    val all=ArrayBuffer(1323,-89,-879,2324,54,-9,6,465)
    all.foreach(println)
    var first=true
    var  index=0
    var  numTotal=all.length
    while(index<numTotal)
    {
      if(all(index)>0)  index+=1
      else
      {
        if(first)  {first=false;index+=1 }
        else { all.remove(index);numTotal-=1}
      }
    }
    all.foreach(println)
    all.mkString(" and ")

   //val buff=ArrayBuffer[Int]()

    println(Array( 2,3,4,5,67).sum)
   }
}
